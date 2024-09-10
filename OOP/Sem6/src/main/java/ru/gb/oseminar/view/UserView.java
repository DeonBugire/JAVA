package ru.gb.oseminar.view;

import ru.gb.oseminar.data.User;

import java.util.List;
// SRP: Класс отвечает только за отображение информации о пользователе.
public interface UserView<T extends User>{
    void display(List<T> users);
}
