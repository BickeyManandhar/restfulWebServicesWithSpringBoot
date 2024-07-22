package com.restful_webservice_with_springboot.rest_webservice_with_spring_boot.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

//Serialization (convert object to stream)
// Customize field name in response
// Filtering: Static(same filtering for a bean across different REST API, example password in SomeBean.java): JsonIgnoreProperties, JsonIgnore and Dynamic Filtering(Customize filtering for a bean for specific REST API): JsonFilter with FilterProvider

public class User {
    private Integer id;
    @Size(min=2, message = "Name must have 2 characters.")
    @JsonProperty("user_name") //if we want an API to have diff field name
    private String name;
    @PastOrPresent(message = "Birthdate cannot be the future date.")
    @JsonProperty("birth_date")
    private LocalDate birthDate;

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
