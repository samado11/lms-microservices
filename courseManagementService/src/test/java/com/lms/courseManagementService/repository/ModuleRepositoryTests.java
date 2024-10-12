package com.lms.courseManagementService.repository;

import com.lms.courseManagementService.model.Course;
import com.lms.courseManagementService.model.Module;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ModuleRepositoryTests {

    @Autowired
    private ModulesRepository modulesRepository;

    @Autowired
    private CoursesRepository coursesRepository;



    @Test
    public void testSaveModule() {
        Module module = new Module();
        module.setTitle("module title");
        module.setDescription("module description");
        module.setOrder(1);

        Module savedModule = this.modulesRepository.save(module);

        Assertions.assertNotNull(savedModule, "Saved module should not be null");
        Assertions.assertNotNull(savedModule.getId(), "Saved module ID should not be null");
        Assertions.assertTrue(savedModule.getId() > 0, "Saved module ID should be greater than 0");
    }

    @Test
    public void testFindAllModules() {
        Module module = new Module();
        module.setTitle("module title");
        module.setDescription("module description");
        module.setOrder(1);

        Module module2 = new Module();
        module.setTitle("module2 title");
        module.setDescription("module2 description");
        module.setOrder(2);

        modulesRepository.save(module);
        modulesRepository.save(module2);

        List<Module> modules = modulesRepository.findAll();
        Assertions.assertNotNull(modules);
        Assertions.assertTrue(modules.size() > 0);
    }

    @Test
    public void testFindModuleById() {
        Module module = new Module();
        module.setTitle("module title");
        module.setDescription("module description");
        module.setOrder(1);
        Module savedModule = this.modulesRepository.save(module);
        Module moduleList = modulesRepository.findById(module.getId()).get();
        Assertions.assertNotNull(moduleList);
    }

    @Test
    public void testUpdateModule() {
        Module module = new Module();
        module.setTitle("module title");
        module.setDescription("module description");
        module.setOrder(1);
        modulesRepository.save(module);
        Module savedModule = modulesRepository.findById(module.getId()).get();
        savedModule.setTitle("new module title");
        savedModule.setDescription("new module description");
        savedModule.setOrder(2);
        Module updatedModule = modulesRepository.save(savedModule);

        Assertions.assertNotNull(updatedModule);
    }

    @Test
    public void testDeleteModule() {
        Module module = new Module();
        module.setTitle("module title");
        module.setDescription("module description");
        module.setOrder(1);
        modulesRepository.save(module);
        modulesRepository.deleteById(module.getId());
        Optional<Module> moduleOptional = modulesRepository.findById(module.getId());
        Assertions.assertFalse(moduleOptional.isPresent());
    }

    @Test
    public void testFindModuleByCourseTitle() {

        Course course = new Course("course title");
        Course savedCourse = coursesRepository.save(course);



        Module module = new Module();
        module.setTitle("module title");
        module.setDescription("module description");
        module.setOrder(1);
        module.setCourse(savedCourse);
        modulesRepository.save(module);

        List<Module> modules = modulesRepository.findByCourseTitle(course.getTitle());

        Assertions.assertNotNull(modules);
    }

}
