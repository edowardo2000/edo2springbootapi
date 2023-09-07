package com.juaracoding.edo2springbootrestapi.repo;

import com.juaracoding.edo2springbootrestapi.model.LogRequest;
import org.springframework.data.repository.CrudRepository;


public interface LogRequestRepo extends CrudRepository<LogRequest,Long> {
    
}