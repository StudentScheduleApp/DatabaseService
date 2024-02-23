package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.OutlineMediaCommentRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.OutlineMedia;
import com.studentscheduleapp.databaseservice.data.tablemodels.OutlineMediaComment;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OutlineMediaCommentController {

    @Autowired
    private OutlineMediaCommentRepository outlineMediaCommentRepository;
    private static Logger log = LogManager.getLogger(OutlineMediaCommentController.class);

    @GetMapping("${mapping.outlineMediaComment.getById}/{id}")
    public ResponseEntity<OutlineMediaComment> getById(@PathVariable("id") long id){
        log.info("get outlineMediaComment with id: " + id);
        return ResponseEntity.ok(outlineMediaCommentRepository.findById(id).orElse(null));
    }
    @GetMapping("${mapping.outlineMediaComment.getByOutlineMediaId}/{id}")
    public ResponseEntity<List<OutlineMediaComment>> getByOutlineMediaId(@PathVariable("id") long id){
        log.info("get outlineMediaComment with outlineMediaId: " + id);
        return ResponseEntity.ok(outlineMediaCommentRepository.findByMediaId(id));
    }
    @PostMapping("${mapping.outlineMediaComment.save}")
    public ResponseEntity<OutlineMediaComment> save(@RequestBody OutlineMediaComment data){
        if(data.getText() == null || data.getText().isEmpty()) {
            log.info("bad request: outlineMediaComment text is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        log.info("save outlineMediaComment with id: " + data.getId());
        return ResponseEntity.ok(outlineMediaCommentRepository.save(data));
    }
    @DeleteMapping("${mapping.outlineMediaComment.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id){
        try {
            outlineMediaCommentRepository.deleteById(id);
            log.info("delete outlineMediaComment with id: " + id);
        } catch (EmptyResultDataAccessException e){
            log.info("delete outlineMediaComment with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
