package repositories;

import Dtos.StudentDto;

import java.util.List;

public interface StudentRepository {

    List<StudentDto> findAll();

    void SaveUser(StudentDto studentDto);
}
