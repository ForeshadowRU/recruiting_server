package edu.omsu.jesper.controller;

import edu.omsu.jesper.dao.interfaces.CompanyDao;
import edu.omsu.jesper.model.Company;
import edu.omsu.jesper.model.User;
import edu.omsu.jesper.validator.DefaultValidator;
import edu.omsu.jesper.validator.HttpError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import java.util.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyDao companyDao;

    @Autowired
    public CompanyController(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @GetMapping("/")
    public List<Company> getAll() {
        return companyDao.get();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@AuthenticationPrincipal User user, @PathVariable("id") String id) {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<?> addCompany(@RequestBody Company company) {
        Set<ConstraintViolation<Company>> violations = DefaultValidator.validator.validate(company);
        if (!violations.isEmpty()) {
            HttpError error = new HttpError();
            Map<String, String> map = new HashMap<>();
            for (ConstraintViolation violation : violations)
                map.put(violation.getPropertyPath().toString(), violation.getMessage());
            error.setErrors(map);
            error.setMessage("Invalid company entity");
            return new ResponseEntity<>(error, error.getStatus());
        } else {

            companyDao.save(company);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id) {
        Company company = companyDao.get(UUID.fromString(id));
        if (company != null) return new ResponseEntity<>(company, HttpStatus.OK);
        HttpError error = new HttpError(HttpStatus.NOT_FOUND, String.format("No company with id %s", id));
        return new ResponseEntity<>(error, error.getStatus());
    }
}
