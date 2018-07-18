package edu.omsu.jesper.model;

import java.util.UUID;

public class SkillRequirement {
    private UUID id;
    private String name;
    private int level;
    private boolean important;

    public SkillRequirement() {
    }

    public SkillRequirement(UUID id, String name, int level, boolean important) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.important = important;
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
