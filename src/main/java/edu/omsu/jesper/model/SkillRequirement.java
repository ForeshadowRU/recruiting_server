package edu.omsu.jesper.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class SkillRequirement {

    @NotNull
    @Size(min = 1, max = 25)
    private String name;
    @NotNull
    @Pattern(regexp = "\\d?|10")
    private int level;
    private boolean important = false;

    public SkillRequirement() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkillRequirement that = (SkillRequirement) o;
        return level == that.level &&
                important == that.important &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, level, important);
    }

    @Override
    public String toString() {
        return "SkillRequirement{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", important=" + important +
                '}';
    }
}
