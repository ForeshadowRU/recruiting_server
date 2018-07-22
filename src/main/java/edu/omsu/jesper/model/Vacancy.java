package edu.omsu.jesper.model;

import edu.omsu.jesper.enums.SalaryType;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Vacancy {
    private UUID id;
    private String name;
    private String fullDescription;
    private String description;
    private Company author;
    private double salary;
    private SalaryType type;
    private boolean hidden;
    private Date creationDate;
    private List<SkillRequirement> requirements;

    public Vacancy() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getAuthor() {
        return author;
    }

    public void setAuthor(Company author) {
        this.author = author;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public SalaryType getType() {
        return type;
    }

    public void setType(SalaryType type) {
        this.type = type;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<SkillRequirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<SkillRequirement> requirements) {
        this.requirements = requirements;
    }
}
