package org.banking.accountservice;

import jakarta.annotation.PostConstruct;
import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.SQLException;
import java.util.Arrays;

@SpringBootApplication
public class AccountServiceApplication {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }


    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server inMemoryH2DatabaseaServer() throws SQLException {
        return Server.createTcpServer(
                "-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
    }

    /*@PostConstruct
    private void initDb() {
        String sqlStatements[] = {
                "drop table customer if exists",
                "create table customer(id varchar(255),name varchar(255),surname varchar(255))",
                "insert into customer(id, name, surname) values('1', 'Bob','Schalp')",
                "insert into customer(id, name, surname) values('2', 'Jenny','Donald')",
                *//*"insert into account(id, name, surname) values(1,'Tony','Simon')"*//*
        };

        Arrays.asList(sqlStatements).forEach(sql -> {
            jdbcTemplate.execute(sql);
        });

    }*/

}
