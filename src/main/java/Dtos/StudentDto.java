package Dtos;

import java.io.Serializable;

public class StudentDto implements Serializable {

    private Long id;
    private String name;
    private String email;
    private int semester;

    public StudentDto() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getSemester() {
        return semester;
    }

    public StudentDto(Long id, String name, String email, int semester) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.semester = semester;
    }
}
