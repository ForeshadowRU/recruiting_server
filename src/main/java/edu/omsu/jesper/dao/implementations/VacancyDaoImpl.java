package edu.omsu.jesper.dao.implementations;

import edu.omsu.jesper.dao.interfaces.VacancyDao;
import edu.omsu.jesper.mapper.VacancyMapper;
import edu.omsu.jesper.model.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class VacancyDaoImpl implements VacancyDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public VacancyDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Vacancy> getAll() {
        String sql = "SELECT * FROM vacancies;";
        return jdbcTemplate.query(sql,new VacancyMapper(jdbcTemplate));
    }

    public List<Vacancy> getAllVisible() {
        String sql = "SELECT * FROM vacancies WHERE vacancies.isHidden = 0;";
        return jdbcTemplate.query(sql, new VacancyMapper(jdbcTemplate));
    }

    public List<Vacancy> getByCompany(int companyId) {
        String sql = String.format("SELECT * FROM vacancies WHERE author_id = %s;", companyId);
        return jdbcTemplate.query(sql,new VacancyMapper(jdbcTemplate));
    }

    public void save(Vacancy vacancy) {
       /* String sql = "INSERT INTO vacancies(name, description, authorId, isHidden) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql,vacancy.getName(),
                vacancy.getDescription(),
                vacancy.getAuthor().getId(),
                vacancy.isHidden());
        try
        {
            List<SkillRequirement> requirements = vacancy.getRequirements();
            sql = "INSERT INTO skillrequirements(id, vacancy_id, level, important)" +
                    " VALUES(?,?,?,?);";
            for (SkillRequirement requirement : requirements) {
                jdbcTemplate.update(sql, requirement.getSkill().getId(),
                        vacancy.getId(), requirement.getLevel(),
                        requirement.isImportant());
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }*/


    }

    public Vacancy getById(int id) {
        String sql = String.format("SELECT * FROM vacancies WHERE id = %d;",id);
        return jdbcTemplate.query(sql,new VacancyMapper(jdbcTemplate)).get(0);
    }

    public void update(Vacancy vacancy) {

    }

    public void delete(int id) {

    }
}
