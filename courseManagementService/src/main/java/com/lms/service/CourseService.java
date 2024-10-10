package com.lms.service;


import com.lms.model.CourseModel;
import com.lms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CourseService {
@Autowired
CourseRepository courseRepository;

public CourseModel createCourse(CourseModel course) {
    return courseRepository.save(course);
}
public CourseModel editCourse(UUID id,CourseModel updatedCourse) {
CourseModel existingCourse = courseRepository.findById(id).get();
existingCourse.setId(updatedCourse.getId());
existingCourse.setTitle(updatedCourse.getTitle());
existingCourse.setDescription(updatedCourse.getDescription());
existingCourse.setStatus(updatedCourse.getStatus());
existingCourse.setCategory(updatedCourse.getCategory());
existingCourse.setCreated_at(updatedCourse.getCreated_at());
existingCourse.setUpdated_at(updatedCourse.getUpdated_at());
    return courseRepository.save(existingCourse);
}
public Optional<CourseModel> viewCourse (UUID id) {
    return courseRepository.findById(id);
}
public Optional<CourseModel> deleteCourse (UUID id) {
    return courseRepository.deleteCourseById(id);
}

}
