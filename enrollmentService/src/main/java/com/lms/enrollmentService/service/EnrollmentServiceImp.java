package com.lms.enrollmentService.service;

import com.lms.enrollmentService.dto.EnrollmentDto;
import com.lms.enrollmentService.mapper.EnrollmentMapper;
import com.lms.enrollmentService.model.Enrollment;
import com.lms.enrollmentService.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class EnrollmentServiceImp implements EnrollmentService{
    final EnrollmentRepository enrollmentRepository;
    final EnrollmentMapper enrollmentMapper;

    public EnrollmentServiceImp(EnrollmentRepository enrollmentRepository, EnrollmentMapper enrollmentMapper) {
        this.enrollmentRepository = enrollmentRepository;
        this.enrollmentMapper = enrollmentMapper;
    }

    @Override
    public EnrollmentDto findById(UUID uuid) {
        Enrollment enrollment = enrollmentRepository.findById(uuid)
                .orElseThrow(() -> new RuntimeException("error"));
        return enrollmentMapper.toDto(enrollment);
    }

    @Override
    public EnrollmentDto save(EnrollmentDto enrollmentDto) {
        Enrollment enrollment = enrollmentMapper.toEntity(enrollmentDto);
        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return enrollmentMapper.toDto(savedEnrollment);
    }

    @Override
    public EnrollmentDto updateById(UUID uuid, EnrollmentDto enrollmentDto) {
        EnrollmentDto enrollmentDto1 = findById(uuid);
        enrollmentMapper.toUpdateEntity(enrollmentDto, enrollmentDto1);
        return save(enrollmentDto1);
    }

    @Override
    public void deleteById(UUID uuid) {
        enrollmentRepository.deleteById(uuid);
    }
}
