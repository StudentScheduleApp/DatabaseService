package com.studentscheduleapp.databaseservice.data.repositories;


import com.studentscheduleapp.databaseservice.data.tablemodels.OutlineMediaComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OutlineMediaCommentRepository extends JpaRepository<OutlineMediaComment, Long> {

}
