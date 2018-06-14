package edu.omsu.jesper.dao.interfaces;

import edu.omsu.jesper.model.SkillRequirement;

import java.util.List;

public interface SkillRequirementDao {

    void save(SkillRequirement skillRequirement);

    SkillRequirement getById(int id);

    //List<SkillRequirement> findAll();

    List<SkillRequirement> findAllFromVacancy(int vacancyId);

    void update(SkillRequirement skillRequirement);

    void delete(int id);

}
