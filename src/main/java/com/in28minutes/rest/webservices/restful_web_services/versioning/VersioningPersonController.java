package com.in28minutes.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParam(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParam(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonAcceptHeader(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/header",  headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonAcceptHeader(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(value = "/person/accept-header", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonRequestHeader(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value = "/person/accept-header",  produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonRequestHeader(){
        return new PersonV2(new Name("Bob", "Charlie"));
    }
}
