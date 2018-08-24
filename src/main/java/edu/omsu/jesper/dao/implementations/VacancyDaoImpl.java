package edu.omsu.jesper.dao.implementations;

import edu.omsu.jesper.dao.interfaces.UserDao;
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
    private final UserDao userDao;

    @Autowired
    public VacancyDaoImpl(JdbcTemplate template, UserDao userDao) {
        this.template = template;
        this.userDao = userDao;
    }

    @Override
    public List<Vacancy> get() {
        String sql = "SELECT id,name,description,author_id,hidden,creation_date,amount as 'salary_amount', type,currency, publisher" +
                " FROM `recruiting-server`.vacancies RIGHT JOIN `recruiting-server`.salaries on vacancies.id = salaries.vacancy_id ORDER BY creation_date ASC";
        return template.query(sql, new VacancyMapper(template));
    }

    @Override
    public Vacancy get(UUID id) {
        String sql = "SELECT id,name,description,author_id,hidden,creation_date,amount as 'salary_amount', type,currency,publisher FROM `recruiting-server`.vacancies " +
                "RIGHT JOIN `recruiting-server`.salaries on vacancies.id = salaries.vacancy_id" +
                " WHERE id = ?";
        List<Vacancy> list = template.query(sql, new VacancyMapper(template), id.toString());
        if (list.isEmpty()) return null;
        else return list.get(0);
    }

    @Override
    public List<Vacancy> getByAuthor(UUID authorId) {
        String sql = "SELECT id,name,description,author_id,hidden,creation_date,amount as 'salary_amount', type,currency,publisher FROM `recruiting-server`.vacancies" +
                " RIGHT JOIN `recruiting-server`.salaries on vacancies.id = salaries.vacancy_id WHERE author_id = ?";
        return template.query(sql, new VacancyMapper(template), authorId.toString());
    }

    @Override
    public List<Vacancy> getByAuthor(Company company) {
        String sql = "SELECT id,name,description,author_id,hidden,creation_date,amount as 'salary_amount', type,currency,publisher FROM `recruiting-server`.vacancies" +
                " RIGHT JOIN `recruiting-server`.salaries on vacancies.id = salaries.vacancy_id WHERE author_id = ?";
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
        String sql = "INSERT INTO `recruiting-server`.vacancies(id, name, description, author_id, hidden, creation_date, publisher)" +
                " VALUES(?,?,?,?,?,?,?)";
        template.update(sql, setter -> {
            setter.setString(1, vacancy.getId().toString());
            setter.setString(2, vacancy.getName());
            setter.setString(3, vacancy.getFullDescription());
            setter.setString(4, vacancy.getAuthor().getId().toString());
            setter.setBoolean(5, vacancy.isHidden());
            setter.setString(6, vacancy.getCreationDate().toString());
            setter.setString(7, vacancy.getPublisher());
        });
        sql = "INSERT INTO `recruiting-server`.salaries(vacancy_id, amount, type, currency) " +
                "VALUES(?,?,?,?)";
        template.update(sql, setter -> {
            setter.setString(1, vacancy.getId().toString());
            setter.setDouble(2, vacancy.getSalary());
            setter.setString(3, String.valueOf(vacancy.getType()));
            setter.setString(4, String.valueOf(vacancy.getCurrency()));
        });
        List<SkillRequirement> requirements = vacancy.getRequirements();
        for (SkillRequirement skill : requirements) {
            sql = "INSERT INTO `recruiting-server`.skill_requirements(vacancy_id, name, level, important)" +
                    " VALUES(?,?,?,?)";
            template.update(sql, setter -> {
                setter.setString(1, vacancy.getId().toString());
                setter.setString(2, skill.getName());
                setter.setInt(3, skill.getLevel());
                setter.setBoolean(4, skill.isImportant());
            });
        }
    }

    @Override
    public void update(UUID id, Vacancy vacancy) {

    }

    @Override
    public void delete(UUID id) {
        String sql = "DELETE FROM `recruiting-server`.salaries WHERE vacancy_id = ?";
        template.update(sql, setter -> setter.setString(1, id.toString()));
        sql = "DELETE FROM `recruiting-server`.skill_requirements WHERE vacancy_id = ?";
        template.update(sql, setter -> setter.setString(1, id.toString()));
        sql = "DELETE FROM `recruiting-server`.vacancies WHERE id = ?";
        template.update(sql, setter -> setter.setString(1, id.toString()));
    }
}
