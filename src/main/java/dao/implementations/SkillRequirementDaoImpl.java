package dao.implementations;

import dao.interfaces.SkillRequirementDao;
import mapper.SkillRequirementMapper;
import model.SkillRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SkillRequirementDaoImpl implements SkillRequirementDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public SkillRequirementDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(SkillRequirement skillRequirement) {

    }

    public SkillRequirement getById(int id) {
        return null;
    }

    public List<SkillRequirement> findAllFromVacancy(int vacancyId) {
        String sql = String.format("SELECT * FROM skill_requirement WHERE vacancy_id = %d",vacancyId);
        return jdbcTemplate.query(sql,new SkillRequirementMapper(jdbcTemplate));
    }

    public void update(SkillRequirement skillRequirement) {

    }

    public void delete(int id) {

    }
}
