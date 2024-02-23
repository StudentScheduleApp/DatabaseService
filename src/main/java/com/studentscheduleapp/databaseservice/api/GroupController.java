package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.GroupRepository;
import com.studentscheduleapp.databaseservice.data.repositories.UserRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.Group;
import com.studentscheduleapp.databaseservice.data.tablemodels.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;
    private static final Logger log = LogManager.getLogger(GroupController.class);

    @GetMapping("${mapping.group.getById}/{id}")
    public ResponseEntity<Group> getById(@PathVariable("id") long id){
        log.info("get group with id: " + id);
        return ResponseEntity.ok(groupRepository.findById(id).orElse(null));
    }
    @PostMapping("${mapping.group.save}")
    public ResponseEntity<Group> save(@RequestBody Group data){
        if(data.getName() == null || data.getName().isEmpty()) {
            log.info("bad request: group name is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Group d = groupRepository.save(data);
        log.info("save group with id: " + d.getId());
        return ResponseEntity.ok(d);
    }
    @DeleteMapping("${mapping.group.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id){
        try {
            groupRepository.deleteById(id);
            log.info("delete group with id: " + id);
        } catch (EmptyResultDataAccessException e){
            log.warn("delete group with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
