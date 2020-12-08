package com.galvanize.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping("/math")
public class PiController {

    @GetMapping("/pi")
    public String returnPi() {
        return "3.141592653589793";
    }

    @GetMapping("/calculate")
    public String math(@RequestParam Map map) {
        int x = parseInt((String) map.get("x"));
        int y = parseInt((String) map.get("y"));
        int result;
        if (map.containsKey("operation")) {
            String operation = (String) map.get("operation");
            System.out.println("op:" + operation);
            switch (operation) {
                case "add":
                    result = x + y;
                    return x + " + " + y + " = " + result;
                case "multiply":
                    result = x * y;
                    return x + " * " + y + " = " + result;
                case "subtract":
                    result = x - y;
                    return x + " - " + y + " = " + result;
                case "divide":
                    result = x / y;
                    return x + " / " + y + " = " + result;
            }
        }
        result = x + y;
        return x + " + " + y + " = " + result;
    }

}
