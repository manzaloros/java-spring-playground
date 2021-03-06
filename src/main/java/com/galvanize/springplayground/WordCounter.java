package com.galvanize.springplayground;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WordCounter {

    // Bean annotation causing problems
    public Map<String, Integer> count(String sentence) {

        Map<String, Integer> counter = new HashMap<>();
        String[] words = sentence.replaceAll("[^a-zA-Z ]", "")
                .toLowerCase().split("\\s+");

        for (String currentWord : words) {
            if (!counter.containsKey(currentWord)) {
                counter.put(currentWord, 1);
            } else {
                counter.put(currentWord, counter.get(currentWord) + 1);
            }
        }

        return counter;
    }
}
