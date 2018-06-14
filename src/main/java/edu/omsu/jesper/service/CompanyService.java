package edu.omsu.jesper.service;

import edu.omsu.jesper.model.Company;


import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    void save(Company user) throws Exception;

    Company getById(int id);

    void update(Company user);

    void delete(int id);


}
