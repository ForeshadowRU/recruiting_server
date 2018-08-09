package edu.omsu.jesper.service.interfaces;

import edu.omsu.jesper.model.Vacancy;

import java.util.List;

public interface VacancyService {

    List<Vacancy> requireSkills(List<String> skills);

}
