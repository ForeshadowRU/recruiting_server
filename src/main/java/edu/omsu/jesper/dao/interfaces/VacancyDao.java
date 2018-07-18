package edu.omsu.jesper.dao.interfaces;

import edu.omsu.jesper.model.Vacancy;

import java.util.List;

public interface VacancyDao {

    List<Vacancy> getAll();

    List<Vacancy> getAllVisible();

    List<Vacancy> getByCompany(int companyId);

    void save(Vacancy vacancy) throws Exception;

    Vacancy getById(int id);

    void update(Vacancy vacancy);

    void delete(int id);

}