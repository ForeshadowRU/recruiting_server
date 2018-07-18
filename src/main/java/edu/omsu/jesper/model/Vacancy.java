package edu.omsu.jesper.model;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Vacancy {
    private UUID id;
    private String name;
    private String description;
    private Company author;
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
