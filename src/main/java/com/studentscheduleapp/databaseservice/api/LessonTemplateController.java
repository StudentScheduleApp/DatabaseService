package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.GroupRepository;
import com.studentscheduleapp.databaseservice.data.repositories.LessonTemplateRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.Group;
import com.studentscheduleapp.databaseservice.data.tablemodels.LessonTemplate;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonTemplateController {

    @Autowired
    private LessonTemplateRepository lessonTemplateRepository;
    private static Logger log = LogManager.getLogger(LessonTemplateController.class);

    @GetMapping("${mapping.lessonTemplate.getById}/{id}")
    public ResponseEntity<LessonTemplate> getById(@PathVariable("id") long id){
        log.info("get lessonTemplate with id: " + id);
        return ResponseEntity.ok(lessonTemplateRepository.findById(id).orElse(null));
    }
    @GetMapping("${mapping.lessonTemplate.getByScheduleTemplateId}/{id}")
    public ResponseEntity<List<LessonTemplate>> getByScheduleTemplateId(@PathVariable("id") long id){
        log.info("get lessonTemplate with scheduleTemplateId: " + id);
        return ResponseEntity.ok(lessonTemplateRepository.findByScheduleTemplateId(id));
    }
    @PostMapping("${mapping.lessonTemplate.save}")
    public ResponseEntity<LessonTemplate> save(@RequestBody LessonTemplate data){
        log.info("save lessonTemplate with id: " + data.getId());
        return ResponseEntity.ok(lessonTemplateRepository.save(data));
    }
    @DeleteMapping("${mapping.lessonTemplate.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id){
        try {
            lessonTemplateRepository.deleteById(id);
            log.info("delete lessonTemplate with id: " + id);
        } catch (EmptyResultDataAccessException e){
            log.warn("delete lessonTemplate with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
