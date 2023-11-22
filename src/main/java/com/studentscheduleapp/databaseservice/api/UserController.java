package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.CustomLessonRepository;
import com.studentscheduleapp.databaseservice.data.repositories.UserRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("id/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") long id){
        Logger.getGlobal().info("get user successful");
        return ResponseEntity.ok(userRepository.findById(id).orElse(null));
    }
    @GetMapping("email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable("email") String email){
        Logger.getGlobal().info("get user successful");
        return ResponseEntity.ok(userRepository.findByEmail(email).orElse(null));
    }
    @PostMapping("save")
    public ResponseEntity<User> save(@RequestBody User data){
        Logger.getGlobal().info("save user successful");
        return ResponseEntity.ok(userRepository.save(data));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<CustomLesson>> deleteById(@PathVariable("id") long id){
        userRepository.deleteById(id);
        Logger.getGlobal().info("delete user successful");
        return ResponseEntity.ok().build();
    }
}
