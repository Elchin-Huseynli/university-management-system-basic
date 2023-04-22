package com.ums.universitymanagementsystemweb.config;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConfig {
    @SneakyThrows
    public Connection getConnect() {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/ums";
        String username = "postgres";
        String password = "h.elcin78";
        return DriverManager.getConnection(url, username, password);
    }
}
