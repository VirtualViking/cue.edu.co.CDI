package services.impl;

import Dtos.StudentDto;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import services.StudentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class StudentServiceImpl implements StudentService {

    @Inject

    private List<StudentDto> students;

    public StudentServiceImpl() {
        students = new ArrayList<>(Arrays.asList(
                new StudentDto(1L, "John", "john@example.com", 1),
                new StudentDto(2L, "Alice", "alice@example.com", 2),
                new StudentDto(3L, "Bob", "bob@example.com", 3)));
    }

    @Override
    public List<StudentDto> listar() {
        return students;
    }
}
