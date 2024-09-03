package ru.gb.oseminar.controller;

import ru.gb.oseminar.data.Teacher;
import ru.gb.oseminar.service.StudentGroupService;
import ru.gb.oseminar.service.TeacherService;
import ru.gb.oseminar.view.TeacherView;

import java.time.LocalDate;
import java.util.Collections;

public class TeacherController implements UserController<Teacher>{

    private final TeacherService dataService = new TeacherService();
    private final StudentGroupService studentGroupService = new StudentGroupService();
    private final TeacherView teacherView  = new TeacherView ();

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        dataService.create(firstName, secondName, patronymic, dateOfBirth);
        teacherView.sendOnConsole(dataService.getAll());
    }

    public void getTeacherInStudentGroup(){
       Teacher teacher = studentGroupService.getTeacherFromStudentGroup();
        teacherView.sendOnConsole(Collections.singletonList(teacher));
    }
    public void updateTeacher(Long teacherId, String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        dataService.updateTeacher(teacherId, firstName, secondName, patronymic, dateOfBirth);
        teacherView.sendOnConsole(dataService.getAll());
    }

    public void deleteTeacher(Long teacherId) {
        dataService.deleteTeacher(teacherId);
        teacherView.sendOnConsole(dataService.getAll());
    }
}
