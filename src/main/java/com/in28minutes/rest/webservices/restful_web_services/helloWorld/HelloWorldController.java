package com.in28minutes.rest.webservices.restful_web_services.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

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

    @GetMapping("/hello-world-internationalized")
    public String hellWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default Message",locale);
    }
}
