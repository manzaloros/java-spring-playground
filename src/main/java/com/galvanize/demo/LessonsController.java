package com.galvanize.demo;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/lessons")

// Spring scans for all classes that have @RestController and looks at
// constructor

// Spring uses reflection to look at constructor parameters to see what to inject
public class LessonsController {

    private final LessonRepository repository;

    // Constructor injection
    // Now the controller methods will have access to the db via repository
    public LessonsController(LessonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public Iterable<Lesson> all() {
        return this.repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Lesson> findById(@PathVariable Long id) {
        return this.repository.findById(id);
    }

    // Deserializes body of request into a Lesson object
    // Adds row to database and gets ID back
    // Repository adds ID to Lesson object and returns it to controller
    // Controller serializes the Lesson object to JSON with the ID returned
    // Spring will construct an HTTP response with the returned object and
    // sends it to the client
    @PostMapping("")
    public Lesson create(@RequestBody Lesson lesson) {
        return this.repository.save(lesson);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.repository.deleteById(id);
    }

}