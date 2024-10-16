package com.lms.courseManagementService.service;

import com.lms.courseManagementService.model.Module;
import com.lms.courseManagementService.repository.ModuleRepositry;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ModuleService {
    private final ModuleRepositry moduleRepositry;

    @Autowired
    public ModuleService(ModuleRepositry moduleRepositry) {
        this.moduleRepositry = moduleRepositry;
    }

    public List<Module> getModules(){
       return moduleRepositry.findAll();
   }
   public Optional<Module> getModuleById(Long moduleId){
        Optional<Module> module =  moduleRepositry.findById(moduleId);
        if(module.isEmpty())
            throw new IllegalStateException("module with id "+moduleId+"doesn't exist");
        return module;
   }
    public void createModule(Module module) {
        moduleRepositry.save(module);
    }
    public void updateModule(Long moduleId, String title, String description, Integer order) {
        Module module = moduleRepositry.findById(moduleId)
                .orElseThrow(()-> new IllegalStateException("module with id "+moduleId+"doesn't exist"));
        if(title!=null)
            module.setTitle(title);
        if(description!=null)
            module.setDescription(description);
        if(order!=null)
            module.setOrder(order);
        moduleRepositry.save(module);
    }

    public void deleteModule(Long moduleId) {
        boolean isExist = moduleRepositry.existsById(moduleId);
        if(!isExist)
            throw new IllegalStateException("module with id "+moduleId+"doesn't exist");
        moduleRepositry.deleteById(moduleId);
    }
}
