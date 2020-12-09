package com.galvanize.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AreaController {

    @PostMapping("/math/area")
    public String calculateArea(@RequestParam Map<String, String> body) {
        String type = body.get("type");
        String response = "";

        if (type.equals("circle")) {
            int radius = Integer.parseInt(body.get("radius"));
            double result = (Math.PI * Math.pow(radius, 2));
            response += result;
        }
        return response;
    }
}
