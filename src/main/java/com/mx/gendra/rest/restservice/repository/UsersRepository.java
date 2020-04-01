package com.mx.gendra.rest.restservice.repository;

import com.mx.gendra.rest.restservice.models.Users;

public interface UsersRepository {
    public String create(Users users);
    public String getAllUsers();
}
