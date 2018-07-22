package edu.omsu.jesper.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"edu.omsu.jesper.dao.implementations", "edu.omsu.jesper.service", "edu.omsu.jesper.dao", "edu.omsu.jesper.dao.interfaces"})
public class SpringConfig {
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("spring.datasource.url");
        dataSource.setUsername("spring.datasource.username");
        dataSource.setPassword("spring.datasource.password");
        return dataSource;
    }

}
