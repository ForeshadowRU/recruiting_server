package edu.omsu.jesper.mapper;

import edu.omsu.jesper.enums.SalaryType;
import edu.omsu.jesper.model.Vacancy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.UUID;

public class VacancyMapper implements RowMapper<Vacancy> {

    private final JdbcTemplate template;

    public VacancyMapper(JdbcTemplate template) {
        this.template = template;
    }

    public Vacancy mapRow(ResultSet resultSet, int i) throws SQLException {
        String sql;
        Vacancy vacancy = new Vacancy();
        vacancy.setId(UUID.fromString(resultSet.getString("id")));
        vacancy.setName(resultSet.getString("name"));
        vacancy.setDescription(resultSet.getString("description"));
        vacancy.setAuthorId(UUID.fromString(resultSet.getString("author_id")));
        vacancy.setCreationDate(LocalDateTime.parse(resultSet.getString("creation_date")));
        vacancy.setCurrency(Currency.getInstance(resultSet.getString("currency")));
        vacancy.setType(SalaryType.valueOf(resultSet.getString("type")));
        vacancy.setSalary(resultSet.getDouble("salary_amount"));
        vacancy.setPublisher(resultSet.getString("publisher"));
        sql = "SELECT * FROM `recruiting-server`.skill_requirements WHERE vacancy_id = ?";

        vacancy.setRequirements(template.query(sql,
                new SkillRequirementMapper(),
                vacancy.getId().toString()));

        return vacancy;
    }
}
