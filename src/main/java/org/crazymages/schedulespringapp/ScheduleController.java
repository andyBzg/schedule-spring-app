package org.crazymages.schedulespringapp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScheduleController {

    private final List<Lesson> schedule;


    public ScheduleController() {
        schedule = new ArrayList<>();
    }

    @GetMapping(value = "/schedule")
    public List<Lesson> getSchedule() {
        return schedule;
    }

    @PostMapping(value = "/schedule")
    public void addLesson(@RequestBody Lesson lesson) {
        schedule.add(lesson);
    }

    @DeleteMapping(value = "/schedule/{id}")
    public void deleteLesson(@PathVariable String id) {
        int lessonId = Integer.parseInt(id);
        schedule.remove(lessonId);
    }

    @PutMapping(value = "/schedule/{id}")
    public void updateLesson(@PathVariable String id, @RequestBody Lesson lesson) {
        int lessonId = Integer.parseInt(id);
        schedule.set(lessonId, lesson);
    }
}
