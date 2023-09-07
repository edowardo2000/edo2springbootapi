package com.juaracoding.edo2springbootrestapi.util;

import com.juaracoding.edo2springbootrestapi.model.LogRequest;
import com.juaracoding.edo2springbootrestapi.repo.LogRequestRepo;

public class LogTable {

    private LogRequestRepo logRequestRepo;

    public static void inputLogRequest(LogRequestRepo logRequestRepo,String[] datax,Exception e, String flag)
    {
        if(flag.equalsIgnoreCase("y"))
        {
            LogRequest logRequest = new LogRequest();
            logRequest.setDataRequest(datax[1]);
            logRequest.setCreatedBy(1L);
            logRequest.setClassName(datax[0]);
            logRequest.setErrorMessagez(e.getMessage());
            logRequest.setErrorMessagez(e.getMessage());
            logRequestRepo.save(logRequest);
        }
    }
}