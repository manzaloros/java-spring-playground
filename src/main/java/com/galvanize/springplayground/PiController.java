package com.galvanize.springplayground;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        String x = (String) map.get("x");
        String y = (String) map.get("y");
        MathService mathService = new MathService(x, y);

        if (map.containsKey("operation")) {
            String operation = (String) map.get("operation");
            switch (operation) {
                case "multiply":
                    return mathService.multiply();
                case "subtract":
                    return mathService.subtract();
                case "divide":
                    return mathService.divide();
            }
        }

        /* Default Addition Case: */
        return mathService.add();
    }

    @PostMapping("/sum")
    public String postAdd(
            @RequestParam
            MultiValueMap<String, String>
            queryMap) {
        List<String> numbers = queryMap.get("n");
        MathService mathService = new MathService();
        return mathService.add(numbers);
    }
}
