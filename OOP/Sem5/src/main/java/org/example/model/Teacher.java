package org.example.model;

public class Teacher extends User{

    private Long teacherId;

    public Teacher(String firstName, String secondName, String patronymic) {
        super(firstName, secondName, patronymic);
    }

    public Teacher(String firstName, String secondName, String patronymic, Long teacherId) {
        super(firstName, secondName, patronymic);
        this.teacherId = teacherId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

}
