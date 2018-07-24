package edu.omsu.jesper.dao.implementations;

import edu.omsu.jesper.dao.interfaces.CompanyDao;
import edu.omsu.jesper.mapper.CompanyMapper;
import edu.omsu.jesper.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
@ComponentScan("edu.omsu.jesper.config")
public class CompanyDaoImpl implements CompanyDao {


    @Qualifier("JDBC")

    private final JdbcTemplate template;
    private String sql;

    @Autowired
    public CompanyDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Company> get() {
        sql = "SELECT * FROM `recruiting-server`.companies";
        return template.query(sql, new CompanyMapper());
    }

    @Override
    public List<Company> get(int amount) {
        sql = "SELECT * FROM `recruiting-server`.companies " +
                "LIMIT " + amount + ";";
        return template.query(sql, new CompanyMapper());
    }

    @Override
    public Company get(UUID id) {
        sql = "SELECT * FROM `recruiting-server`.companies WHERE id = ?";
        List<Company> query = template.query(sql, new CompanyMapper(), id.toString());
        return (query.isEmpty()) ? null : query.get(0);
    }

    @Override
    public void save(Company company) {
        sql = "INSERT INTO `recruiting-server`.companies(id, name, contact_email, registration_date, foundation_date) " +
                "values(?,?,?,?,?)";
        template.update(sql, preparedStatement -> {
            preparedStatement.setString(1, company.getId().toString());
            preparedStatement.setString(2, company.getName());
            preparedStatement.setString(3, company.getEmail());
            preparedStatement.setDate(4, Date.valueOf(company.getRegistrationDate()));
            preparedStatement.setDate(5, Date.valueOf(company.getFoundationDate()));
        });
    }

    @Override
    public void update(UUID id, Company newValue) {

    }

    @Override
    public void delete(UUID id) {

    }
}
