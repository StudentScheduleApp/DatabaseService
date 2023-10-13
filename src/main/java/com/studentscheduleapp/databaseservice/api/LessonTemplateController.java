package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.GroupRepository;
import com.studentscheduleapp.databaseservice.data.repositories.LessonTemplateRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.Group;
import com.studentscheduleapp.databaseservice.data.tablemodels.LessonTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/group")
public class LessonTemplateController {

    @Autowired
    private LessonTemplateRepository lessonTemplateRepository;

    @GetMapping("id/{id}")
    public ResponseEntity<LessonTemplate> getById(@PathVariable("id") long id){
        return ResponseEntity.ok(lessonTemplateRepository.findById(id).get());
    }
    @GetMapping("scheduleTemplate/{id}")
    public ResponseEntity<List<LessonTemplate>> getByScheduleTemplateId(@PathVariable("id") long id){
        return ResponseEntity.ok(lessonTemplateRepository.findByScheduleTemplateId(id));
    }
    @PostMapping("save")
    public ResponseEntity<LessonTemplate> save(@RequestBody LessonTemplate data){
        return ResponseEntity.ok(lessonTemplateRepository.save(data));
    }
}
