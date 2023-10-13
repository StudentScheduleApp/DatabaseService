package com.studentscheduleapp.databaseservice.data.repositories;


import com.studentscheduleapp.databaseservice.data.tablemodels.CustomLesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomLessonRepository extends JpaRepository<CustomLesson, Long> {
    List<CustomLesson> findByGroupId(Long id);

}
