package edu.omsu.jesper.model;

import java.util.List;

public class Vacancy {
    private int id;
    private String name;
    private String description;
    private Company author;
    private boolean hidden;

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    private List<SkillRequirement> requirements;

    public Vacancy() {
    }

    public Vacancy(String name, String description, Company author) {
        this.name = name;
        this.description = description;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<SkillRequirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<SkillRequirement> requirements) {
        this.requirements = requirements;
    }
}
