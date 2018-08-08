package edu.omsu.jesper.dao.interfaces;

import edu.omsu.jesper.model.Company;
import edu.omsu.jesper.model.SkillRequirement;
import edu.omsu.jesper.model.Vacancy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface VacancyDao {

    List<Vacancy> get();

    List<Vacancy> get(UUID id);

    List<Vacancy> getByAuthor(UUID authorId);

    List<Vacancy> getByAuthor(Company company);

    List<SkillRequirement> getImportantSkills();

    List<SkillRequirement> getSignificantSkills();

    void save(Vacancy vacancy);

    void update(UUID id, Vacancy vacancy);

    void delete(UUID id);


}
