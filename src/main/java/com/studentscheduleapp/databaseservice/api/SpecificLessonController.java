package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.MemberRepository;
import com.studentscheduleapp.databaseservice.data.repositories.SpecificLessonRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.Member;
import com.studentscheduleapp.databaseservice.data.tablemodels.SpecificLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class SpecificLessonController {

    @Autowired
    private SpecificLessonRepository specificLessonRepository;

    @GetMapping("${mapping.specificLesson.getById}/{id}")
    public ResponseEntity<SpecificLesson> getById(@PathVariable("id") long id){
        Logger.getGlobal().info("get specific lesson successful");
        return ResponseEntity.ok(specificLessonRepository.findById(id).orElse(null));
    }
    @GetMapping("${mapping.specificLesson.getByGroupId}/{id}")
    public ResponseEntity<List<SpecificLesson>> getByGroupId(@PathVariable("id") long id){
        Logger.getGlobal().info("get specific lesson successful");
        return ResponseEntity.ok(specificLessonRepository.findByGroupId(id));
    }
    @PostMapping("${mapping.specificLesson.save}")
    public ResponseEntity<SpecificLesson> save(@RequestBody SpecificLesson data){
        Logger.getGlobal().info("save specific lesson successful");
        return ResponseEntity.ok(specificLessonRepository.save(data));
    }
    @DeleteMapping("${mapping.specificLesson.delete}/{id}")
    public ResponseEntity<List<CustomLesson>> deleteById(@PathVariable("id") long id){
        specificLessonRepository.deleteById(id);
        Logger.getGlobal().info("delete specific lesson successful");
        return ResponseEntity.ok().build();
    }
}
