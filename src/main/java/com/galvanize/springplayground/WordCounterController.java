package com.galvanize.springplayground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WordCounterController {

    /* Also works: @Autowired annotation: */
//    @Autowired
    private WordCounter wordCounter;

    /* Using constructor injection: */
    public WordCounterController(WordCounter wordCounter) {
        this.wordCounter = wordCounter;
    }

    @PostMapping("/words/count")
    public Map<String, Integer> countWords(@RequestBody String body) {
//        WordCounter counter = new WordCounter();
        return wordCounter.count(body);
    }
}
