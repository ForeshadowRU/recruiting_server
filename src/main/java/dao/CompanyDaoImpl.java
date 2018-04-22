package dao;

import model.Company;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CompanyDaoImpl implements CompanyDao {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CompanyDaoImpl(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Company company) {

    }

    public Company getById(int id) {
        return null;
    }

    public List<Company> findAll() {
        return null;
    }

    public void update(Company user) {

    }

    public void delete(int id) {

    }
}
