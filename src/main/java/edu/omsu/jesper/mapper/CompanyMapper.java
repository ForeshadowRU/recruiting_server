package edu.omsu.jesper.mapper;

import edu.omsu.jesper.model.Company;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CompanyMapper implements RowMapper<Company> {

    public Company mapRow(ResultSet resultSet, int i) throws SQLException {
        Company company = new Company();
        company.setName(resultSet.getString("name"));
        company.setEmail(resultSet.getString("email"));
        company.setId(UUID.fromString(resultSet.getString("id")));
        return company;
    }
}
