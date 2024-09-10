package ru.gb.oseminar.service;

import java.time.LocalDate;
import java.util.List;
// ISP: Создаем общий интерфейс для работы с любым типом пользователей, абстрагируя детали их создания и получения.
public interface UserService<T> {
    List<T> getAll();
    void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth);
}
