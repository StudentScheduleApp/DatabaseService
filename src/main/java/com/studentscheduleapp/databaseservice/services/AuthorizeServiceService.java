package com.studentscheduleapp.databaseservice.services;

import com.studentscheduleapp.databaseservice.properties.GlobalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AuthorizeServiceService {
    @Autowired
    private GlobalProperties globalProperties;

    public boolean authorize(String token){
        return globalProperties.getServiceToken().equals(token);
    }
}
