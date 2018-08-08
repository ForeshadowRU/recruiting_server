package edu.omsu.jesper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;


@ComponentScan(basePackages = {"edu.omsu.jesper.dao.implementations", "edu.omsu.jesper.service", "edu.omsu.jesper.dao", "edu.omsu.jesper.dao.interfaces"})
@Configuration
public class SpringConfig {
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://omsu-projects.mysql.database.azure.com:3306/recruiting-server?useSSL=true&requireSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("jesper@omsu-projects");
        dataSource.setPassword("Iey4waetie6geen");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setSchema("recruiting-server");
        return dataSource;
    }

}
