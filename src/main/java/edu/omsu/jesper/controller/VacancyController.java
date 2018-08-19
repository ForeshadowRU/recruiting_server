package edu.omsu.jesper.controller;

import edu.omsu.jesper.dao.interfaces.VacancyDao;
import edu.omsu.jesper.model.Vacancy;
import edu.omsu.jesper.service.interfaces.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@ComponentScan("edu.omsu.jesper.dao.implementations")
@RequestMapping("/vacancies")
public class VacancyController {

    private final VacancyDao dao;
    private final VacancyService service;

    @Autowired
    public VacancyController(VacancyDao dao, VacancyService service) {
        this.dao = dao;
        this.service = service;
    }

    @GetMapping("/")
    public List<Vacancy> getVisibleVacancies() {
        return dao.get();
    }

    @GetMapping("/{id}")
    public Vacancy get(@PathVariable String id) {
        return dao.get(UUID.fromString(id));
    }

    @GetMapping("/author/{authorId}")
    public List<Vacancy> getByAuthor(@PathVariable UUID authorId) {
        return dao.getByAuthor(authorId);
    }

    @PostMapping("/condition")
    public List<Vacancy> getAllThatRequireSkills(@RequestBody List<String> skills) {
        List<String> validated = new ArrayList<>();
        for (String skill : skills)
            validated.add(skill.toLowerCase());

        return service.requireSkills(validated);
    }

}
