package com.galvanize.springplayground;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math/volume/{l}/{w}/{h}")
public class VolumeController {

    @GetMapping("")
    public String getCalc(@PathVariable int l,
                            @PathVariable  int w,
                            @PathVariable int h) {
        return Integer.toString(l * w * h);
    }

    @PostMapping("")
    public String postCalc(@PathVariable int l,
                            @PathVariable  int w,
                            @PathVariable int h) {
        return Integer.toString(l * w * h);
    }

    @PatchMapping("")
    public String patchCalc(@PathVariable int l,
                            @PathVariable  int w,
                            @PathVariable int h) {
        return Integer.toString(l * w * h);
    }

    @PutMapping("")
    public String putCalc(@PathVariable int l,
                            @PathVariable  int w,
                            @PathVariable int h) {
        return Integer.toString(l * w * h);
    }

    @DeleteMapping("")
    public String deleteCalc(@PathVariable int l,
                            @PathVariable  int w,
                            @PathVariable int h) {
        return Integer.toString(l * w * h);
    }
}
