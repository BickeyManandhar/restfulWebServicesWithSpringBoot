package com.restful_webservice_with_springboot.rest_webservice_with_spring_boot.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties("field3") //remove field3 from response in class level, best practice is to use JsonIgnore as field name may change
public class SomeBean {

    private String field1;

    @JsonIgnore //removes password from response
    private String password;
    private String field3;

    public SomeBean(String field1, String field2, String field3) {
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
