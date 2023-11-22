package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.OutlineMediaRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.Outline;
import com.studentscheduleapp.databaseservice.data.tablemodels.OutlineMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/outlineMedias")
public class OutlineMediaController {

    @Autowired
    private OutlineMediaRepository outlineMediaRepository;

    @GetMapping("id/{id}")
    public ResponseEntity<OutlineMedia> getById(@PathVariable("id") long id){
        Logger.getGlobal().info("get outline media successful");
        return ResponseEntity.ok(outlineMediaRepository.findById(id).orElse(null));
    }
    @GetMapping("outline/{id}")
    public ResponseEntity<List<OutlineMedia>> getByOutlineId(@PathVariable("id") long id){
        Logger.getGlobal().info("get outline media successful");
        return ResponseEntity.ok(outlineMediaRepository.findByOutlineId(id));
    }
    @PostMapping("save")
    public ResponseEntity<OutlineMedia> save(@RequestBody OutlineMedia data){
        Logger.getGlobal().info("save outline media successful");
        return ResponseEntity.ok(outlineMediaRepository.save(data));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<CustomLesson>> deleteById(@PathVariable("id") long id){
        outlineMediaRepository.deleteById(id);
        Logger.getGlobal().info("delete outline media successful");
        return ResponseEntity.ok().build();
    }
}
