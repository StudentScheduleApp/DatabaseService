package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.GroupRepository;
import com.studentscheduleapp.databaseservice.data.repositories.ScheduleTemplateRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.Group;
import com.studentscheduleapp.databaseservice.data.tablemodels.ScheduleTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class ScheduleTemplateController {

    @Autowired
    private ScheduleTemplateRepository scheduleTemplateRepository;

    @GetMapping("${mapping.scheduleTemplate.getById}/{id}")
    public ResponseEntity<ScheduleTemplate> getById(@PathVariable("id") long id){
        Logger.getGlobal().info("get schedule template successful");
        return ResponseEntity.ok(scheduleTemplateRepository.findById(id).orElse(null));
    }
    @GetMapping("${mapping.scheduleTemplate.getByGroupId}/{id}")
    public ResponseEntity<List<ScheduleTemplate>> getByGroupId(@PathVariable("id") long id){
        Logger.getGlobal().info("get schedule template successful");
        return ResponseEntity.ok(scheduleTemplateRepository.findByGroupId(id));
    }
    @PostMapping("${mapping.scheduleTemplate.save}")
    public ResponseEntity<ScheduleTemplate> save(@RequestBody ScheduleTemplate data){
        Logger.getGlobal().info("save schedule template successful");
        return ResponseEntity.ok(scheduleTemplateRepository.save(data));
    }
    @DeleteMapping("${mapping.scheduleTemplate.delete}/{id}")
    public ResponseEntity<List<CustomLesson>> deleteById(@PathVariable("id") long id){
        scheduleTemplateRepository.deleteById(id);
        Logger.getGlobal().info("delete schedule template successful");
        return ResponseEntity.ok().build();
    }
}
