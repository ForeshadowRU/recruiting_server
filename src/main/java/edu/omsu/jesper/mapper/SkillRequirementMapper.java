package edu.omsu.jesper.mapper;

import edu.omsu.jesper.model.SkillRequirement;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class SkillRequirementMapper implements RowMapper<SkillRequirement> {

    @Override
    public SkillRequirement mapRow(ResultSet resultSet, int i) throws SQLException {
        SkillRequirement skillRequirement = new SkillRequirement();
        skillRequirement.setVacancyId(UUID.fromString(resultSet.getString("vacancy_id")));
        skillRequirement.setName(resultSet.getString("name"));
        skillRequirement.setImportant(resultSet.getBoolean("important"));
        skillRequirement.setLevel(resultSet.getInt("level"));
        return skillRequirement;
    }
}
