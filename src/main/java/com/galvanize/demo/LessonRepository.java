package com.galvanize.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.Date;

// The Long type here is the entity id type
// When app starts, Spring JPA scans for all interfaces that extend
// CrudRepository
public interface LessonRepository extends CrudRepository<Lesson, Long> {
    Lesson findByTitle(String title);
    Iterable<Lesson> findByDeliveredOnBetween(Date startDate, Date endDate);
}