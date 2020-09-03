package com.brycestock.bookstoreapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    public static final String DATASOURCE = "bookstore";
    public static final String NAMEDJDBCTEMPLATE = "namedjdbctemplate";

    @Value("org.postgresql.Driver")
    private String driver;

    @Value("${dBURL}")
    private String url;

    @Value("${dbUser}")
    private String username;

    @Value("${dbPassword}")
    private String password;

    @Bean(name = DATASOURCE)
    @Primary
    DataSource dataSource() {
        DataSource dataSource = DataSourceBuilder
                .create()
                .driverClassName(driver)
                .url(url)
                .username(username)
                .password(password)
                .build();
        return new TransactionAwareDataSourceProxy(dataSource);
    }

    @Bean(name = NAMEDJDBCTEMPLATE)
    @Primary
    public NamedParameterJdbcTemplate namedJdbcTemplate() {
        return new NamedParameterJdbcTemplate(dataSource());
    }
}