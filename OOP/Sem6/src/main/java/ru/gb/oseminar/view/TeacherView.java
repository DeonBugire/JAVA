package ru.gb.oseminar.view;

import ru.gb.oseminar.data.Teacher;
import java.util.List;
// SRP: Отображает только учителей, не смешивая логику с другими типами пользователей.
public class TeacherView implements UserView<Teacher> {
    @Override
    public void display(List<Teacher> teachers) {
        for (Teacher teacher : teachers) {
            System.out.println("Teacher: " + teacher.getFirstName() + " " + teacher.getSecondName());
        }
    }
}

