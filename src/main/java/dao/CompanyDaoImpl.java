package dao;

import mapper.CompanyMapper;
import model.Company;
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
        String sql = "INSERT INTO spring.companies(name, email, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,company.getName(),company.getEmail(),company.getPassword());
    }

    public Company getById(int id) {
        return null;
    }

    public List<Company> findAll() {
        String sql = "SELECT * FROM spring.companies;";
        return jdbcTemplate.query(sql, new CompanyMapper());

    }

    public void update(Company user) {

    }

    public void delete(int id) {

    }
}
