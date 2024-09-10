package ru.gb.oseminar.controller;

import ru.gb.oseminar.data.User;

import java.time.LocalDate;
// LSP: Контроллер позволяет заменить конкретные реализации, такие как StudentController или TeacherController.
public interface UserController<T extends User> {
    void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth);
}
