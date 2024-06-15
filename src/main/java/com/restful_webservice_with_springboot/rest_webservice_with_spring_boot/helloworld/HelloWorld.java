package com.restful_webservice_with_springboot.rest_webservice_with_spring_boot.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping(path="/hello-world")
    public String getHelloWorld(){
        return "Hello World."; //returning string
    }

    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean getHelloWorldBean(){
        return new HelloWorldBean("Hello World."); //returning instance of our own class, return JSON
    }
}
