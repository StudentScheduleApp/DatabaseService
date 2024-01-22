package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.CustomLessonRepository;
import com.studentscheduleapp.databaseservice.data.repositories.UserRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("${mapping.user.getById}/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") long id){
        Logger.getGlobal().info("get user successful");
        return ResponseEntity.ok(userRepository.findById(id).orElse(null));
    }
    @GetMapping("${mapping.user.getByEmail}/{id}")
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email){
        Logger.getGlobal().info("get user successful");
        return ResponseEntity.ok(userRepository.findByEmail(email).orElse(null));
    }
    @PostMapping("${mapping.user.save}")
    public ResponseEntity<User> save(@RequestBody User data){
        if(data.getEmail() == null || data.getEmail().isEmpty()) {
            Logger.getGlobal().info("bad request: email is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(data.getPassword() == null || data.getPassword().isEmpty()) {
            Logger.getGlobal().info("bad request: password is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(data.getFirstName() == null || data.getFirstName().isEmpty()) {
            Logger.getGlobal().info("bad request: firstName is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(data.getLastName() == null || data.getLastName().isEmpty()) {
            Logger.getGlobal().info("bad request: lastName is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Logger.getGlobal().info("save user successful");
        return ResponseEntity.ok(userRepository.save(data));
    }
    @DeleteMapping("${mapping.user.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id){
        userRepository.deleteById(id);
        Logger.getGlobal().info("delete user successful");
        return ResponseEntity.ok().build();
    }
}
