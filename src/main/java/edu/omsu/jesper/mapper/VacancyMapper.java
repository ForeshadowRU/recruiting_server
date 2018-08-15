package edu.omsu.jesper.mapper;

import edu.omsu.jesper.enums.SalaryType;
import edu.omsu.jesper.model.Company;
import edu.omsu.jesper.model.Vacancy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;
import java.util.UUID;

public class VacancyMapper implements RowMapper<Vacancy> {

    private final JdbcTemplate template;

    public VacancyMapper(JdbcTemplate template) {
        this.template = template;
    }

    public Vacancy mapRow(ResultSet resultSet, int i) throws SQLException {
        Vacancy vacancy = new Vacancy();
        UUID authorId = UUID.fromString(resultSet.getString("author_id"));
        String sql = "SELECT * FROM `recruiting-server`.companies WHERE id = ?";
        List<Company> list = template.query(sql, new CompanyMapper(), authorId.toString());
        vacancy.setId(UUID.fromString(resultSet.getString("id")));
        vacancy.setName(resultSet.getString("name"));
        vacancy.setFullDescription(resultSet.getString("description"));
        vacancy.setAuthor(list.get(0));
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
