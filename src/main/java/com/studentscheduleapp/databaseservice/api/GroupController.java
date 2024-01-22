package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.GroupRepository;
import com.studentscheduleapp.databaseservice.data.repositories.UserRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.Group;
import com.studentscheduleapp.databaseservice.data.tablemodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping("${mapping.group.getById}/{id}")
    public ResponseEntity<Group> getById(@PathVariable("id") long id){
        Logger.getGlobal().info("get group successful");
        return ResponseEntity.ok(groupRepository.findById(id).orElse(null));
    }
    @PostMapping("${mapping.group.save}")
    public ResponseEntity<Group> save(@RequestBody Group data){
        Logger.getGlobal().info("save group successful");
        return ResponseEntity.ok(groupRepository.save(data));
    }
    @DeleteMapping("${mapping.group.delete}/{id}")
    public ResponseEntity<List<CustomLesson>> deleteById(@PathVariable("id") long id){
        groupRepository.deleteById(id);
        Logger.getGlobal().info("delete group successful");
        return ResponseEntity.ok().build();
    }
}
