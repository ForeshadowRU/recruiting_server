package edu.omsu.jesper.dao.implementations;

import edu.omsu.jesper.dao.interfaces.SkillDao;
import edu.omsu.jesper.mapper.SkillMapper;
import edu.omsu.jesper.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SkillDaoImpl implements SkillDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public SkillDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Skill skill) {
        String sql = "INSERT INTO skills(name) VALUES (?);";
        jdbcTemplate.update(sql,skill.getName());
    }

    public Skill getById(int id) {
        return null;
    }

    public List<Skill> findAll() {
        String sql = "SELECT * FROM skills";
        return jdbcTemplate.query(sql,new SkillMapper());
    }

    public void update(Skill skill) {

    }

    public void delete(int id) {

    }
}
