package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.MemberRepository;
import com.studentscheduleapp.databaseservice.data.repositories.SpecificLessonRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.Member;
import com.studentscheduleapp.databaseservice.data.tablemodels.SpecificLesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
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
        Logger.getGlobal().info("get specificLesson with id: " + id);
        return ResponseEntity.ok(specificLessonRepository.findById(id).orElse(null));
    }
    @GetMapping("${mapping.specificLesson.getByGroupId}/{id}")
    public ResponseEntity<List<SpecificLesson>> getByGroupId(@PathVariable("id") long id){
        Logger.getGlobal().info("get specificLesson with groupId: " + id);
        return ResponseEntity.ok(specificLessonRepository.findByGroupId(id));
    }
    @PostMapping("${mapping.specificLesson.save}")
    public ResponseEntity<SpecificLesson> save(@RequestBody SpecificLesson data){
        Logger.getGlobal().info("save specificLesson with id: " + data.getId());
        return ResponseEntity.ok(specificLessonRepository.save(data));
    }
    @DeleteMapping("${mapping.specificLesson.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id){
        try {
            specificLessonRepository.deleteById(id);
            Logger.getGlobal().info("delete specificLesson with id: " + id);
        } catch (EmptyResultDataAccessException e){
            Logger.getGlobal().info("delete specificLesson with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
