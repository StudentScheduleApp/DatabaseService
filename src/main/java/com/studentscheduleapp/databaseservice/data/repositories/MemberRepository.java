package com.studentscheduleapp.databaseservice.data.repositories;


import com.studentscheduleapp.databaseservice.data.tablemodels.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByGroupId(long id);

    List<Member> findByUserId(long id);
}
