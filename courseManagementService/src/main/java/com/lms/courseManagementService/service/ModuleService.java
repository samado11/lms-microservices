package com.lms.courseManagementService.service;

import com.lms.courseManagementService.dto.ModuleDTO;
import com.lms.courseManagementService.exception.ModuleNotFoundException;
import com.lms.courseManagementService.mapper.ModuleMapper;
import com.lms.courseManagementService.model.Course;
import com.lms.courseManagementService.model.Lesson;
import com.lms.courseManagementService.model.Module;
import com.lms.courseManagementService.repository.CoursesRepository;
import com.lms.courseManagementService.repository.LessonsRepository;
import com.lms.courseManagementService.repository.ModulesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.bouncycastle.math.raw.Mod;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModuleService {


    private final ModulesRepository modulesRepository;

    private final LessonsRepository lessonsRepository;

    private final CoursesRepository coursesRepository;


    public List<ModuleDTO> getAllModules() {

        return modulesRepository.findAll()
                .stream().map(ModuleMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ModuleDTO getModuleById(Long id) {

        Module module = modulesRepository.findById(id)
                .orElseThrow(() -> new ModuleNotFoundException("Module Not Found!"));
        return ModuleMapper.toDTO(module);
    }

    @Transactional
    public void deleteModule(Long id) {
        modulesRepository.findById(id)
                .ifPresentOrElse(modulesRepository::delete, () -> {
                    throw new ModuleNotFoundException("Module Not Found!");
                });
    }

    @Transactional
    public ModuleDTO addModule(ModuleDTO request) {

        List<Lesson> lessons = Optional.ofNullable(request.getLessons())
                .orElse(Collections.emptyList())
                .stream()
                .map(lessonDTO -> {
                    if (lessonDTO.getId() != null) {
                        return lessonsRepository.findById(lessonDTO.getId())
                                .orElseThrow(() -> new RuntimeException("Lesson not found for id: " + lessonDTO.getId()));
                    } else {

                        Lesson newLesson = new Lesson(lessonDTO.getTitle());
                        newLesson.setContent_url(lessonDTO.getContentUrl());
                        newLesson.setOrder(lessonDTO.getOrder());
                        return lessonsRepository.save(newLesson);
                    }
                })
                .collect(Collectors.toList());

        Course course = coursesRepository.findById(request.getCourseId())
                .orElseGet(() -> {
                    Course newCourse = new Course(request.getCourseTitle());
                    return coursesRepository.save(newCourse);
                });

        Module module = ModuleMapper.toEntity(request);
        module.setLessons(lessons);
        module.setCourse(course);
        Module savedModule = modulesRepository.save(module);
        return ModuleMapper.toDTO(savedModule);

    }



    @Transactional
    public ModuleDTO updateModule(Long id, ModuleDTO request) {
        Module existingModule = modulesRepository.findById(id)
                .orElseThrow(() -> new ModuleNotFoundException("Module Not Found!"));
        existingModule.setTitle(request.getTitle());
        existingModule.setDescription(request.getDescription());
        existingModule.setOrder(request.getOrder());
        if (request.getCourseId() != null) {
            Course course = coursesRepository.findById(request.getCourseId())
                    .orElseGet(() -> {
                        Course newCourse = new Course(request.getCourseTitle());
                        return coursesRepository.save(newCourse);
                    });
            existingModule.setCourse(course);
        }


        List<Lesson> updatedLessons = Optional.ofNullable(request.getLessons())
                .orElse(Collections.emptyList())
                .stream()
                .map(lessonDTO -> lessonsRepository.findById(lessonDTO.getId())
                        .orElseGet(() -> {
                            Lesson newLesson = new Lesson(lessonDTO.getTitle());
                            newLesson.setContent_url(lessonDTO.getContentUrl());
                            newLesson.setOrder(lessonDTO.getOrder());
                            return lessonsRepository.save(newLesson);
                        }))
                .collect(Collectors.toList());

        existingModule.setLessons(updatedLessons);

        Module updatedModule = modulesRepository.save(existingModule);
        return ModuleMapper.toDTO(updatedModule);
    }

    public List<ModuleDTO> getModulesByCourseTitle(String courseTitle) {

        return modulesRepository.findByCourseTitle(courseTitle)
                .stream()
                .map(ModuleMapper::toDTO)
                .collect(Collectors.toList());
    }






}