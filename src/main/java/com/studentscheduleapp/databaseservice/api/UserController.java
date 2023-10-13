package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.CustomLessonRepository;
import com.studentscheduleapp.databaseservice.data.repositories.UserRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("id/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") long id){
        return ResponseEntity.ok(userRepository.findById(id).get());
    }
    @GetMapping("email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(userRepository.findByEmail(email).get());
    }
    @PostMapping("save")
    public ResponseEntity<User> save(@RequestBody User data){
        return ResponseEntity.ok(userRepository.save(data));
    }
}
