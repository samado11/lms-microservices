package com.lms.courseManagementService.controller;

import com.lms.courseManagementService.dto.ModuleDTO;
import com.lms.courseManagementService.exception.ModuleNotFoundException;
import com.lms.courseManagementService.mapper.ModuleMapper;
import com.lms.courseManagementService.model.Module;
import com.lms.courseManagementService.response.ApiResponse;
import com.lms.courseManagementService.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("/modules")
public class ModuleController {
    private final ModuleService moduleService;

    @GetMapping("/all")
    public ResponseEntity<List<ModuleDTO>> getAll() {
        List<Module> modules = moduleService.getAllModules();
        List<ModuleDTO> moduleDTOS = modules.stream()
                .map(ModuleMapper :: toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(moduleDTOS);

    }

    @GetMapping("/{moduleId}")
    public ResponseEntity<ApiResponse> getModuleById(@PathVariable("moduleId") Long moduleId) {
        try {
            Module module = moduleService.getModuleById(moduleId);
            ModuleDTO moduleDTO = ModuleMapper.toDTO(module);
            return ResponseEntity.ok(new ApiResponse(moduleDTO));
        } catch (ModuleNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createModule(@RequestBody ModuleDTO moduleDTO) {

        try {
            Module module = moduleService.addModule(moduleDTO);
            ModuleDTO response = ModuleMapper.toDTO(module);
            return ResponseEntity.ok(new ApiResponse(response));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/{moduleID}")
    public ResponseEntity<ApiResponse> updateModule(@PathVariable("moduleID") Long moduleID, @RequestBody ModuleDTO moduleDTO) {
        try {
            Module module = moduleService.updateModule(moduleID, moduleDTO);
            ModuleDTO response = ModuleMapper.toDTO(module);
            return ResponseEntity.ok(new ApiResponse(response));
        } catch (ModuleNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @DeleteMapping("/{moduleID}")
    public ResponseEntity<ApiResponse> deleteModule(@PathVariable("moduleID") Long moduleID) {
        try {
            moduleService.deleteModule(moduleID);
            return ResponseEntity.ok(new ApiResponse(moduleID));
        } catch (ModuleNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/by-course")
    public ResponseEntity<ApiResponse> getByCourse(@RequestParam("courseTitle") String courseTitle) {
        try {
            List<Module> modules = moduleService.getModulesByCourseTitle(courseTitle);
            if(modules.isEmpty()) {
                return ResponseEntity.ok().body(new ApiResponse("No Modules Found", null));
            }
            List<ModuleDTO> moduleDTOS = modules.stream()
                    .map(ModuleMapper :: toDTO)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(new ApiResponse(moduleDTOS));
        } catch (Exception e) {
            return ResponseEntity.ok(new ApiResponse(e.getMessage(),null));
        }

    }


}
