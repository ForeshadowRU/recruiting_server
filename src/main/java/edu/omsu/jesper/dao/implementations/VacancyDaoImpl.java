package edu.omsu.jesper.dao.implementations;

import edu.omsu.jesper.dao.interfaces.VacancyDao;
import edu.omsu.jesper.mapper.SkillRequirementMapper;
import edu.omsu.jesper.mapper.VacancyMapper;
import edu.omsu.jesper.model.Company;
import edu.omsu.jesper.model.SkillRequirement;
import edu.omsu.jesper.model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VacancyDaoImpl implements VacancyDao {

    private final JdbcTemplate template;


    @Autowired
    public VacancyDaoImpl(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Vacancy> get() {
        String sql = "SELECT id,name,description,author_id,hidden,creation_date,amount as 'salary_amount', type,currency" +
                " FROM `recruiting-server`.vacancies RIGHT JOIN `recruiting-server`.salaries on vacancies.id = salaries.vacancy_id";
        return template.query(sql, new VacancyMapper(template));
    }

    @Override
    public List<Vacancy> get(UUID id) {
        String sql = "SELECT * FROM `recruiting-server`.vacancies WHERE id = ?";
        return template.query(sql, new VacancyMapper(template), id.toString());
    }

    @Override
    public List<Vacancy> getByAuthor(UUID authorId) {
        String sql = "SELECT * FROM `recruiting-server`.vacancies WHERE author_id = ?";
        return template.query(sql, new VacancyMapper(template), authorId.toString());
    }

    @Override
    public List<Vacancy> getByAuthor(Company company) {
        String sql = "SELECT * FROM `recruiting-server`.vacancies WHERE author_id = ?";
        return template.query(sql, new VacancyMapper(template), company.getId().toString());
    }

    @Override
    public List<SkillRequirement> getImportantSkills(Vacancy vacancy) {
        String sql = "SELECT * FROM `recruiting-server`.skill_requirements WHERE (important = 1 AND vacancy_id = ?)";
        return template.query(sql, new SkillRequirementMapper(), vacancy.getId().toString());
    }

    @Override
    public List<SkillRequirement> getSignificantSkills(Vacancy vacancy) {
        String sql = "SELECT * FROM `recruiting-server`.skill_requirements WHERE (important = 1 and vacancy_id = ?) ORDER BY level ASC  LIMIT 3";
        return template.query(sql, new SkillRequirementMapper(), vacancy.getId().toString());
    }

    @Override
    public void save(Vacancy vacancy) {

    }

    @Override
    public void update(UUID id, Vacancy vacancy) {

    }

    @Override
    public void delete(UUID id) {

    }
}
