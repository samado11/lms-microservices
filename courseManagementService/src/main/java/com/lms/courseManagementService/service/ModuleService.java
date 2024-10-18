package com.lms.courseManagementService.service;

import com.lms.courseManagementService.dto.ModuleDto;
import org.bouncycastle.math.raw.Mod;

import java.util.List;
import java.util.UUID;

public interface ModuleService {
    ModuleDto save(ModuleDto moduleDto);
    ModuleDto findById(UUID id);
    ModuleDto updateById(UUID id, ModuleDto moduleDto);
    void deleteById(UUID id);
}
