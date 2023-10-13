package com.studentscheduleapp.databaseservice.data.repositories;


import com.studentscheduleapp.databaseservice.data.tablemodels.LessonTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LessonTemplateRepository extends JpaRepository<LessonTemplate, Long> {

    List<LessonTemplate> findByScheduleTemplateId(long id);
}
