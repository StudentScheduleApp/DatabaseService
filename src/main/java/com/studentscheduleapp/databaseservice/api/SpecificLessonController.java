package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.MemberRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/specificLessons")
public class SpecificLessonController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("id/{id}")
    public ResponseEntity<Member> getById(@PathVariable("id") long id){
        return ResponseEntity.ok(memberRepository.findById(id).get());
    }
    @GetMapping("group/{id}")
    public ResponseEntity<List<Member>> getByGroupId(@PathVariable("id") long id){
        return ResponseEntity.ok(memberRepository.findByGroupId(id));
    }
    @GetMapping("user/{id}")
    public ResponseEntity<List<Member>> getByUserId(@PathVariable("id") long id){
        return ResponseEntity.ok(memberRepository.findByUserId(id));
    }
    @PostMapping("save")
    public ResponseEntity<Member> save(@RequestBody Member data){
        return ResponseEntity.ok(memberRepository.save(data));
    }
}
