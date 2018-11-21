package com.elsTest.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by houssem89 on 20/11/2018.
 */


@Document
public class Salarie  {
    @Id
    private String id;
    private String lastName;
    private String firstName;
    private String country;

    public Salarie() {
    }

    public Salarie(String id, String lastName, String firstName, String country) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.country = country;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getId() {

        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salarie)) return false;

        Salarie salarie = (Salarie) o;

        if (country != null ? !country.equals(salarie.country) : salarie.country != null) return false;
        if (firstName != null ? !firstName.equals(salarie.firstName) : salarie.firstName != null) return false;
        if (id != null ? !id.equals(salarie.id) : salarie.id != null) return false;
        if (lastName != null ? !lastName.equals(salarie.lastName) : salarie.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Salarie{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
