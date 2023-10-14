package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.OutlineMediaRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.Outline;
import com.studentscheduleapp.databaseservice.data.tablemodels.OutlineMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/outlineMedias")
public class OutlineMediaController {

    @Autowired
    private OutlineMediaRepository outlineMediaRepository;

    @GetMapping("id/{id}")
    public ResponseEntity<OutlineMedia> getById(@PathVariable("id") long id){
        return ResponseEntity.ok(outlineMediaRepository.findById(id).get());
    }
    @GetMapping("outline/{id}")
    public ResponseEntity<List<OutlineMedia>> getByOutlineId(@PathVariable("id") long id){
        return ResponseEntity.ok(outlineMediaRepository.findByOutlineId(id));
    }
    @PostMapping("save")
    public ResponseEntity<OutlineMedia> save(@RequestBody OutlineMedia data){
        return ResponseEntity.ok(outlineMediaRepository.save(data));
    }
}
