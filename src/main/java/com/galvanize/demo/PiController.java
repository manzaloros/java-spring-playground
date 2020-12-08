package com.galvanize.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PiController {

    @GetMapping("/math/pi")
    public String returnPi() {
        return "3.141592653589793";
    }

}
