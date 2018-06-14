package edu.omsu.jesper.dao.interfaces;

import edu.omsu.jesper.model.Company;

import java.util.List;

public interface CompanyDao {

    void save(Company company);

    Company getById(int id);

    List<Company> findAll();

    void update(Company company);

    void delete(int id);

}
