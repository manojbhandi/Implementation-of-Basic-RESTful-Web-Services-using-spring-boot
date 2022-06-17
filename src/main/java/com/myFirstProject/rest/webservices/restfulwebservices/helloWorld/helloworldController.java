package com.myFirstProject.rest.webservices.restfulwebservices.helloWorld;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController //Web request handler

public class helloworldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public String helloWorld(){

        return "hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){

        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-varibale/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){

        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(
//            (@RequestHeader(name = "Accept-Language", required = false) Locale locale
            ){

        return messageSource.getMessage("good.morning.message", null, "Default Message"
                //, locale)
                , LocaleContextHolder.getLocale());
//        return "hello World";
    }

}
