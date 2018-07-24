package edu.omsu.jesper.dao.interfaces;

import edu.omsu.jesper.model.SkillRequirement;

import java.util.List;
import java.util.UUID;

public interface SkillRequirementDao {

    void save(UUID vacancyId, SkillRequirement skillRequirement);

    void update(UUID vacancyId, String skillName, SkillRequirement newValue);

    void delete(UUID vacancyID, String skillName);

    List<String> getAllSkills();

}
