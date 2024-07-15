package com.restful_webservice_with_springboot.rest_webservice_with_spring_boot.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getPersonV1(){
        return new PersonV1("John Cena");
    }

    @GetMapping("/v2/person")
    public PersonV2 getPersonV2(){
        return new PersonV2(new Name("John","Cena"));
    }
}
