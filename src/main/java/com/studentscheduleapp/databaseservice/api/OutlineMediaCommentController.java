package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.OutlineMediaCommentRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.OutlineMedia;
import com.studentscheduleapp.databaseservice.data.tablemodels.OutlineMediaComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/outlineMediaComments")
public class OutlineMediaCommentController {

    @Autowired
    private OutlineMediaCommentRepository outlineMediaCommentRepository;

    @GetMapping("id/{id}")
    public ResponseEntity<OutlineMediaComment> getById(@PathVariable("id") long id){
        return ResponseEntity.ok(outlineMediaCommentRepository.findById(id).get());
    }
    @GetMapping("outlineMedia/{id}")
    public ResponseEntity<List<OutlineMediaComment>> getByOutlineMediaId(@PathVariable("id") long id){
        return ResponseEntity.ok(outlineMediaCommentRepository.findByMediaId(id));
    }
    @PostMapping("save")
    public ResponseEntity<OutlineMediaComment> save(@RequestBody OutlineMediaComment data){
        return ResponseEntity.ok(outlineMediaCommentRepository.save(data));
    }
}