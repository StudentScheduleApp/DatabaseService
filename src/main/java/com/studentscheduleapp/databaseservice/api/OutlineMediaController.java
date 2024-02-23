package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.OutlineMediaRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.Outline;
import com.studentscheduleapp.databaseservice.data.tablemodels.OutlineMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class OutlineMediaController {

    @Autowired
    private OutlineMediaRepository outlineMediaRepository;

    @GetMapping("${mapping.outlineMedia.getById}/{id}")
    public ResponseEntity<OutlineMedia> getById(@PathVariable("id") long id){
        Logger.getGlobal().info("get outlineMedia with id: " + id);
        return ResponseEntity.ok(outlineMediaRepository.findById(id).orElse(null));
    }
    @GetMapping("${mapping.outlineMedia.getByOutlineId}/{id}")
    public ResponseEntity<List<OutlineMedia>> getByOutlineId(@PathVariable("id") long id){
        Logger.getGlobal().info("get outlineMedia with outlineId: " + id);
        return ResponseEntity.ok(outlineMediaRepository.findByOutlineId(id));
    }
    @PostMapping("${mapping.outlineMedia.save}")
    public ResponseEntity<OutlineMedia> save(@RequestBody OutlineMedia data){
        if(data.getImageUrl() == null || data.getImageUrl().isEmpty()) {
            Logger.getGlobal().info("bad request: outlineMedia imageUrl is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Logger.getGlobal().info("save outlineMedia with id: " + data.getId());
        return ResponseEntity.ok(outlineMediaRepository.save(data));
    }
    @DeleteMapping("${mapping.outlineMedia.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id){
        outlineMediaRepository.deleteById(id);
        Logger.getGlobal().info("delete outlineMedia with id: " + id);
        return ResponseEntity.ok().build();
    }
}
