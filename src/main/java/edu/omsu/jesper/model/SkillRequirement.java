package edu.omsu.jesper.model;

import java.util.UUID;

public class SkillRequirement {
    private UUID vacancyId;
    private String name;
    private int level;
    private boolean important;

    public SkillRequirement() {
    }

    public SkillRequirement(UUID vacancyId, String name, int level, boolean important) {
        this.vacancyId = vacancyId;
        this.name = name;
        this.level = level;
        this.important = important;
    }

    public UUID getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(UUID vacancyId) {
        this.vacancyId = vacancyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }
}
