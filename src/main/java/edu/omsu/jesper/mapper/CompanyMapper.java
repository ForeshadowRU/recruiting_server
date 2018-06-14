package edu.omsu.jesper.mapper;

import edu.omsu.jesper.model.Company;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CompanyMapper implements RowMapper<Company> {

    public Company mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Company(resultSet.getInt("id"),
                resultSet.getString("name"),resultSet.getString("email"),
                resultSet.getString("password"));

    }
}
