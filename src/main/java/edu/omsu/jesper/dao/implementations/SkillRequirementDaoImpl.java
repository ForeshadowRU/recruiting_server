package edu.omsu.jesper.dao.implementations;

import edu.omsu.jesper.dao.interfaces.SkillRequirementDao;
import edu.omsu.jesper.mapper.SkillRequirementMapper;
import edu.omsu.jesper.model.SkillRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class SkillRequirementDaoImpl implements SkillRequirementDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public SkillRequirementDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(SkillRequirement skillRequirement) {

    }

    public SkillRequirement getById(UUID id) {
        return null;
    }

    public List<SkillRequirement> findAllFromVacancy(UUID vacancyId) {
        String sql = "SELECT * FROM skillrequirements WHERE vacancy_id = %d";
        return jdbcTemplate.query(sql, new SkillRequirementMapper(jdbcTemplate), vacancyId.toString());
    }

    public void update(SkillRequirement skillRequirement) {

    }

    public void delete(UUID id) {

    }
}
