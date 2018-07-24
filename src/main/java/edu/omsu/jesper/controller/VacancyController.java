package edu.omsu.jesper.controller;

import edu.omsu.jesper.dao.interfaces.CompanyDao;
import edu.omsu.jesper.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@ComponentScan("edu.omsu.jesper.dao.implementations")
@RequestMapping("/")
public class VacancyController {

    @Autowired
    public VacancyController(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    final private CompanyDao companyDao;

    /*  @GetMapping("/vacancies")
      public List<List<Vacancy>> getVisibleVacancies(Model model)
      {
          List<Vacancy> list = vacancyService.findVisible();
          List<List<Vacancy>> rows = new ArrayList<>();
          List<Vacancy> row = new ArrayList<>();
          while(!list.isEmpty())
          {
              for(int i = 0; i < 3 && !list.isEmpty(); i++)
                  row.add(list.remove(0));
              rows.add(row);
              row = new ArrayList<>();
          }
          model.addAttribute("rows", rows);
          return rows;
      }*/
    @GetMapping("/companies")
    public List<Company> getAll() {
        return companyDao.get();
    }

    @GetMapping("/companies/{id}")
    public Company getById(@PathVariable String id) {
        return companyDao.get(UUID.fromString(id));
    }

    @PostMapping("/companies")
    public ResponseEntity add(@RequestBody Company company) {
        companyDao.save(company);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
