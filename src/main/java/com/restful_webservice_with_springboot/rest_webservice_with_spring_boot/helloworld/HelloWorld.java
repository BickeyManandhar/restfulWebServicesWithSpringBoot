package com.restful_webservice_with_springboot.rest_webservice_with_spring_boot.helloworld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorld {

    private MessageSource messageSource;

    public HelloWorld(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/hello-world")
    public String getHelloWorld() {
        return "Hello World."; //returning string
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean getHelloWorldBean() {
        return new HelloWorldBean("Hello World."); //returning instance of our own class, return JSON
    }

    //path parameter
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean getPathParameter(@PathVariable String name) {
        return new HelloWorldBean(
                String.format("Hello %s", name.toUpperCase())
        );
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String getHelloWorldInternationalized() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.world.message",null,"Default Message",locale);
    }
    //Accept-Language: en - English, nl - Dutch, fr - French, de - Deutsch
    //messages.properties
}
