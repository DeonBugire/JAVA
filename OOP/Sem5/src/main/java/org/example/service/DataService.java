package org.example.service;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.model.Type;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataService {
    private List<User> userList;

    public void create(String firstname, String secondName, String patronymic, Type type) {
        Long id = getFreeId(type);
        if (Type.STUDENT == type) {
            Student student = new Student(firstname, secondName, patronymic, id);
            userList.add(student);
        }
        if (Type.TEACHER == type) {
            Teacher teacher = new Teacher(firstname, secondName, patronymic, id);
            userList.add(teacher);
        }
    }
    public List<Student> getStudentsByIds(List<Long> studentIds) {
        List<Student> students = new ArrayList<>();
        for (Long studentId : studentIds) {
            User user = getUserById(Type.STUDENT, studentId);
            if (user instanceof Student) {
                students.add((Student) user);
            }
        }
        return students;
    }
    public User getUserById(Type type, Long id){
        boolean isStudent = Type.STUDENT == type;
        User currentUser = null;
        for (User user: userList) {
            if (user instanceof Teacher && !isStudent && Objects.equals(((Teacher) user).getTeacherId(), id)) {
                currentUser = user;
            }
            if (user instanceof Student && isStudent && Objects.equals(((Student) user).getStudentId(), id)) {
                currentUser = user;
            }
        }
        return currentUser;
    }

    public List<User> getAllUsers()
    {
        return userList;
    }
    public List<User> getAllStudents() {
        List<User> students = new ArrayList<>();
        for (User user: userList){
            if (user instanceof Student){
                students.add(user);
            }
        }
        return students;
    }
    private Long getFreeId (Type type){
        boolean isStudent = Type.STUDENT == type;
        long lastId = 1L;
        for (User user: userList) {
            if (user instanceof Teacher && !isStudent) {
                lastId = ((Teacher) user).getTeacherId() + 1;
            }
            if (user instanceof Student && isStudent) {
                lastId = ((Student) user).getStudentId() + 1;
            }
        }
        return lastId;
    }
}

