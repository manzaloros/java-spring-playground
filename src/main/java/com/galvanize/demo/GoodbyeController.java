package com.galvanize.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodbyeController {

    @GetMapping("/bye")
    public String goodbyeWorld() {
        return "Goodbye";
    }
}
