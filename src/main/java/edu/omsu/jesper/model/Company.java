package edu.omsu.jesper.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Company {
    @NotNull
    private UUID id;
    @NotNull
    @Size(min = 4, max = 125)
    private String name;
    @NotNull
    @Size(min = 5, max = 160)
    private String email;
    @NotNull
    private LocalDate registrationDate;
    @NotNull
    private LocalDate foundationDate;
    private String owner;

    public Company() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDate foundationDate) {
        this.foundationDate = foundationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id) &&
                Objects.equals(name, company.name) &&
                Objects.equals(email, company.email) &&
                Objects.equals(registrationDate, company.registrationDate) &&
                Objects.equals(foundationDate, company.foundationDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, email, registrationDate, foundationDate);
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", registrationDate=" + registrationDate +
                ", foundationDate=" + foundationDate +
                '}';
    }


    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }
}
