package edu.omsu.jesper.dto;

import edu.omsu.jesper.enums.SalaryType;
import edu.omsu.jesper.model.SkillRequirement;

import java.util.Currency;
import java.util.List;
import java.util.UUID;

public class PostVacancyRequest {
    public String name;
    public String description;
    public SalaryType type;
    public Currency currency;
    public double salary;
    public UUID author;
    public String publisher;
    public List<SkillRequirement> requirements;
    public boolean hidden;

}
