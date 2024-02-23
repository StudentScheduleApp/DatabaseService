package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.MemberRepository;
import com.studentscheduleapp.databaseservice.data.repositories.OutlineRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.Member;
import com.studentscheduleapp.databaseservice.data.tablemodels.Outline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class OutlineController {

    @Autowired
    private OutlineRepository outlineRepository;

    @GetMapping("${mapping.outline.getById}/{id}")
    public ResponseEntity<Outline> getById(@PathVariable("id") long id){
        Logger.getGlobal().info("get outline with id: " + id);
        return ResponseEntity.ok(outlineRepository.findById(id).orElse(null));
    }
    @GetMapping("${mapping.outline.getBySpecificLessonId}/{id}")
    public ResponseEntity<List<Outline>> getBySpecificLessonId(@PathVariable("id") long id){
        Logger.getGlobal().info("get outline with specificLessonId: " + id);
        return ResponseEntity.ok(outlineRepository.findBySpecificLessonId(id));
    }
    @GetMapping("${mapping.outline.getByUserId}/{id}")
    public ResponseEntity<List<Outline>> getByUserId(@PathVariable("id") long id){
        Logger.getGlobal().info("get outline with userId: " + id);
        return ResponseEntity.ok(outlineRepository.findByUserId(id));
    }
    @PostMapping("${mapping.outline.save}")
    public ResponseEntity<Outline> save(@RequestBody Outline data){
        Logger.getGlobal().info("save outline with id: " + data.getId());
        return ResponseEntity.ok(outlineRepository.save(data));
    }
    @DeleteMapping("${mapping.outline.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id){
        try {
            outlineRepository.deleteById(id);
            Logger.getGlobal().info("delete outline with id: " + id);
        } catch (EmptyResultDataAccessException e){
            Logger.getGlobal().info("delete outline with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
