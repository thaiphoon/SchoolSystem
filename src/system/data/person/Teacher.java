package system.data.person;

import system.data.course.Course;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person{

    private List<Course> courseList;

    public Teacher(int personId, String name){
        courseList = new ArrayList<>();
        super(personId, name);
    }

    public void addCourse(Course course){
        this.courseList.add(course);
    }

    public List<Course> getCourseList(){ return this.courseList; }


}
