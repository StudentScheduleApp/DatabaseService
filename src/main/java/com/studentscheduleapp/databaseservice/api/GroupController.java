package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.GroupRepository;
import com.studentscheduleapp.databaseservice.data.repositories.UserRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.Group;
import com.studentscheduleapp.databaseservice.data.tablemodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/group")
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;

    @GetMapping("id/{id}")
    public ResponseEntity<Group> getById(@PathVariable("id") long id){
        return ResponseEntity.ok(groupRepository.findById(id).get());
    }
    @PostMapping("save")
    public ResponseEntity<Group> save(@RequestBody Group data){
        return ResponseEntity.ok(groupRepository.save(data));
    }
}
