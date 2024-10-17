package com.lms.courseManagementService.controller;

import com.lms.courseManagementService.dto.ModuleDTO;
import com.lms.courseManagementService.service.ModuleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/modules")
public class ModuleController {
    private final ModuleService moduleService;

    @GetMapping("/all")
    public ResponseEntity<List<ModuleDTO>> getAll() {

        List<ModuleDTO> moduleDTOS = moduleService.getAll();

        return ResponseEntity.ok(moduleDTOS);

    }

    @GetMapping("/{moduleId}")
    public ModuleDTO getModuleById(@PathVariable("moduleId") Long moduleId) {
            ModuleDTO moduleDTO = moduleService.getById(moduleId);;
            return moduleDTO;
    }

    @PostMapping
    public ModuleDTO createModule(@RequestBody ModuleDTO moduleDTO) {
            ModuleDTO response = moduleService.save(moduleDTO);
            return response;
    }

    @PutMapping("/{moduleID}")
    public ModuleDTO updateModule(@PathVariable("moduleID") Long moduleID, @RequestBody ModuleDTO moduleDTO) {
            ModuleDTO response = moduleService.update(moduleID, moduleDTO);
            return response;
    }

    @DeleteMapping("/{moduleID}")
    public ModuleDTO deleteModule(@PathVariable("moduleID") Long moduleID) {
            moduleService.deleteById(moduleID);
        return null;
    }

//    @GetMapping("/by-course")
//    public List<ModuleDTO> getByCourse(@RequestParam("courseTitle") String courseTitle) {
//
//            List<ModuleDTO> moduleDTOS = moduleService.getById(courseTitle);
//            return moduleDTOS;
//
//    }


}
