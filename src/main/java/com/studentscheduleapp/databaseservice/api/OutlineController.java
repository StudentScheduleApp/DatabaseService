package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.MemberRepository;
import com.studentscheduleapp.databaseservice.data.repositories.OutlineRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.Member;
import com.studentscheduleapp.databaseservice.data.tablemodels.Outline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/outlines")
public class OutlineController {

    @Autowired
    private OutlineRepository outlineRepository;

    @GetMapping("id/{id}")
    public ResponseEntity<Outline> getById(@PathVariable("id") long id){
        return ResponseEntity.ok(outlineRepository.findById(id).get());
    }
    @GetMapping("specificLesson/{id}")
    public ResponseEntity<List<Outline>> getBySpecificLessonId(@PathVariable("id") long id){
        return ResponseEntity.ok(outlineRepository.findBySpecificLessonId(id));
    }
    @GetMapping("user/{id}")
    public ResponseEntity<List<Outline>> getByUserId(@PathVariable("id") long id){
        return ResponseEntity.ok(outlineRepository.findByUserId(id));
    }
    @PostMapping("save")
    public ResponseEntity<Outline> save(@RequestBody Outline data){
        return ResponseEntity.ok(outlineRepository.save(data));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<CustomLesson>> deleteById(@PathVariable("id") long id){
        outlineRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
