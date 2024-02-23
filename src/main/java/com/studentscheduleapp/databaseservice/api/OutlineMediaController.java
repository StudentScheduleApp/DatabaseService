package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.OutlineMediaRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.Outline;
import com.studentscheduleapp.databaseservice.data.tablemodels.OutlineMedia;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OutlineMediaController {

    @Autowired
    private OutlineMediaRepository outlineMediaRepository;
    private static final Logger log = LogManager.getLogger(OutlineMediaController.class);

    @GetMapping("${mapping.outlineMedia.getById}/{id}")
    public ResponseEntity<OutlineMedia> getById(@PathVariable("id") long id){
        log.info("get outlineMedia with id: " + id);
        return ResponseEntity.ok(outlineMediaRepository.findById(id).orElse(null));
    }
    @GetMapping("${mapping.outlineMedia.getByOutlineId}/{id}")
    public ResponseEntity<List<OutlineMedia>> getByOutlineId(@PathVariable("id") long id){
        log.info("get outlineMedia with outlineId: " + id);
        return ResponseEntity.ok(outlineMediaRepository.findByOutlineId(id));
    }
    @PostMapping("${mapping.outlineMedia.save}")
    public ResponseEntity<OutlineMedia> save(@RequestBody OutlineMedia data){
        if(data.getImageUrl() == null || data.getImageUrl().isEmpty()) {
            log.info("bad request: outlineMedia imageUrl is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        OutlineMedia d = outlineMediaRepository.save(data);
        log.info("save outlineMedia with id: " + d.getId());
        return ResponseEntity.ok(d);
    }
    @DeleteMapping("${mapping.outlineMedia.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id){
        try {
            outlineMediaRepository.deleteById(id);
            log.info("delete outlineMedia with id: " + id);
        } catch (EmptyResultDataAccessException e){
            log.warn("delete outlineMedia with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
