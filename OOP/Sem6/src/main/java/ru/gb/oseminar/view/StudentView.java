package ru.gb.oseminar.view;

import ru.gb.oseminar.data.Student;
import java.util.List;
// SRP: Отображает только студентов, выполняя одну конкретную задачу.
public class StudentView implements UserView<Student>{

    @Override
    public void display(List<Student> students) {
        for (Student student : students) {
            System.out.println("Student: " + student.getFirstName() + " " + student.getSecondName());
        }
    }

}
