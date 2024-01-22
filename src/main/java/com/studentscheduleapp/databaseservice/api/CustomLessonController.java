package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.CustomLessonRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class CustomLessonController {

    @Autowired
    private CustomLessonRepository customLessonRepository;

    @GetMapping("${mapping.customLesson.getById}/{id}")
    public ResponseEntity<CustomLesson> getById(@PathVariable("id") long id){
        Logger.getGlobal().info("get custom lesson successful");
        return ResponseEntity.ok(customLessonRepository.findById(id).orElse(null));
    }
    @GetMapping("${mapping.customLesson.getByGroupId}/{id}")
    public ResponseEntity<List<CustomLesson>> getByGroupId(@PathVariable("id") long id){
        Logger.getGlobal().info("get custom lesson successful");
        return ResponseEntity.ok(customLessonRepository.findByGroupId(id));
    }
    @PostMapping("${mapping.customLesson.save}")
    public ResponseEntity<CustomLesson> save(@RequestBody CustomLesson data){
        if(data.getName() == null || data.getName().isEmpty()) {
            Logger.getGlobal().info("bad request: name is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Logger.getGlobal().info("save custom lesson successful");
        return ResponseEntity.ok(customLessonRepository.save(data));
    }
    @DeleteMapping("${mapping.customLesson.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id){
        customLessonRepository.deleteById(id);
        Logger.getGlobal().info("delete custom lesson successful");
        return ResponseEntity.ok().build();
    }
}
