package com.example;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/")
public class MainController {

    @Get
    public String index() {
        return "back 6 ok";
    }

}