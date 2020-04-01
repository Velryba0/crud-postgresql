package com.mx.gendra.rest.restservice.repository;

import com.mx.gendra.rest.restservice.configuration.DBParameters;
import com.mx.gendra.rest.restservice.models.Users;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UsersRepositoryImplementation implements UsersRepository {

    private static final Logger log = LoggerFactory.getLogger(UsersRepositoryImplementation.class);
    private DataSource ds;

    @Autowired
    private DBParameters db;

    private  void configDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(String.format("jdbc:postgresql:///%s", db.getName()));
        config.setUsername(db.getUser());
        config.setPassword(db.getPass());
        ds = new HikariDataSource(config);
    }

    @Override
    public String getAllUsers() {
       return "Aquí irán los resultados en JSON";
    }

    @Override
    public String create(Users user) {

        String response = "";

        configDataSource();
        try (Connection conn = ds.getConnection()) {
            try (PreparedStatement statement = conn
            .prepareStatement("INSERT INTO proveedores (firstname, lastname, age) VALUES (?, ?, ?)")) {
                statement.setString(1, user.getName());
                statement.setString(2, user.getLastname());
                statement.setInt(3, user.getAge());
                int resp = statement.executeUpdate();
                if (resp != 0) {
                    response = "ok";
                }
            } catch (SQLException e) {
                log.error("Error al obtener la información: {}", e.getMessage());
                response = e.getMessage();
            }
            return response;
        } catch (SQLException e) {
            log.error("Error al obtener la información: {}", e.getMessage());
            response = e.getMessage();
        }
        return response;
    }
}
