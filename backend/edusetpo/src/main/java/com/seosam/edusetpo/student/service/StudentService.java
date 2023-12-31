package com.seosam.edusetpo.student.service;

import com.seosam.edusetpo.student.dto.StudentDto;
import com.seosam.edusetpo.student.dto.StudentResponseDto;
import com.seosam.edusetpo.student.dto.StudentToggleDto;
import com.seosam.edusetpo.student.dto.StudentUpdateDto;
import com.seosam.edusetpo.student.entity.Student;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    // create
    Optional<Long> createStudent(Long tutorId, StudentDto studentDto);


    // read
    Optional<StudentResponseDto> findStudent(Long studentId);
    List<StudentResponseDto> findAllStudent(Long userId, String who);

    // update
    boolean updateStudent(Long studentId, StudentUpdateDto studentUpdateDto);
    boolean toggleStudent(Long studentId, StudentToggleDto studentToggleDto);


    // delete


    // DB -> 서버
    default StudentResponseDto toResponseDto(Student student) {
        return StudentResponseDto.builder()
                .studentId(student.getStudentId())
                .tutorId(student.getTutorId())
                .studentName(student.getStudentName())
                .studentContact(student.getStudentContact())
                .parentContact(student.getParentContact())
                .isActive(student.getIsActive())
                .build();
    }

    // 서버 -> DB
    default Student toEntity(Long tutorId, StudentDto studentDto) {
        return Student.builder()
                .tutorId(tutorId)
                .studentName(studentDto.getStudentName())
                .studentContact(studentDto.getStudentContact())
                .parentContact(studentDto.getParentContact())
                .createdAt(LocalDateTime.now())
                .isActive(true)
                .build();
    }

}
