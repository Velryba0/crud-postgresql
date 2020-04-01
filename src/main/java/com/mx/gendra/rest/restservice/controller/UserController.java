package com.mx.gendra.rest.restservice.controller;

import com.mx.gendra.rest.restservice.models.Users;
import com.mx.gendra.rest.restservice.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UsersService usersService;

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> allUsers(Users data) {
        try {
            String resp = usersService.obtainAllData(data);
            if (resp != "ok") {
                return new ResponseEntity<>("{\"status\":\"" + resp + "\"}", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("{\"status\":\"Ok\"}", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("{\"status\":\"Error\", \"mensaje\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> userForm(@RequestBody Users data) {
        //System.out.println(data);
        try {
            String resp = usersService.obtainData(data);
            if (resp != "ok") {
                return new ResponseEntity<>("{\"status\":\"" + resp + "\"}", HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>("{\"status\":\"Ok\"}", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("{\"status\":\"Error\", \"mensaje\":\"" + e.getMessage() + "\"}", HttpStatus.BAD_REQUEST);
        }
    }
}
