package service;

import dao.interfaces.VacancyDao;
import model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VacancyServiceImpl implements VacancyService {

    private final VacancyDao vacancyDao;
    @Autowired
    public VacancyServiceImpl(VacancyDao vacancyDao) {
        this.vacancyDao = vacancyDao;
    }

    public List<Vacancy> findAll() {
        return vacancyDao.findAll();
    }

    public List<Vacancy> findVisible() {
        return vacancyDao.findVisible();
    }

    public List<Vacancy> findAllOfCompany(int companyId) {
        return vacancyDao.findAllOfCompany(companyId);
    }

    public void save(Vacancy vacancy) throws Exception {
        vacancyDao.save(vacancy);
    }

    public Vacancy getById(int id) {
        return null;
    }

    public void update(Vacancy vacancy) {

    }

    public void delete(int id) {

    }
}
