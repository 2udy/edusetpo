package com.seosam.edusetpo.gradeCategory.service;

import com.seosam.edusetpo.gradeCategory.dto.GradeCategoryAddDto;
import com.seosam.edusetpo.gradeCategory.dto.GradeCategoryDto;
import com.seosam.edusetpo.gradeCategory.entity.GradeCategory;

import java.util.List;
import java.util.Optional;

public interface GradeCategoryService {
    // Create
    Optional<Long> createGradeCategory(GradeCategoryAddDto gradeCategoryAddDto, Long tutorId);

    // Read
    List<GradeCategoryDto> findGradeCategoryByTutorId(Long tutorId);

    // Delete
    void deleteGradeCategory(Long gradeCategoryId);


//    default GradeCategory toEntity(GradeCategoryDto gradeCategoryDto) {
//        return GradeCategory.builder()
//                .gradeCategoryId(gradeCategoryDto.getGradeCategoryId())
//                .tutorId(gradeCategoryDto.getTutorId())
//                .category(gradeCategoryDto.getCategory())
//                .build();
//    }

    default GradeCategoryDto toResponseDto(GradeCategory gradeCategory) {
        return GradeCategoryDto.builder()
                .gradeCategoryId(gradeCategory.getGradeCategoryId())
                .category(gradeCategory.getCategory())
                .build();
    }
}
