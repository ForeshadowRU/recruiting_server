package edu.omsu.jesper.dao.interfaces;

import edu.omsu.jesper.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface CompanyDao {

    List<Company> get();

    List<Company> get(int amount);

    Company get(UUID id);

    void save(Company company);

    void update(UUID id, Company newValue);

    void delete(UUID id);

}
