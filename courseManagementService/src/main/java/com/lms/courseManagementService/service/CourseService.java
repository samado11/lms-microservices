package com.lms.courseManagementService.service;



import com.lms.courseManagementService.model.CourseModel;
import com.lms.courseManagementService.model.CourseStatus;
import com.lms.courseManagementService.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService {
    @Autowired
    CoursesRepository courseRepository;

    public CourseModel createCourse(CourseModel course) {
        course.setCreated_at(Timestamp.from(Instant.now()));
        course.setUpdated_at(Timestamp.from(Instant.now()));
        course.setStatus(CourseStatus.ACTIVE);
        return courseRepository.save(course);
    }
    public CourseModel editCourse(UUID id, CourseModel updatedCourse) {
        CourseModel existingCourse = courseRepository.findById(id).get();
        existingCourse.setId(updatedCourse.getId());
        existingCourse.setTitle(updatedCourse.getTitle());
        existingCourse.setDescription(updatedCourse.getDescription());
        existingCourse.setStatus(updatedCourse.getStatus());
        existingCourse.setCategory(updatedCourse.getCategory());
        existingCourse.setCreated_at(updatedCourse.getCreated_at());
        existingCourse.setUpdated_at(Timestamp.from(Instant.now()));
        return courseRepository.save(existingCourse);
    }
    public void viewCourse (UUID id) {
        CourseModel myCourse = courseRepository.findById(id).get();
        System.out.println(myCourse);
        courseRepository.findById(id).get();
    }
    public void deleteCourse (UUID id) {

         courseRepository.deleteById(id);
    }
    public List<CourseModel> getAllCourses(){
        return courseRepository.findAll();
    }

}
