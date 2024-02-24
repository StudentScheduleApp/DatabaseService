package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.SpecificLessonRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.SpecificLesson;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecificLessonController {

    @Autowired
    private SpecificLessonRepository specificLessonRepository;
    private static final Logger log = LogManager.getLogger(SpecificLessonController.class);

    @GetMapping("${mapping.specificLesson.getById}/{id}")
    public ResponseEntity<SpecificLesson> getById(@PathVariable("id") long id){
        log.info("get specificLesson with id: " + id);
        return ResponseEntity.ok(specificLessonRepository.findById(id).orElse(null));
    }
    @GetMapping("${mapping.specificLesson.getByGroupId}/{id}")
    public ResponseEntity<List<SpecificLesson>> getByGroupId(@PathVariable("id") long id){
        log.info("get specificLesson with groupId: " + id);
        return ResponseEntity.ok(specificLessonRepository.findByGroupId(id));
    }
    @PostMapping("${mapping.specificLesson.save}")
    public ResponseEntity<SpecificLesson> save(@RequestBody SpecificLesson data){
        SpecificLesson d = specificLessonRepository.save(data);
        log.info("save specificLesson with id: " + d.getId());
        return ResponseEntity.ok(d);
    }
    @DeleteMapping("${mapping.specificLesson.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id){
        try {
            specificLessonRepository.deleteById(id);
            log.info("delete specificLesson with id: " + id);
        } catch (EmptyResultDataAccessException e){
            log.warn("delete specificLesson with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
