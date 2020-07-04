package com.moctho.mockthoapi.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class persistanceConfiguration {

    @Bean
    public DataSource dataSource(){

        DataSourceBuilder builder =  DataSourceBuilder.create()
        .url("jdbc:postgresql://localhost:5432/confrence_spring")
        .username("postgres")
        .password("@+!Harbeola1");
        System.out.println("see me oga");
        return builder.build();
    }
}
