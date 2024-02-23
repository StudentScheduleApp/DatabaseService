package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.CustomLessonRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class CustomLessonController {

    @Autowired
    private CustomLessonRepository customLessonRepository;
    private static Logger log = LogManager.getLogger(CustomLessonController.class);

    @GetMapping("${mapping.customLesson.getById}/{id}")
    public ResponseEntity<CustomLesson> getById(@PathVariable("id") long id){
        log.info("get customLesson with id: " + id);
        return ResponseEntity.ok(customLessonRepository.findById(id).orElse(null));
    }
    @GetMapping("${mapping.customLesson.getByGroupId}/{id}")
    public ResponseEntity<List<CustomLesson>> getByGroupId(@PathVariable("id") long id){
        log.info("get customLesson with groupId: " + id);
        return ResponseEntity.ok(customLessonRepository.findByGroupId(id));
    }
    @PostMapping("${mapping.customLesson.save}")
    public ResponseEntity<CustomLesson> save(@RequestBody CustomLesson data){
        if(data.getName() == null || data.getName().isEmpty()) {
            log.info("bad request: customLesson name is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        log.info("save customLesson with id: " + data.getId());
        return ResponseEntity.ok(customLessonRepository.save(data));
    }
    @DeleteMapping("${mapping.customLesson.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id){
        try {
            customLessonRepository.deleteById(id);
            log.info("delete customLesson with id: " + id);
        } catch (EmptyResultDataAccessException e){
            log.info("delete customLesson with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
