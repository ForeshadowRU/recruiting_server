package edu.omsu.jesper.model;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class UserValidation {

    private Validator validator;

    @Before
    public void init() {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();
    }

    @Test
    public void valid() {
        User user = new User();
        user.setUsername("jesper");
        user.setPhoneNumber("9604432212");
        user.setEmail("dummy@yandex.ru");
        user.setSecondName("Krasov");
        user.setFirstName("Ilusha");
        user.setAuthorities(Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        assertTrue(violations.isEmpty());

    }

    @Test
    public void username() {
        User user = new User();
        user.setUsername("21");
        Set<ConstraintViolation<User>> violations = validator.validateProperty(user, "username");
        System.out.println(violations.toString());
        assertTrue(!violations.isEmpty());
    }

}