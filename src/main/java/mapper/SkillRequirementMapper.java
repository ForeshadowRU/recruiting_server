package mapper;

import model.SkillRequirement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillRequirementMapper implements RowMapper<SkillRequirement> {

    private final JdbcTemplate jdbcTemplate;

    public SkillRequirementMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SkillRequirement mapRow(ResultSet resultSet, int i) throws SQLException {


        return null;
    }
}
