package edu.omsu.jesper.controller;

import edu.omsu.jesper.dao.interfaces.VacancyDao;
import edu.omsu.jesper.dto.PostVacancyRequest;
import edu.omsu.jesper.model.Vacancy;
import edu.omsu.jesper.service.interfaces.VacancyService;
import edu.omsu.jesper.validator.DefaultValidator;
import edu.omsu.jesper.validator.HttpError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import java.time.LocalDateTime;
import java.util.*;

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

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/")
    public ResponseEntity<?> postVacancy(@RequestBody PostVacancyRequest request) {
        Vacancy vacancy = new Vacancy();
        vacancy.setId(UUID.randomUUID());
        vacancy.setHidden(request.hidden);
        vacancy.setPublisher(request.publisher);
        vacancy.setAuthorId(request.author);
        vacancy.setRequirements(request.requirements);
        vacancy.setCurrency(request.currency);
        vacancy.setName(request.name);
        vacancy.setCreationDate(LocalDateTime.now());
        vacancy.setDescription(request.description);
        vacancy.setType(request.type);
        vacancy.setSalary(request.salary);
        Set<ConstraintViolation<Vacancy>> validate = DefaultValidator.validator.validate(vacancy);
        if (!validate.isEmpty()) {
            HttpError error = new HttpError();
            Map<String, String> map = new HashMap<>();
            for (ConstraintViolation violation : validate)
                map.put(violation.getPropertyPath().toString(), violation.getMessage());
            error.setErrors(map);
            error.setMessage("Validation Failed");
            return new ResponseEntity<>(error, error.getStatus());
        }
        dao.save(vacancy);
        return new ResponseEntity<>(vacancy, HttpStatus.ACCEPTED);
    }

    @PostMapping("/condition")
    public List<Vacancy> getAllThatRequireSkills(@RequestBody List<String> skills) {
        List<String> validated = new ArrayList<>();
        for (String skill : skills)
            validated.add(skill.toLowerCase());

        return service.requireSkills(validated);
    }

}
