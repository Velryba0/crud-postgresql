package com.mx.gendra.rest.restservice.models;

import java.io.Serializable;

public class Users implements Serializable {
    private static final long serialVersionUID = 8602212582376807295L;
    private int id;
    private String name;
    private String lastname;
    private int age;

    protected Users() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

