package edu.omsu.jesper.dao.implementations;

import edu.omsu.jesper.dao.interfaces.SkillRequirementDao;
import edu.omsu.jesper.mapper.SkillRequirementMapper;
import edu.omsu.jesper.model.SkillRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SkillRequirementDaoImpl implements SkillRequirementDao {

    private final JdbcTemplate template;
    private String sql;

    @Autowired
    public SkillRequirementDaoImpl(JdbcTemplate template) {
        this.template = template;
    }


    @Override
    public void save(UUID vacancyId, SkillRequirement skillRequirement) {
        sql = "INSERT INTO `recruiting-server`.skill_requirements(vacancy_id, name, level,important)" +
                " values (?,?,?,?)";
        template.update(sql, preparedStatement -> {
            preparedStatement.setString(1, vacancyId.toString());
            preparedStatement.setString(2, skillRequirement.getName());
            preparedStatement.setInt(3, skillRequirement.getLevel());
            preparedStatement.setBoolean(4, skillRequirement.isImportant());
        });
    }

    @Override
    public void update(UUID vacancyId, String skillName, SkillRequirement newValue) {

    }

    @Override
    public void delete(UUID vacancyID, String skillName) {

    }

    @Override
    public List<String> getAllSkills() {
        sql = "SELECT * FROM `recruiting-server`.skill_requirements";
        return template.query(sql, new SkillRequirementMapper()).stream().map(SkillRequirement::getName).distinct().collect(Collectors.toList());
    }
}
