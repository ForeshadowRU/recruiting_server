package dao;

import model.Company;

import java.util.List;

public interface CompanyDao {

    void save(Company company);

    Company getById(int id);

    List<Company> findAll();

    void update(Company company);

    void delete(int id);

}
