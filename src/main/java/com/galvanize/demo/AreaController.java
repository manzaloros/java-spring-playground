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
            String result = String.valueOf(Math.PI * Math.pow(radius, 2));
            response += "Area of a circle with a radius of 4 is " + result;
        } else if (type.equals("rectangle")) {
            if (body.containsKey("radius")) {
                response = "Invalid";
                return response;
            }
            int width = Integer.parseInt(body.get("width"));
            int height = Integer.parseInt(body.get("height"));
            String result = String.valueOf(width * height);
            response += "Area of a 4x7 rectangle is " + result;
        }
        return response;
    }
}
