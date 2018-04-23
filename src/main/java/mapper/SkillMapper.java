package mapper;

import model.Skill;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillMapper implements RowMapper<Skill>{

    public Skill mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Skill(resultSet.getInt("id"),
                resultSet.getString("name"));
    }
}
