package com.lms.courseManagementService.controller;

import com.lms.courseManagementService.model.Module;
import com.lms.courseManagementService.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/modules")
public class ModuleController {
    private final  ModuleService moduleService;

    @Autowired
    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping
    public List<Module> getModules(){
        return moduleService.getModules();
    }
    @GetMapping(path = "{moduleId}")
    public Optional<Module> getModule(@PathVariable Long moduleId){
        return moduleService.getModuleById(moduleId);
    }
    @PostMapping
    public void createModule(@RequestBody Module module){
        moduleService.createModule(module);
    }
    @PutMapping(path = "{moduleId}")
    public void updateModule(
            @PathVariable Long moduleId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Integer order){
        this.moduleService.updateModule(moduleId, title, description, order);
    }
    @DeleteMapping(path = "{moduleId}" )
    public void deleteModule(@PathVariable Long moduleId){
        moduleService.deleteModule(moduleId);
    }
}
