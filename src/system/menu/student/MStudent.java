package system.menu.student;

import system.data.course.Course;
import system.data.grade.PendingGrade;
import system.data.person.Student;
import system.data.person.Teacher;
import system.inputHandling.SingleIntegerInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
                System.out.println("Course id: " + course.getId() + "  Name: " + course.getName() + "  Teacher: " + t.getName());
            } else {
                System.out.println("Course id: " + course.getId() + "  Name: " + course.getName());

            }
        });

    }

    @Override
    public void showEnrolledCourses(List<Course> courses, Student student) {
        System.out.println("=== Your Enrolled Courses ===");
        student.getGrades().forEach(grade -> {
            if (grade instanceof PendingGrade){
                for(Course course: courses){
                    if (course.getId()== grade.getCourseId()){
                        System.out.printf("Course id: %d  Name: %s %n", course.getId(), course.getName());
                    }
                }
            }
        });
    }

    @Override
    public void showCompletedCourses(List<Course> courses, Student student) {
        System.out.println("=== Your Completed Courses ===");
        student.getGrades().forEach(grade -> {
            if (!(grade instanceof PendingGrade)){
                for(Course course: courses){
                    if (course.getId()== grade.getCourseId()){
                        System.out.printf("Course id: %d  Name: %s  Grade: %s %n", course.getId(), course.getName(), grade.getValue());
                    }
                }
            }
        });
    }

    @Override
    public void enrollCourse(List<Course> courses, List<Teacher> teachers, Student student, BufferedReader br) throws IOException {
        Course foundCourse = null;

        while (foundCourse==null){
            System.out.print("Enter id of the course you want to enroll in: ");
            int id = new SingleIntegerInput().handleInput(br);
            for(Course course: courses){
                if (course.getId() == id){
                    foundCourse = course;
                    break;
                }
            }
            if(foundCourse==null){
                System.out.println("Enter 0 to skip enrollment or 1 to try again");
                int choice = new SingleIntegerInput().handleInput(br);
                if (choice == 0){
                    return;
                }

            }

        }
        if(foundCourse != null) {
            Course finalFoundCourse = foundCourse;
            for (int i = 0; i < student.getGrades().size(); i++) {
                if(student.getGrades().get(i).getCourseId() == finalFoundCourse.getId()){
                    System.out.println("You are already enrolled in the course, Choose another course.");
                    return;
                }
            }
            student.addGrade(new PendingGrade(1, finalFoundCourse.getId(), ""));
        }
    }

    @Override
    public void disEnrollCourse(List<Course> courses, List<Teacher> teachers, Student student, BufferedReader br) {
        // TODO Method disEnrollCourse remains to be completed and implemented
    }
}
