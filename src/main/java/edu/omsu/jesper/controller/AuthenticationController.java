package edu.omsu.jesper.controller;

import edu.omsu.jesper.dao.implementations.UserDaoImpl;
import edu.omsu.jesper.dto.LoginRequest;
import edu.omsu.jesper.model.User;
import edu.omsu.jesper.service.interfaces.security.UserAuthenticationService;
import edu.omsu.jesper.validator.DefaultValidator;
import edu.omsu.jesper.validator.HttpError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/public")
public class AuthenticationController {

    private final UserAuthenticationService authentication;
    private final UserDaoImpl userDao;

    @Autowired
    public AuthenticationController(UserAuthenticationService authentication, UserDaoImpl userDao) {
        this.authentication = authentication;
        this.userDao = userDao;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        HttpError error = new HttpError();
        Set<ConstraintViolation<User>> violations = DefaultValidator.validator.validate(user);
        if (!violations.isEmpty()) {

            Map<String, String> errors = new HashMap<>();
            for (ConstraintViolation<User> violation : violations) {
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
            error.setErrors(errors);
            error.setStatus(HttpStatus.BAD_REQUEST);
            error.setMessage("Validation Failed");
            return new ResponseEntity<>(error, error.getStatus());
        }
        try {
            userDao.save(user);
        } catch (DuplicateKeyException ex) {
            error.setMessage("User named ".concat(user.getUsername().concat(" already exist")));
            return new ResponseEntity<>(error, HttpStatus.CONFLICT);
        }
        LoginRequest request = new LoginRequest();
        request.login = user.getUsername();
        request.password = user.getPassword();
        return login(request);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            return new ResponseEntity<>(authentication.getResponse(request.login, request.password), HttpStatus.OK);
        } catch (Exception ex) {
            HttpError error = new HttpError();
            error.setMessage(ex.getMessage());
            return new ResponseEntity<>(error, error.getStatus());
        }
    }
}
