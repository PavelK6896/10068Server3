package app.web.pavelk.server3.back2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MainController {

    @GetMapping("/")
    public Mono<String> main() {
        return Mono.just("back 2 ok");
    }

}
