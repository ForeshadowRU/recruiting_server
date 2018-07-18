package edu.omsu.jesper.dao.interfaces;

import edu.omsu.jesper.model.SkillRequirement;

import java.util.List;
import java.util.UUID;

public interface SkillRequirementDao {

    void save(SkillRequirement skillRequirement);

    SkillRequirement getById(UUID id);

    //List<SkillRequirement> getAll();

    List<SkillRequirement> findAllFromVacancy(UUID vacancyId);

    void update(SkillRequirement skillRequirement);

    void delete(UUID id);

}
