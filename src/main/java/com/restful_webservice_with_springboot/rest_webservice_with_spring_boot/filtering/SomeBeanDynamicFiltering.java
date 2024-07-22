package com.restful_webservice_with_springboot.rest_webservice_with_spring_boot.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonFilter("SomeBeanDynamicFilter")
public class SomeBeanDynamicFiltering {

    private String field1;

    private String password;
    private String field3;

    public SomeBeanDynamicFiltering(String field1, String field2, String field3) {
        this.field1 = field1;
        this.password = field2;
        this.field3 = field3;
    }

    public String getField1() {
        return field1;
    }

    public String getPassword() {
        return password;
    }

    public String getField3() {
        return field3;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "field1='" + field1 + '\'' +
                ", field2='" + password + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }
}
