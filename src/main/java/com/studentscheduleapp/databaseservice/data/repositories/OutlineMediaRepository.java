package com.studentscheduleapp.databaseservice.data.repositories;


import com.studentscheduleapp.databaseservice.data.tablemodels.OutlineMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutlineMediaRepository extends JpaRepository<OutlineMedia, Long> {

    List<OutlineMedia> findByOutlineId(long id);
}
