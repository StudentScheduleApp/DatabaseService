package com.studentscheduleapp.databaseservice.data.repositories;


import com.studentscheduleapp.databaseservice.data.tablemodels.Outline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutlineRepository extends JpaRepository<Outline, Long> {

    List<Outline> findBySpecificLessonId(long id);

    List<Outline> findByUserId(long id);
}
