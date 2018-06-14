package edu.omsu.jesper.controller;

import edu.omsu.jesper.model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.omsu.jesper.service.VacancyService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class VacancyController {

    final private VacancyService vacancyService;
    @Autowired
    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping("/vacancies")
    public String getVisibleVacancies(Model model)
    {
        List<Vacancy> list = vacancyService.findVisible();
        List<List<Vacancy>> rows = new ArrayList<List<Vacancy>>();
        List<Vacancy> row = new ArrayList<Vacancy>();
        while(!list.isEmpty())
        {
            for(int i = 0; i < 3 && !list.isEmpty(); i++)
                row.add(list.remove(0));
            rows.add(row);
            row = new ArrayList<Vacancy>();
        }
        model.addAttribute("rows", rows);
        return "vacancies";
    }
}
