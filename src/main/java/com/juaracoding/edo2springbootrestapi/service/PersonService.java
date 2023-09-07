package com.juaracoding.edo2springbootrestapi.service;

import com.juaracoding.edo2springbootrestapi.model.Person;
import com.juaracoding.edo2springbootrestapi.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService {

    private PersonRepo personRepo;


    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public List<Person> findAll(){

        return personRepo.findAll();
    }
}
