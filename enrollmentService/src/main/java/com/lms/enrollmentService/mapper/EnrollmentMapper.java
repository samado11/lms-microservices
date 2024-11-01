package com.lms.enrollmentService.mapper;

import com.lms.enrollmentService.dto.EnrollmentDto;
import com.lms.enrollmentService.model.Enrollment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    EnrollmentDto toDto (Enrollment enrollment);
    void toUpdateEntity (EnrollmentDto source, @MappingTarget EnrollmentDto target);
    Enrollment toEntity (EnrollmentDto enrollmentDto);

}
