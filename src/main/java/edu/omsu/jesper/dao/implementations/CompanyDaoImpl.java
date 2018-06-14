package edu.omsu.jesper.dao.implementations;

import edu.omsu.jesper.dao.interfaces.CompanyDao;
import edu.omsu.jesper.mapper.CompanyMapper;
import edu.omsu.jesper.model.Company;
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
        String sql = "INSERT INTO heroku_cf3d0b7baed81fe.users(name, email, password, user_type) VALUES (?, ?, ?,'TYPE_COMPANY')";
        jdbcTemplate.update(sql,company.getName(),company.getEmail(),company.getPassword());
    }

    public Company getById(int id) {
        return null;
    }

    public List<Company> findAll() {
        String sql = "SELECT * FROM heroku_cf3d0b7baed81fe.users WHERE user_type = 'TYPE_COMPANY';";
        return jdbcTemplate.query(sql, new CompanyMapper());

    }

    public void update(Company user) {

    }

    public void delete(int id) {

    }
}
