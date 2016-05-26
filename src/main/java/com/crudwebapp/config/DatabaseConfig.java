package com.crudwebapp.config;

import java.io.IOException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author nikesh.maharjan
 */
@Configuration
@ComponentScan(basePackages = "com.crudwebapp.config")
@PropertySource(value = "classpath:credentials.properties", ignoreResourceNotFound = true)
public class DatabaseConfig {

    private final String HOST = "jdbc:sqlserver://10.13.212.13:1433;databaseName=crud_test_nikesh";
    private final String USER = "fonebank";
    private final String PASS = "fonebank";

    @Value("${jdbc.host}")
    private String host;

    @Bean
    public DataSource dataSource() throws IOException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource(HOST, USER, PASS);
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return dataSource;
    }

    @Bean
    @Autowired
    public JdbcOperations getJdbcTemplate(DataSource datasource) {
        return new JdbcTemplate(datasource);
    }

    //To resolve ${} in @Value
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
