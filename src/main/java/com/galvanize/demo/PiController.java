package com.galvanize.demo;

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

    @PostMapping("/sum")
    public String postAdd(
            @RequestParam
            MultiValueMap<String, String>
            queryMap) {
        StringBuilder response = new StringBuilder();
        List<String> numbers = queryMap.get("n");
        int result = 0;
        int size = numbers.size();

        for (String number : numbers) {
            result += Integer.parseInt(number);
        }

        for (int i = 0; i < size; i += 1) {
            String num = numbers.get(i);
            if (i != size - 1) {
                response.append(num).append(" + ");
            } else {
                response.append(num).append(" = ").append(result);
            }
        }

        return response.toString();
    }
}