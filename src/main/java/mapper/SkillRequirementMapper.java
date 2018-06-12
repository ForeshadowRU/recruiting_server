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

        SkillRequirement skill = new SkillRequirement();
        skill.setId(resultSet.getInt("id"));
        skill.setLevel(resultSet.getInt("level"));
        String  sql = String.format("SELECT * FROM skill WHERE skill_id = %d",
                resultSet.getInt("skill_id"));
        skill.setSkill(jdbcTemplate.query(sql,new SkillMapper()).get(0));
        skill.setImportant(resultSet.getBoolean("important"));
        return skill;
    }
}
