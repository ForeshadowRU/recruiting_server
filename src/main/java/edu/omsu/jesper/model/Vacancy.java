package edu.omsu.jesper.model;

import edu.omsu.jesper.enums.SalaryType;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Vacancy {
    @NotNull
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private UUID authorId;
    private double salary;
    @NotNull
    private SalaryType type;
    @NotNull
    private Currency currency;
    private boolean hidden = false;
    private LocalDateTime creationDate;

    private String publisher;

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

    public @NotNull UUID getAuthorId() {
        return authorId;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List<SkillRequirement> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<SkillRequirement> requirements) {
        this.requirements = requirements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacancy vacancy = (Vacancy) o;
        return Double.compare(vacancy.salary, salary) == 0 &&
                hidden == vacancy.hidden &&
                Objects.equals(id, vacancy.id) &&
                Objects.equals(name, vacancy.name) &&
                Objects.equals(description, vacancy.description) &&
                Objects.equals(authorId, vacancy.authorId) &&
                type == vacancy.type &&
                Objects.equals(currency, vacancy.currency) &&
                Objects.equals(creationDate, vacancy.creationDate) &&
                Objects.equals(publisher, vacancy.publisher) &&
                Objects.equals(requirements, vacancy.requirements);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, description, authorId, salary, type, currency, hidden, creationDate, publisher, requirements);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", authorId='" + authorId + '\'' +
                ", salary=" + salary +
                ", type=" + type +
                ", currency=" + currency +
                ", hidden=" + hidden +
                ", creationDate=" + creationDate +
                ", publisher='" + publisher + '\'' +
                ", requirements=" + requirements +
                '}';
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
