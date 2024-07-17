package com.example.gpgpBack.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("default")
    public DataSource runtimeDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:h2:mem:runtime;DB_CLOSE_DELAY=-1")
                .username("sa")
                .password("password")
                .driverClassName("org.h2.Driver")
                .build();
    }

    @Bean
    @Profile("test")
    public DataSource testDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1")
                .username("sa")
                .password("sa")
                .driverClassName("org.h2.Driver")
                .build();
    }
}