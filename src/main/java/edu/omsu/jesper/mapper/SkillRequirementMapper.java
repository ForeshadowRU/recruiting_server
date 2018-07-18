package edu.omsu.jesper.mapper;

import edu.omsu.jesper.model.SkillRequirement;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SkillRequirementMapper implements RowMapper<SkillRequirement> {
    private final JdbcTemplate jdbcTemplate;

    public SkillRequirementMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public SkillRequirement mapRow(ResultSet resultSet, int i) throws SQLException {
        SkillRequirement skillRequirement = new SkillRequirement();
        skillRequirement.setId(UUID.fromString(resultSet.getString("id")));
        skillRequirement.setName(resultSet.getString("name"));
        skillRequirement.setImportant(resultSet.getBoolean("isImportant"));
        skillRequirement.setLevel(resultSet.getInt("requiredLevel"));
        return skillRequirement;
    }
}
