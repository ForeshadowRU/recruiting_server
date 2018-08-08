package edu.omsu.jesper.controller;

import edu.omsu.jesper.dao.interfaces.CompanyDao;
import edu.omsu.jesper.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyDao companyDao;

    @Autowired
    public CompanyController(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/")
    public List<Company> getAll() {

        return companyDao.get();

    }

    @GetMapping("/companies/{id}")
    public Company getById(@PathVariable String id) {

        return companyDao.get(UUID.fromString(id));
    }

    @PostMapping("/")
    public ResponseEntity add(@RequestBody Company company) {
        companyDao.save(company);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
