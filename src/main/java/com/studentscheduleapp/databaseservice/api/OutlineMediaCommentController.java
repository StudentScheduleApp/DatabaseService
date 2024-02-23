package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.OutlineMediaCommentRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.OutlineMedia;
import com.studentscheduleapp.databaseservice.data.tablemodels.OutlineMediaComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class OutlineMediaCommentController {

    @Autowired
    private OutlineMediaCommentRepository outlineMediaCommentRepository;

    @GetMapping("${mapping.outlineMediaComment.getById}/{id}")
    public ResponseEntity<OutlineMediaComment> getById(@PathVariable("id") long id){
        Logger.getGlobal().info("get outlineMediaComment with id: " + id);
        return ResponseEntity.ok(outlineMediaCommentRepository.findById(id).orElse(null));
    }
    @GetMapping("${mapping.outlineMediaComment.getByOutlineMediaId}/{id}")
    public ResponseEntity<List<OutlineMediaComment>> getByOutlineMediaId(@PathVariable("id") long id){
        Logger.getGlobal().info("get outlineMediaComment with outlineMediaId: " + id);
        return ResponseEntity.ok(outlineMediaCommentRepository.findByMediaId(id));
    }
    @PostMapping("${mapping.outlineMediaComment.save}")
    public ResponseEntity<OutlineMediaComment> save(@RequestBody OutlineMediaComment data){
        if(data.getText() == null || data.getText().isEmpty()) {
            Logger.getGlobal().info("bad request: outlineMediaComment text is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Logger.getGlobal().info("save outlineMediaComment with id: " + data.getId());
        return ResponseEntity.ok(outlineMediaCommentRepository.save(data));
    }
    @DeleteMapping("${mapping.outlineMediaComment.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id){
        outlineMediaCommentRepository.deleteById(id);
        Logger.getGlobal().info("delete outlineMediaComment with id: " + id);
        return ResponseEntity.ok().build();
    }
}
