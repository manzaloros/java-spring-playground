package com.galvanize.springplayground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WordCounterController {

    /* Also works: @Autowired annotation: */
    /* Final means it will always stay the same value: */
//    @Autowired
    private final WordCounter wordCounter;

    /* Using constructor injection: */
    public WordCounterController(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    @PostMapping("/words/count")
    public Map<String, Integer> countWords(@RequestBody String body) {
        return wordCounter.count(body);
    }
}
