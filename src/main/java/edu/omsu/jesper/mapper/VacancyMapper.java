package edu.omsu.jesper.mapper;

import edu.omsu.jesper.model.Company;
import edu.omsu.jesper.model.Vacancy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class VacancyMapper implements RowMapper<Vacancy> {

    private final JdbcTemplate jdbcTemplate;

    public VacancyMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Vacancy mapRow(ResultSet resultSet, int i) throws SQLException {
        Vacancy vacancy = new Vacancy();
        UUID id = UUID.fromString(resultSet.getString("authorId"));
        String sql = "SELECT * FROM companies WHERE id = " + "\"" + id.toString() + "\"";
        List<Company> list = jdbcTemplate.query(sql, new CompanyMapper());
        if (list.isEmpty()) throw new SQLException("No company with specified id found");
        vacancy.setId(UUID.fromString(resultSet.getString("id")));
        vacancy.setName(resultSet.getString("name"));
        vacancy.setDescription(resultSet.getString("description"));
        vacancy.setAuthor(list.get(0));
        vacancy.setCreationDate(resultSet.getDate("creationDate"));
        sql = "SELECT * FROM skillrequirements WHERE vacancy_id = ?";

        vacancy.setRequirements(jdbcTemplate.query(sql,
                new SkillRequirementMapper(), vacancy.getId().toString()));

        return vacancy;
    }
}
