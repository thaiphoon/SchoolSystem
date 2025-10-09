package system.data.person;

import system.data.grade.Grade;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Student extends Person {

    List<Grade> grades = new ArrayList<>();

    public Student(int personId, String name) {
        super(personId, name);
        this.type = "student";
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public void assignGrade(Grade newgrade) {
        int index = 0;
        try {
            index = grades.indexOf(grades.stream().filter((g) -> g.getGradeId() == newgrade.getGradeId()).toList().getFirst());
            grades.set(index, newgrade);
        } catch (NullPointerException e) {
            e.printStackTrace();
            grades.add(newgrade);
        }catch (NoSuchElementException e) {
            e.printStackTrace();
            grades.add(newgrade);
        }

    }

    public List<Grade> getGrades() {
        return grades;
    }
}