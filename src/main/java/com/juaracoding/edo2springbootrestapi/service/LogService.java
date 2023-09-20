package com.juaracoding.edo2springbootrestapi.service;

import com.juaracoding.edo2springbootrestapi.model.LogRequest;
import com.juaracoding.edo2springbootrestapi.repo.LogRequestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LogService {

    private LogRequestRepo logRequestRepo;

    @Autowired
    public LogService(LogRequestRepo logRequestRepo) {
        this.logRequestRepo = logRequestRepo;
    }

    public void saveLog(LogRequest logRequest)
    {
        logRequestRepo.save(logRequest);
    }
}
