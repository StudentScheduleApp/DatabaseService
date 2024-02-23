package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.GroupRepository;
import com.studentscheduleapp.databaseservice.data.repositories.UserRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.Group;
import com.studentscheduleapp.databaseservice.data.tablemodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        Logger.getGlobal().info("get group with id: " + id);
        return ResponseEntity.ok(groupRepository.findById(id).orElse(null));
    }
    @PostMapping("${mapping.group.save}")
    public ResponseEntity<Group> save(@RequestBody Group data){
        if(data.getName() == null || data.getName().isEmpty()) {
            Logger.getGlobal().info("bad request: group name is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Logger.getGlobal().info("save group with id: " + data.getId());
        return ResponseEntity.ok(groupRepository.save(data));
    }
    @DeleteMapping("${mapping.group.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id){
        groupRepository.deleteById(id);
        Logger.getGlobal().info("delete group successful");
        return ResponseEntity.ok().build();
    }
}
