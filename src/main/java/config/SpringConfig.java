package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"dao.implementations", "service", "dao", "dao.interfaces"})
public class SpringConfig {
    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://eu-cdbr-west-02.cleardb.net:3306/heroku_4c0ae4e7e988136?reconnect=true");
        dataSource.setUsername("ba55de07dc3b21");
        dataSource.setPassword("b396563fc2c10f3");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setSchema("spring");
        return dataSource;
    }

}
