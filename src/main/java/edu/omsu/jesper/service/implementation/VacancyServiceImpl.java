
package edu.omsu.jesper.service.implementation;

import edu.omsu.jesper.dao.interfaces.VacancyDao;
import edu.omsu.jesper.model.SkillRequirement;
import edu.omsu.jesper.model.Vacancy;
import edu.omsu.jesper.service.interfaces.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacancyServiceImpl implements VacancyService {

    private final VacancyDao dao;

    @Autowired
    public VacancyServiceImpl(VacancyDao dao) {
        this.dao = dao;
    }


    @Override
    public List<Vacancy> requireSkills(List<String> skills) {
        return dao.get().stream().filter((vacancy -> {
            List<String> skillNames = vacancy.getRequirements().stream().map(SkillRequirement::getName).collect(Collectors.toList());
            return skillNames.containsAll(skills);
        }
        )).collect(Collectors.toList());
    }
}
