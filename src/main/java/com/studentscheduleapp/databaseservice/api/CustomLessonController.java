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
@RequestMapping("api/customLessons")
public class CustomLessonController {

    @Autowired
    private CustomLessonRepository customLessonRepository;

    @GetMapping("id/{id}")
    public ResponseEntity<CustomLesson> getById(@PathVariable("id") long id){
        Logger.getGlobal().info("get custom lesson successful");
        return ResponseEntity.ok(customLessonRepository.findById(id).orElse(null));
    }
    @GetMapping("group/{id}")
    public ResponseEntity<List<CustomLesson>> getByGroupId(@PathVariable("id") long id){
        Logger.getGlobal().info("get custom lesson successful");
        return ResponseEntity.ok(customLessonRepository.findByGroupId(id));
    }
    @PostMapping("save")
    public ResponseEntity<CustomLesson> save(@RequestBody CustomLesson data){
        Logger.getGlobal().info("save custom lesson successful");
        return ResponseEntity.ok(customLessonRepository.save(data));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<CustomLesson>> deleteById(@PathVariable("id") long id){
        customLessonRepository.deleteById(id);
        Logger.getGlobal().info("delete custom lesson successful");
        return ResponseEntity.ok().build();
    }
}
