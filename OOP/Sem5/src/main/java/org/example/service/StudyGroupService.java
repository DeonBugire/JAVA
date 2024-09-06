package org.example.service;

import org.example.model.Student;
import org.example.model.Teacher;
import org.example.model.StudyGroup;

import java.util.List;

public class StudyGroupService {

    public StudyGroup createStudyGroup(Teacher teacher, List<Student> students) {
        return new StudyGroup(teacher, students);
    }
}
