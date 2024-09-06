package org.example.view;

import org.example.model.StudyGroup;

public class StudyGroupView {
    public void printOnConsole(StudyGroup studyGroup) {
        System.out.println("Study Group:");
        System.out.println("Teacher: " + studyGroup.getTeacher());
        System.out.println("Students:");
        studyGroup.getStudents().forEach(System.out::println);
    }
}