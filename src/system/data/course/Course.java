package system.data.course;

import system.data.person.Student;

import java.util.ArrayList;
import java.util.List;

public class Course {
    int id;
    String name;
    //List<Student> students;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
       // students = new ArrayList<Student>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //public List<Student> getStudents(){
    //    return students;
    //}

    //public void addStudent(Student student){
    //    students.add(student);
    //}

    //public void addStudents(List<Student> groupOfStudents){
    //    students.addAll(groupOfStudents);
    //}
}
