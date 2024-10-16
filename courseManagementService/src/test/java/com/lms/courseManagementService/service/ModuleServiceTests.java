package com.lms.courseManagementService.service;

import com.lms.courseManagementService.dto.ModuleDTO;
import com.lms.courseManagementService.model.Course;
import com.lms.courseManagementService.model.Module;
import com.lms.courseManagementService.repository.CoursesRepository;
import com.lms.courseManagementService.repository.LessonsRepository;
import com.lms.courseManagementService.repository.ModulesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ModuleServiceTests {

    @Mock
    private ModulesRepository modulesRepository;

    @Mock
    private CoursesRepository coursesRepository;

    @Mock
    private LessonsRepository lessonsRepository;

    @InjectMocks
    private ModuleService moduleService;

    @Test
    public void testAddModule() {

        ModuleDTO moduleDTO = new ModuleDTO();
        moduleDTO.setTitle("module title");
        moduleDTO.setDescription("module description");
        moduleDTO.setOrder(1);


        Module expectedModule = new Module();
        expectedModule.setId(1L);
        expectedModule.setTitle(moduleDTO.getTitle());
        expectedModule.setDescription(moduleDTO.getDescription());
        expectedModule.setOrder(moduleDTO.getOrder());


        when(modulesRepository.save(Mockito.any(Module.class))).thenReturn(expectedModule);


        ModuleDTO savedModule = moduleService.addModule(moduleDTO);


        Assertions.assertNotNull(savedModule, "Saved module should not be null");

        verify(modulesRepository).save(Mockito.any(Module.class));
    }

    @Test
    public void testGetAllModules() {
        Module module1 = new Module();
        module1.setId(1L);
        module1.setTitle("Module 1");
        module1.setDescription("Description for Module 1");
        module1.setOrder(1);

        Module module2 = new Module();
        module2.setId(2L);
        module2.setTitle("Module 2");
        module2.setDescription("Description for Module 2");
        module2.setOrder(2);

        List<Module> modules = Arrays.asList(module1, module2);

        when(modulesRepository.findAll()).thenReturn(modules);

        List<ModuleDTO> retrievedModules = moduleService.getAllModules();

        Assertions.assertNotNull(retrievedModules);
        verify(modulesRepository).findAll();

    }

    @Test
    public void testGetModuleById() {
        Module module1 = new Module();
        module1.setId(1L);
        module1.setTitle("Module 1");
        module1.setDescription("Description for Module 1");
        module1.setOrder(1);
        when(modulesRepository.findById(module1.getId())).thenReturn(Optional.of(module1));
        ModuleDTO retrievedModule = moduleService.getModuleById(module1.getId());
        Assertions.assertNotNull(retrievedModule);

    }

    @Test
    public void testDeleteModule() {
        Module module1 = new Module();
        module1.setId(1L);
        module1.setTitle("Module 1");
        module1.setDescription("Description for Module 1");
        module1.setOrder(1);

        when(modulesRepository.findById(module1.getId())).thenReturn(Optional.of(module1));
        doNothing().when(modulesRepository).delete(module1);

        Assertions.assertAll(()->moduleService.deleteModule(module1.getId()));

    }

    @Test
    public void testUpdateModule() {
        Module module1 = new Module();
        module1.setId(1L);
        module1.setTitle("Module 1");
        module1.setDescription("Description for Module 1");
        module1.setOrder(1);

        ModuleDTO moduleDTO = new ModuleDTO();
        moduleDTO.setId(1L);
        moduleDTO.setTitle("Module 1");
        moduleDTO.setDescription("Description for Module 1");
        moduleDTO.setOrder(1);

        when(modulesRepository.findById(module1.getId())).thenReturn(Optional.of(module1));
        when(modulesRepository.save(module1)).thenReturn(module1);

        ModuleDTO updatedModule = moduleService.updateModule(module1.getId(),moduleDTO);
        Assertions.assertNotNull(updatedModule);
    }

    @Test
    public void testGetModuleByCourseTitle() {
        String courseTitle = "Data Science";

        Course course = new Course();
        course.setId(1L);
        course.setTitle(courseTitle);

        Module module1 = new Module();
        module1.setId(1L);
        module1.setTitle("Module 1");
        module1.setDescription("Description 1");
        module1.setOrder(1);
        module1.setCourse(course);

        Module module2 = new Module();
        module2.setId(2L);
        module2.setTitle("Module 2");
        module2.setDescription("Description 2");
        module2.setOrder(2);
        module2.setCourse(course);

        List<Module> expectedModules = List.of(module1, module2);

        when(modulesRepository.findByCourseTitle(courseTitle)).thenReturn(expectedModules);

        List<ModuleDTO> actualModules = moduleService.getModulesByCourseTitle(courseTitle);

        Assertions.assertNotNull(actualModules);

    }

}
