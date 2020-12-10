package com.galvanize.demo;

import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @GetMapping("/find/{title}")
    public Lesson findByTitle(@PathVariable String title) {

        return this.repository.findByTitle(title);
    }

    @GetMapping("/between")
    public Iterable<Lesson> findByDateBetween(@RequestParam String date1,
                                    @RequestParam String date2)
            throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = format.parse(date1);
        Date endDate = format.parse(date2);
        return this.repository.findByDeliveredOnBetween(startDate, endDate);
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

    @PatchMapping("/{id}")
    public Lesson patch(@PathVariable Long id, @RequestBody Lesson lesson) {
        lesson.setId(id);
        return this.repository.save(lesson);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.repository.deleteById(id);
    }

}