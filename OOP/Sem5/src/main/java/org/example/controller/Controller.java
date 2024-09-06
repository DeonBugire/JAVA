package org.example.controller;

import org.example.model.*;
import org.example.service.DataService;
import org.example.service.StudyGroupService;
import org.example.view.StudentView;
import org.example.view.StudyGroupView;
import java.util.List;

public class Controller {
    private final DataService service = new DataService();
    private final StudyGroupService groupService = new StudyGroupService();
    private final StudentView view = new StudentView();
    private final StudyGroupView groupView = new StudyGroupView();
    private void createStudent(String firstname, String secondName, String patronymic){
        service.create(firstname, secondName, patronymic, Type.STUDENT);
    }
    private void getAllStudents(){
        List<User> userList = service.getAllStudents();
        for(User user: userList){
            Student student = (Student) user;
            view.printOnConsole(student);
        }
    }
    private void createStudyGroup(Long teacherId, List<Long> studentIds) {
        List<Student> students = service.getStudentsByIds(studentIds);
        Teacher teacher = (Teacher) service.getUserById(Type.TEACHER, teacherId);
        StudyGroup studyGroup = groupService.createStudyGroup(teacher, students);
        groupView.printOnConsole(studyGroup);
    }
}
