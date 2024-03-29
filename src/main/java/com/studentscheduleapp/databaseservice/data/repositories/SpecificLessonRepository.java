package com.studentscheduleapp.databaseservice.data.repositories;


import com.studentscheduleapp.databaseservice.data.tablemodels.SpecificLesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecificLessonRepository extends JpaRepository<SpecificLesson, Long> {

    List<SpecificLesson> findByGroupId(long id);
}
