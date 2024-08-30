package ru.gb.oseminar.controller;

import ru.gb.oseminar.data.Student;
import ru.gb.oseminar.data.Teacher;
import ru.gb.oseminar.data.User;
import ru.gb.oseminar.service.DataService;
import ru.gb.oseminar.service.StudentGroupService;
import ru.gb.oseminar.view.UserView;
import ru.gb.oseminar.data.Stream;
import ru.gb.oseminar.service.StreamService;
import java.time.LocalDate;
import java.util.List;

public class UserController {

    private final DataService dataService = new DataService();
    private final StudentGroupService studentGroupService = new StudentGroupService();
    private final UserView userView = new UserView();
    private final StreamService streamService = new StreamService();

    public void createStudent(String firstName, String secondName, String patronymic, LocalDate dateOfBirth){
        dataService.create(firstName, secondName, patronymic, dateOfBirth);
        List<User> userList = dataService.getAll();
        userView.sendOnConsole(userList);
    }

    public void createStudentGroup(Teacher teacher, List<Student> students){
        studentGroupService.createStudentGroup(teacher, students);
    }

    public Student getStudentInStudentGroup(String firstName, String secondName){
        return studentGroupService.getStudentFromStudentGroup(firstName, secondName);
    }

    public List<Student> getSortedListStudentFromStudentGroup(){
        return studentGroupService.getSortedStudentGroup();
    }

    public List<Student> getSortedListByFIOStudentFromStudentGroup(){
        return studentGroupService.getSortedByFIOStudentGroup();
    }
    public List<Stream> getSortedListStreams(List<Stream> streams) {
        return streamService.getSortedStreams(streams);
    }
}
