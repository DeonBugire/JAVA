package ru.gb.oseminar.controller;

import ru.gb.oseminar.data.Student;
import ru.gb.oseminar.service.UserService;
import ru.gb.oseminar.view.UserView;

import java.time.LocalDate;

// DIP: Зависим от абстракции (UserService и UserView), а не от конкретных классов, работает через интерфейсы сервисов и представлений
// SRP: Контроллер отвечает только за управление логикой, создание пользователей делегируется сервису, а вывод — представлению.
public class StudentController implements UserController<Student> {
    private final UserService<Student> studentService;
    private final UserView<Student> studentView;

    public StudentController(UserService<Student> studentService, UserView<Student> studentView) {
        this.studentService = studentService;
        this.studentView = studentView;
    }

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        studentService.create(firstName, secondName, patronymic, dateOfBirth);
        studentView.display(studentService.getAll());
    }
}
