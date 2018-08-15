package edu.omsu.jesper.dao.implementations;

import edu.omsu.jesper.enums.SalaryType;
import edu.omsu.jesper.model.SkillRequirement;
import edu.omsu.jesper.model.Vacancy;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class VacancyDaoImplTest {

    private JdbcTemplate template;
    private VacancyDaoImpl dao;
    private CompanyDaoImpl companies;
    private UserDaoImpl userDao;

    @Before
    public void init() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://omsu-projects.mysql.database.azure.com:3306/recruiting-server?useSSL=true&requireSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC");
        dataSource.setUsername("jesper@omsu-projects");
        dataSource.setPassword("Iey4waetie6geen");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setSchema("recruiting-server");
        template = new JdbcTemplate(dataSource);
        userDao = new UserDaoImpl(template);
        dao = new VacancyDaoImpl(template, userDao);
        companies = new CompanyDaoImpl(template);

    }

    @Test
    public void get() {
    }

    @Test
    public void getSingle() {
    }

    @Test
    public void getByAuthor() {
    }

    @Test
    public void getByAuthor1() {
    }

    @Test
    public void getImportantSkills() {
    }

    @Test
    public void getSignificantSkills() {
    }

    @Test
    public void save() {
        UUID id = UUID.randomUUID();
        try {
            Vacancy vacancy = new Vacancy();

            vacancy.setId(id);
            vacancy.setSalary(2500);
            vacancy.setType(SalaryType.PER_MONTH);
            vacancy.setCurrency(Currency.getInstance("RUB"));
            vacancy.setAuthor(companies.get().get(0));
            vacancy.setCreationDate(LocalDateTime.now());
            vacancy.setFullDescription("PRIVET ETO TEST");
            vacancy.setName("TEST VACANCY");
            vacancy.setHidden(false);
            List<SkillRequirement> requirements = new ArrayList<>();
            SkillRequirement skill = new SkillRequirement();
            skill.setLevel(5);
            skill.setImportant(true);
            skill.setName("Java");
            requirements.add(skill);
            vacancy.setRequirements(requirements);
            dao.save(vacancy);
            Vacancy test = dao.get(id);
            assertEquals(vacancy, test);
        } finally {
            dao.delete(id);
        }

    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}