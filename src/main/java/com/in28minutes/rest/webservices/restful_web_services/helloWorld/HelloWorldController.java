package com.in28minutes.rest.webservices.restful_web_services.helloWorld;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String hellWorld(){
        return  "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean hellWorldBean(){
        return  new HelloWorldBean("Hello World");
    }

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean hellWorldPathVariable(@PathVariable("name") String name){
        return  new HelloWorldBean("Hello World, " + name);
    }
}
