package ru.gb.oseminar.controller;

import ru.gb.oseminar.data.Teacher;
import ru.gb.oseminar.service.UserService;
import ru.gb.oseminar.view.UserView;
import java.time.LocalDate;

public class TeacherController implements UserController<Teacher>{

    private final UserService<Teacher> teacherService;
    private final UserView<Teacher> teacherView;
    public TeacherController(UserService<Teacher> teacherService, UserView<Teacher> teacherView) {
        this.teacherService = teacherService;
        this.teacherView = teacherView;
    }

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        teacherService.create(firstName, secondName, patronymic, dateOfBirth);
        teacherView.display(teacherService.getAll());
    }
}