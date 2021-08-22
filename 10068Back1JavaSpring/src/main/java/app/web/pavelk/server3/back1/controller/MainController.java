package app.web.pavelk.server3.back1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String main() {
        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("---------------------");
        return "back 1 ok";
    }

}
