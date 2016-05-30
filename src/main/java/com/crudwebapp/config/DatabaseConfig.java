package com.crudwebapp.config;

import java.io.IOException;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author nikesh.maharjan
 */
@Configuration
@ComponentScan(basePackages = "com.crudwebapp.config")
@PropertySource(value = "classpath:credentials.properties")
public class DatabaseConfig {

//    private final String HOST = "jdbc:sqlserver://10.13.212.13:1433;databaseName=crud_test_nikesh";
//    private final String USER = "fonebank";
//    private final String PASS = "fonebank";

    @Resource
    private Environment env;

    @Bean
    public DataSource dataSource() throws IOException {
        System.out.println("HOST " + env.getProperty("jdbc.host"));
        DriverManagerDataSource dataSource = new DriverManagerDataSource(env.getProperty("jdbc.host"), env.getProperty("jdbc.username"), env.getProperty("jdbc.password"));
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));
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
