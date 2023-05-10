package com.novi.techiteasy.repositories;

import com.novi.techiteasy.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TelevisionRepository extends JpaRepository<Television, Long> {
    Optional<Television> findByBrand(String Brand);
}
//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords
//save(Enitity entity)
//findById(Long id)

//@Query(“Select b from books b where title=:title and genre=:genre")
//
