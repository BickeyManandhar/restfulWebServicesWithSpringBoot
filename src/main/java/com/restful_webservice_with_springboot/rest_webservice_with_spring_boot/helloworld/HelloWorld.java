package com.restful_webservice_with_springboot.rest_webservice_with_spring_boot.helloworld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping(method= RequestMethod.GET,path="/hello-world")
    public String getHelloWorld(){
        return "Hello World.";
    }
}
