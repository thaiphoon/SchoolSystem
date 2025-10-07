package system.data.person;

import system.data.grade.Grade;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{

    List<Grade> grades = new ArrayList<>();
    public Student(int personId, String name) {
        super(personId, name);
    }

    public void addGrade(Grade grade){
        grades.add(grade);
    }

}
