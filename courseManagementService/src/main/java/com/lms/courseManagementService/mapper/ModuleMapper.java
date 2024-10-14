package com.lms.courseManagementService.mapper;

import com.lms.courseManagementService.dto.LessonDTO;
import com.lms.courseManagementService.dto.ModuleDTO;
import com.lms.courseManagementService.model.Course;
import com.lms.courseManagementService.model.Lesson;
import com.lms.courseManagementService.model.Module;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ModuleMapper {
    public static ModuleDTO toDTO(Module module) {
        List<LessonDTO> lessonDTOs = Optional.ofNullable(module.getLessons())
                .orElse(Collections.emptyList())
                .stream()
                .map(lesson -> new LessonDTO(
                        lesson.getId(),
                        lesson.getTitle(),
                        lesson.getContent_url(),
                        lesson.getOrder(),
                        module.getId()
                ))
                .collect(Collectors.toList());

        return new ModuleDTO(
                module.getId(),
                module.getTitle(),
                module.getDescription(),
                module.getOrder(),
                module.getCourse() != null ? module.getCourse().getId() : null,
                module.getCourse() != null ? module.getCourse().getTitle() : null,
                lessonDTOs
        );
    }

    public static Module toEntity(ModuleDTO moduleDTO) {
        List<Lesson> lessons = moduleDTO.getLessons().stream()
                .map(lessonDTO -> new Lesson(lessonDTO.getTitle()))
                .collect(Collectors.toList());

        Module module = new Module();
        module.setId(moduleDTO.getId());
        module.setTitle(moduleDTO.getTitle());
        module.setDescription(moduleDTO.getDescription());
        module.setOrder(moduleDTO.getOrder());

        Course course = new Course();
        course.setId(moduleDTO.getCourseId());
        course.setTitle(moduleDTO.getCourseTitle());
        module.setCourse(course);


        lessons.forEach(lesson -> {
            lesson.setModule(module);
        });
        module.setLessons(lessons);

        return module;
    }

}
