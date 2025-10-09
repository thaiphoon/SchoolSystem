package system.data.person;

import system.data.grade.Grade;
import system.data.grade.LetterGrade;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person{

    List<LetterGrade> gradesList = new ArrayList<>();

    public Student(int personId, String name) {
        super(personId, name);
    }

    public void addGrade(LetterGrade grade){
        gradesList.add(grade);
    }

}
