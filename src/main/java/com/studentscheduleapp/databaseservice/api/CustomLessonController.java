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

@RestController
@RequestMapping("api/customLessons")
public class CustomLessonController {

    @Autowired
    private CustomLessonRepository customLessonRepository;

    @GetMapping("id/{id}")
    public ResponseEntity<CustomLesson> getById(@PathVariable("id") long id){
        return ResponseEntity.ok(customLessonRepository.findById(id).get());
    }
    @GetMapping("group/{id}")
    public ResponseEntity<List<CustomLesson>> getByGroupId(@PathVariable("id") long id){
        return ResponseEntity.ok(customLessonRepository.findByGroupId(id));
    }
    @PostMapping("save")
    public ResponseEntity<CustomLesson> save(@RequestBody CustomLesson data){
        return ResponseEntity.ok(customLessonRepository.save(data));
    }
}
