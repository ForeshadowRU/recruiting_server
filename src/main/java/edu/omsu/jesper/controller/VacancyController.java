package edu.omsu.jesper.controller;

import edu.omsu.jesper.model.Vacancy;
import edu.omsu.jesper.service.interfaces.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class VacancyController {

    final private VacancyService vacancyService;
    @Autowired
    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping("/vacancies")
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
    }
}
