package com.lms.enrollmentService.controller;

import com.lms.enrollmentService.dto.EnrollmentDto;
import com.lms.enrollmentService.exception.EnrollmentNotFound;
import com.lms.enrollmentService.model.response.ApiResponse;
import com.lms.enrollmentService.service.EnrollmentServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.UUID;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {
    final EnrollmentServiceImp enrollmentServiceImp;

    public EnrollmentController(EnrollmentServiceImp enrollmentServiceImp) {
        this.enrollmentServiceImp = enrollmentServiceImp;
    }

    @GetMapping("/{enrollmentid}")
    public ResponseEntity<ApiResponse> getEnrollment(@PathVariable UUID uuid){
        EnrollmentDto enrollmentDto = enrollmentServiceImp.findById(uuid);
        if(enrollmentDto==null){
            throw new EnrollmentNotFound("Enrollment "+uuid+" not found");
        }
        ApiResponse apiResponse = new ApiResponse("Enrollment is found", enrollmentDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/")
    public EnrollmentDto createEnrollment(@RequestBody EnrollmentDto enrollmentDto){
        return enrollmentServiceImp.save(enrollmentDto);
    }

    @PutMapping("/{enrollmentid}")
    public ResponseEntity<ApiResponse> updateEnrollment(@PathVariable UUID uuid, @RequestBody EnrollmentDto enrollmentDto){
        EnrollmentDto enrollmentDto1 = enrollmentServiceImp.updateById(uuid, enrollmentDto);
        if(enrollmentDto1 == null){
            throw new EnrollmentNotFound("Enrollment not found");
        }
        ApiResponse apiResponse = new ApiResponse("Enrollment updated successfully", enrollmentDto1);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{enrollmentid}")
    public void deleteEnrollment(@PathVariable UUID uuid){
        enrollmentServiceImp.deleteById(uuid);
    }

}
