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
        dataSource.setUrl("jdbc:mysql://us-cdbr-iron-east-04.cleardb.net/heroku_cf3d0b7baed81fe?reconnect=true");
        dataSource.setUsername("bc6fd1fa7761e4");
        dataSource.setPassword("b4892461");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }

}
