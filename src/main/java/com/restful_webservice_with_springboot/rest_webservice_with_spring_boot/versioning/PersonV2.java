package com.restful_webservice_with_springboot.rest_webservice_with_spring_boot.versioning;

public class PersonV2 {
    private Name name;

    public PersonV2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "name='" + name + '\'' +
                '}';
    }
}
