package com.lms.courseManagementService.controller;

import com.lms.courseManagementService.dto.ModuleDto;
import com.lms.courseManagementService.exception.ModuleNotFoundException;
import com.lms.courseManagementService.model.response.ApiResponse;
import com.lms.courseManagementService.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/modules")
public class ModuleController {
    final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping("/{moduleid}")
    public ResponseEntity<ApiResponse> getModule(@PathVariable UUID id){
        ModuleDto moduleDto = moduleService.findById(id);
        if(moduleDto==null){
            throw new ModuleNotFoundException("Module with id "+id+" is not found");
        }
        ApiResponse apiResponse = new ApiResponse("Module found successfully", moduleDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/")
    public ModuleDto createModule(@RequestBody ModuleDto moduleDto){
        return moduleService.save(moduleDto);
    }

    @PutMapping("/{moduleid}")
    public ResponseEntity<ApiResponse> editModule(@PathVariable UUID id, @RequestBody ModuleDto moduleDto){
        ModuleDto moduleDto1 = moduleService.updateById(id, moduleDto);
        if(moduleDto1==null){
            throw new ModuleNotFoundException("Module with id "+id+" is not found");
        }
        ApiResponse apiResponse = new ApiResponse("Module is updated", moduleDto1);
        return ResponseEntity.ok(apiResponse);
    }
    @DeleteMapping("/{moduleid}")
    public void deleteModule(@PathVariable UUID id){
        moduleService.deleteById(id);
    }

}
