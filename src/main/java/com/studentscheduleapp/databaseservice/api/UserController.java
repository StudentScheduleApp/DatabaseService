package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.CustomLessonRepository;
import com.studentscheduleapp.databaseservice.data.repositories.UserRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
        Logger.getGlobal().info("get user with id: " + id);
        return ResponseEntity.ok(userRepository.findById(id).orElse(null));
    }
    @GetMapping("${mapping.user.getByEmail}/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email){
        Logger.getGlobal().info("get user with email: " + email);
        return ResponseEntity.ok(userRepository.findByEmail(email).orElse(null));
    }
    @PostMapping("${mapping.user.save}")
    public ResponseEntity<User> save(@RequestBody User data){
        if(data.getEmail() == null || data.getEmail().isEmpty()) {
            Logger.getGlobal().info("bad request: user email is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(data.getPassword() == null || data.getPassword().isEmpty()) {
            Logger.getGlobal().info("bad request: user password is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(data.getFirstName() == null || data.getFirstName().isEmpty()) {
            Logger.getGlobal().info("bad request: user firstName is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(data.getLastName() == null || data.getLastName().isEmpty()) {
            Logger.getGlobal().info("bad request: user lastName is null or empty");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Logger.getGlobal().info("save user with id: " + data.getId());
        return ResponseEntity.ok(userRepository.save(data));
    }
    @DeleteMapping("${mapping.user.delete}/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id){
        try {
            userRepository.deleteById(id);
            Logger.getGlobal().info("delete user with id: " + id);
        } catch (EmptyResultDataAccessException e){
            Logger.getGlobal().info("delete user with id: " + id + " failed: entity not exists");
        }
        return ResponseEntity.ok().build();
    }
}
