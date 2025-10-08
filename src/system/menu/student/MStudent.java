package system.menu.student;

import system.data.course.Course;
import system.data.person.Teacher;

import java.util.List;

public class MStudent implements IStudent{

    @Override
    public void showAvailableCourses(List<Course> courses, List<Teacher> teachers) {
        courses.forEach(course -> {
            Teacher t = null;
            for(Teacher teacher: teachers){
                if(teacher.getCourseList().contains(course)){
                    t = teacher;
                }
            }
            if(t != null){
                System.out.println("Course id: " + course.getId() + ", name: " + course.getName() + ", teacher: " + t.getName());
            } else {
                System.out.println("Course id: " + course.getId() + ", name: " + course.getName());

            }
        });
    }
}
