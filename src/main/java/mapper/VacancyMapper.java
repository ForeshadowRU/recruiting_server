package mapper;

import model.Company;
import model.SkillRequirement;
import model.Vacancy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlInOutParameter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class VacancyMapper implements RowMapper<Vacancy>{

    private final JdbcTemplate jdbcTemplate;

    public VacancyMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Vacancy mapRow(ResultSet resultSet, int i) throws SQLException {
        Vacancy vacancy = new Vacancy();
        int id = resultSet.getInt("author_id");
        String sql = String.format("SELECT * FROM companies WHERE id = %d ",id);
        List<Company> list = jdbcTemplate.query(sql, new CompanyMapper());
        if (list.isEmpty()) throw new SQLException("No company with specified id found");
        vacancy.setId(resultSet.getInt("id"));
        vacancy.setName(resultSet.getString("name"));
        vacancy.setDescription(resultSet.getString("description"));
        vacancy.setAuthor(list.get(0));

        sql = String.format("SELECT * FROM skill-requirements WHERE vacancy_id = %d",
                resultSet.getInt("id"));
        vacancy.setRequirements(jdbcTemplate.query(sql,
                new SkillRequirementMapper(jdbcTemplate)));

        return vacancy;
    }
}
