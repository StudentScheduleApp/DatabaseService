package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.GroupRepository;
import com.studentscheduleapp.databaseservice.data.repositories.LessonTemplateRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.Group;
import com.studentscheduleapp.databaseservice.data.tablemodels.LessonTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/lessonTemplates")
public class LessonTemplateController {

    @Autowired
    private LessonTemplateRepository lessonTemplateRepository;

    @GetMapping("id/{id}")
    public ResponseEntity<LessonTemplate> getById(@PathVariable("id") long id){
        Logger.getGlobal().info("get lesson template successful");
        return ResponseEntity.ok(lessonTemplateRepository.findById(id).orElse(null));
    }
    @GetMapping("scheduleTemplate/{id}")
    public ResponseEntity<List<LessonTemplate>> getByScheduleTemplateId(@PathVariable("id") long id){
        Logger.getGlobal().info("get lesson template successful");
        return ResponseEntity.ok(lessonTemplateRepository.findByScheduleTemplateId(id));
    }
    @PostMapping("save")
    public ResponseEntity<LessonTemplate> save(@RequestBody LessonTemplate data){
        Logger.getGlobal().info("save lesson template successful");
        return ResponseEntity.ok(lessonTemplateRepository.save(data));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<CustomLesson>> deleteById(@PathVariable("id") long id){
        lessonTemplateRepository.deleteById(id);
        Logger.getGlobal().info("delete lesson template successful");
        return ResponseEntity.ok().build();
    }
}
