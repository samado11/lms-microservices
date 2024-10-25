package com.lms.repo;

import com.lms.model.lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends JpaRepository<lesson,Long>{

}
