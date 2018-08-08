package edu.omsu.jesper.mapper;

import edu.omsu.jesper.enums.SalaryType;
import edu.omsu.jesper.model.Company;
import edu.omsu.jesper.model.Vacancy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Currency;
import java.util.List;
import java.util.UUID;

public class VacancyMapper implements RowMapper<Vacancy> {

    private final JdbcTemplate jdbcTemplate;

    public VacancyMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Vacancy mapRow(ResultSet resultSet, int i) throws SQLException {
        Vacancy vacancy = new Vacancy();
        UUID authorId = UUID.fromString(resultSet.getString("author_id"));
        String sql = "SELECT * FROM companies WHERE id = ?";
        List<Company> list = jdbcTemplate.query(sql, new CompanyMapper(), authorId.toString());
        vacancy.setId(UUID.fromString(resultSet.getString("id")));
        vacancy.setName(resultSet.getString("name"));
        vacancy.setDescription(resultSet.getString("description"));
        vacancy.setAuthor(list.get(0));
        vacancy.setCreationDate(resultSet.getDate("creation_date"));
        vacancy.setCurrency(Currency.getInstance(resultSet.getString("currency")));
        vacancy.setType(SalaryType.valueOf(resultSet.getString("type")));
        vacancy.setSalary(resultSet.getDouble("salary_amount"));
        sql = "SELECT * FROM `recruiting-server`.skill_requirements WHERE vacancy_id = ?";

        vacancy.setRequirements(jdbcTemplate.query(sql,
                new SkillRequirementMapper(),
                vacancy.getId().toString()));

        return vacancy;
    }
}
