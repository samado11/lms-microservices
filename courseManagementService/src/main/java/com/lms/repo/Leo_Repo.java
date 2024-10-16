package com.lms.repo;

import com.lms.model.lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Leo_Repo extends JpaRepository<lesson,Long>{

}
