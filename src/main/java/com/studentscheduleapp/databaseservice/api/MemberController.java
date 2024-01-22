package com.studentscheduleapp.databaseservice.api;

import com.studentscheduleapp.databaseservice.data.repositories.GroupRepository;
import com.studentscheduleapp.databaseservice.data.repositories.MemberRepository;
import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import com.studentscheduleapp.databaseservice.data.tablemodels.Group;
import com.studentscheduleapp.databaseservice.data.tablemodels.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("${mapping.member.getById}/{id}")
    public ResponseEntity<Member> getById(@PathVariable("id") long id){
        Logger.getGlobal().info("get member successful");
        return ResponseEntity.ok(memberRepository.findById(id).orElse(null));
    }
    @GetMapping("${mapping.member.getByGroupId}/{id}")
    public ResponseEntity<List<Member>> getByGroupId(@PathVariable("id") long id){
        Logger.getGlobal().info("get member successful");
        return ResponseEntity.ok(memberRepository.findByGroupId(id));
    }
    @GetMapping("${mapping.member.getByUserId}/{id}")
    public ResponseEntity<List<Member>> getByUserId(@PathVariable("id") long id){
        Logger.getGlobal().info("get member successful");
        return ResponseEntity.ok(memberRepository.findByUserId(id));
    }
    @PostMapping("${mapping.member.save}")
    public ResponseEntity<Member> save(@RequestBody Member data){
        Logger.getGlobal().info("save member successful");
        return ResponseEntity.ok(memberRepository.save(data));
    }
    @DeleteMapping("${mapping.member.delete}/{id}")
    public ResponseEntity<List<CustomLesson>> deleteById(@PathVariable("id") long id){
        memberRepository.deleteById(id);
        Logger.getGlobal().info("delete member successful");
        return ResponseEntity.ok().build();
    }
}
