package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.OutlineMediaCommentRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.OutlineMedia;
import com.studentscheduleapp.databaseservice.data.tablemodels.OutlineMediaComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/outlineMediaComments")
public class OutlineMediaCommentController {

    @Autowired
    private OutlineMediaCommentRepository outlineMediaCommentRepository;

    @GetMapping("id/{id}")
    public ResponseEntity<OutlineMediaComment> getById(@PathVariable("id") long id){
        Logger.getGlobal().info("get outline media comment successful");
        return ResponseEntity.ok(outlineMediaCommentRepository.findById(id).orElse(null));
    }
    @GetMapping("outlineMedia/{id}")
    public ResponseEntity<List<OutlineMediaComment>> getByOutlineMediaId(@PathVariable("id") long id){
        Logger.getGlobal().info("get outline media comment successful");
        return ResponseEntity.ok(outlineMediaCommentRepository.findByMediaId(id));
    }
    @PostMapping("save")
    public ResponseEntity<OutlineMediaComment> save(@RequestBody OutlineMediaComment data){
        Logger.getGlobal().info("save outline media comment successful");
        return ResponseEntity.ok(outlineMediaCommentRepository.save(data));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<CustomLesson>> deleteById(@PathVariable("id") long id){
        outlineMediaCommentRepository.deleteById(id);
        Logger.getGlobal().info("delete outline media comment successful");
        return ResponseEntity.ok().build();
    }
}
