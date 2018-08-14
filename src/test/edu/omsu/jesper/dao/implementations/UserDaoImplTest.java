package edu.omsu.jesper.dao.implementations;

import edu.omsu.jesper.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class UserDaoImplTest {

    private JdbcTemplate template;
    private UserDaoImpl dao;


    @Before
    public void init() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://omsu-projects.mysql.database.azure.com:3306/recruiting-server?useSSL=true&requireSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("jesper@omsu-projects");
        dataSource.setPassword("Iey4waetie6geen");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setSchema("recruiting-server");
        template = new JdbcTemplate(dataSource);
        dao = new UserDaoImpl(template);

    }

    @Test
    public void updateSingle() {
        try {
            User user = new User();
            user.setUsername("test");
            user.setPhoneNumber("9604432212");
            user.setEmail("dummy@yandex.ru");
            user.setPassword("!PRIVET!");
            user.setSecondName("Krasov");
            user.setFirstName("Ilusha");
            user.setAuthorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
            dao.save(user);
            user.setFirstName("CleverBoy");
            dao.update("test", user);
            User test = dao.get("test");
            assertEquals("CleverBoy", test.getFirstName());
        } finally {
            dao.delete("test");
        }
    }

    @Test
    public void getDifference() {

        try {
            User user = new User();
            user.setUsername("test");
            user.setPhoneNumber("9604432212");
            user.setEmail("dummy@yandex.ru");
            user.setPassword("!PRIVET!");
            user.setSecondName("Krasov");
            user.setFirstName("Ilusha");
            user.setAuthorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
            dao.save(user);
            User newUser = new User(user);
            newUser.setEmail("notDummy@yandex.ru");
            Map<String, Object> difference = dao.getDifference("test", newUser);
            HashMap<Object, Object> expected = new HashMap<>();
            expected.put("email", "notDummy@yandex.ru");
            assertEquals(expected, difference);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            dao.delete("test");
        }

    }
}