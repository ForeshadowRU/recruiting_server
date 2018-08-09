package edu.omsu.jesper.controller;

import edu.omsu.jesper.dao.interfaces.VacancyDao;
import edu.omsu.jesper.model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@ComponentScan("edu.omsu.jesper.dao.implementations")
@RequestMapping("/vacancies")
public class VacancyController {

    private final VacancyDao dao;

    @Autowired
    public VacancyController(VacancyDao dao) {
        this.dao = dao;
    }

    @GetMapping("/")
    public List<Vacancy> getVisibleVacancies() {
        return dao.get();
    }

    @GetMapping("/{id}")
    public List<Vacancy> get(@PathVariable String id) {
        return dao.get(UUID.fromString(id));
    }

}
