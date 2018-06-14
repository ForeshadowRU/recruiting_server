package edu.omsu.jesper.model;

public class SkillRequirement {
    private int id;
    private Skill skill;
    private int level;
    private boolean important;

    public SkillRequirement() {
    }

    public SkillRequirement(int id, Skill skill, int level, boolean important) {
        this.id = id;
        this.skill = skill;
        this.level = level;
        this.important = important;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
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
