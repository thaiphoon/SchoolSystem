package system.menu.student;

import system.data.course.Course;
import system.data.person.Student;
import system.data.person.Teacher;

import java.util.List;

public class MStudent implements IStudent{

    @Override
    public void showAvailableCourses(List<Course> courses, List<Teacher> teachers) {
        System.out.println("=== All Available Courses ===");
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

    @Override
    public void showEnrolledCourses(List<Course> courses, Student student) {
        System.out.println("=== Your Enrolled Courses ===");
        student.getGrades().forEach(grade -> {
            if (grade.getValue().isEmpty()){
                for(Course course: courses){
                    if (course.getId()== grade.getCourseId()){
                        System.out.printf("(%d): %s  %n", course.getId(), course.getName());
                    }
                }
                }
            });
    }
}
