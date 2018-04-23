package service;

import dao.interfaces.CompanyDao;
import model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {


    private final CompanyDao companyDao;

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    public List<Company> findAll() {
        return companyDao.findAll();
    }

    public void save(Company company) throws Exception {
        if (company.getName().length() < 2) {
            throw new Exception();
        }
        companyDao.save(company);
    }

    public Company getById(int id) {
        return companyDao.getById(id);
    }

    public void update(Company company) {
        companyDao.update(company);
    }

    public void delete(int id) {
        companyDao.delete(id);

    }
}