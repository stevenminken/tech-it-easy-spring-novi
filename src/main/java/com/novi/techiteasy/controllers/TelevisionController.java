package com.novi.techiteasy.controllers;

import com.novi.techiteasy.exceptions.RecordNotFoundException;
import com.novi.techiteasy.exceptions.TelevisionFormatException;
import com.novi.techiteasy.models.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/televisions")
public class TelevisionController {

    private final ArrayList<Television> televisionDatabase = new ArrayList<>();

    public TelevisionController() {

    }

    @GetMapping
    public ResponseEntity<List<Television>> getTelevisions() {
        return new ResponseEntity<>(televisionDatabase, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable int id) {
        if (id <= 0 || id > televisionDatabase.size() - 1) {
            throw new RecordNotFoundException("ID index is out of bounds");
        } else {
            return new ResponseEntity<>(televisionDatabase.get(id), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Television> addTelevision(@RequestBody Television t) {
        if (t.getBrand().length() > 20) {
            throw new TelevisionFormatException("Brand exceeds the max of 20 characters");
        } else {
            televisionDatabase.add(t);
            return new ResponseEntity<>(t, HttpStatus.CREATED);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@RequestBody Television t, @PathVariable int id) {
        if (id <= 0 || id > televisionDatabase.size() - 1) {
            throw new RecordNotFoundException("ID index is out of bounds");
        } else {
            televisionDatabase.set(id, t);
            return new ResponseEntity<>(t, HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Television> deleteTelevision(@PathVariable int id) {
        if (id <= 0 || id > televisionDatabase.size() - 1) {
            throw new RecordNotFoundException("ID index is out of bounds");
        } else {
            televisionDatabase.remove(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
//
//@RestController
//@RequestMapping("/api/users")
//public class UserController {
//    @Autowired
//    private UserRepository userRepository;
//
//    @GetMapping
//    public List<User> getUsers() {
//        return userRepository.findAll();
//    }
//
//    // other controller methods
//}

