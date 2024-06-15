package com.restful_webservice_with_springboot.rest_webservice_with_spring_boot.helloworld;

public class HelloWorldBean {

    private String message;
    public HelloWorldBean(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
