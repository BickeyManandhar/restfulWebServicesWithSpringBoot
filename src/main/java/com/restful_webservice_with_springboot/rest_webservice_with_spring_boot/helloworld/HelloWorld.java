package com.restful_webservice_with_springboot.rest_webservice_with_spring_boot.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @GetMapping(path="/hello-world")
    public String getHelloWorld(){
        return "Hello World.";
    }
}
