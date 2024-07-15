package com.restful_webservice_with_springboot.rest_webservice_with_spring_boot.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    //versioning by URI
    @GetMapping("/v1/person")
    public PersonV1 getPersonV1(){
        return new PersonV1("John Cena");
    }

    //versioning by URI
    @GetMapping("/v2/person")
    public PersonV2 getPersonV2(){
        return new PersonV2(new Name("John","Cena"));
    }

    //versioning by parameter
    @GetMapping(path="/person", params="version=1")
    public PersonV1 getPersonV1ByRequestParameter(){
        return new PersonV1("John Cena");
    }

    //versioning by parameter
    @GetMapping(path="/person", params="version=2")
    public PersonV2 getPersonV2ByRequestParameter(){
        return new PersonV2(new Name("John","Cena"));
    }

    //versioning by header
    @GetMapping(path="/person/header", headers="X-API-Version=1")
    public PersonV1 getPersonV1ByRequestHeader(){
        return new PersonV1("John Cena");
    }

    //versioning by header
    @GetMapping(path="/person/header", headers="X-API-Version=2")
    public PersonV2 getPersonV2ByRequestHeader(){
        return new PersonV2(new Name("John","Cena"));
    }
}
