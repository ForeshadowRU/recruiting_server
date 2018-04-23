package dao.interfaces;

import model.Skill;

import java.util.List;

public interface SkillDao{

    void save(Skill user);

    Skill getById(int id);

    List<Skill> findAll();

    void update(Skill user);

    void delete(int id);

}
