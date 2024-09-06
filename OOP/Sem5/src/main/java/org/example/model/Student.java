package org.example.model;

public class Student extends User{
    private Long studentId;

    public Student(String firstName, String secondName, String patronymic) {
        super(firstName, secondName, patronymic);
    }

    public Student(String firstName, String secondName, String patronymic, Long studentId) {
        super(firstName, secondName, patronymic);
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId +'\'' +
                ", firstName='" + super.getFirstName() + '\'' +
                ", secondName='" + super.getSecondName() + '\'' +
                ", patronymic='" + super.getPatronymic() + '\'' +
                '}';
    }

}