package edu.omsu.jesper.model;

import org.junit.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void copy() {
        User user = new User();
        user.setUsername("test");
        user.setPhoneNumber("9604432212");
        user.setEmail("dummy@yandex.ru");
        user.setPassword("!PRIVET!");
        user.setSecondName("Krasov");
        user.setFirstName("Ilusha");
        user.setAuthorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        User user1 = new User(user);
        assertEquals(user, user1);
    }

}