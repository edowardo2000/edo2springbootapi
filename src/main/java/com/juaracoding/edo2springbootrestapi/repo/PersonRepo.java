package com.juaracoding.edo2springbootrestapi.repo;

import com.juaracoding.edo2springbootrestapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person,Integer> {
    
}
