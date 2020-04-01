package com.mx.gendra.rest.restservice.service;

import com.mx.gendra.rest.restservice.models.Users;
import com.mx.gendra.rest.restservice.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImplementation implements UsersService {
    private static final Logger log = LoggerFactory.getLogger(UsersServiceImplementation.class);

    @Autowired
    private UsersRepository repo;

    @Override
    public String obtainData(Users data) {
        String resp = "";
        if(log.isTraceEnabled()) {
            log.trace(data.toString());
        }
        resp = repo.create(data);
        return resp;
    }

    @Override
    public String obtainAllData(Users data) {
        String resp = "";
        if(log.isTraceEnabled()) {
            log.trace(data.toString());
        }
        resp = repo.getAllUsers();
        return resp;
    }
}
