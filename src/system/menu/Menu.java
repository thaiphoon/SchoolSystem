package system.menu;

import system.data.course.Course;
import system.data.person.Person;
import system.data.person.Student;
import system.data.person.Teacher;
import system.inputHandling.SingleIntegerInput;
import system.menu.teacher.MTeacher;
import system.inputHandling.SingleIntegerInput;
import system.inputHandling.SingleIntegerInput;
import system.menu.student.MStudent;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class Menu {

    public int menuText(BufferedReader br, List<Teacher> teacherList, List<Student> studentList,
    List<Course> coursesList) throws IOException, PatternSyntaxException {
        Person currentPerson = studentList.get(0);
        System.out.println("======School System======");
        System.out.println("0: Exit System");
        System.out.println("1: Show All Available Courses");
        System.out.println("2: Show My Enrolled Courses");
        System.out.println("3: Show My Completed Courses");
        System.out.println("11: login as a teacher");
        return new SingleIntegerInput().handleInput(br);
    }

    public void menuChoices(BufferedReader br, int choice, List<Teacher> teacherList, List<Student> studentList,
                            List<Course> coursesList) throws IOException, PatternSyntaxException {
        Person currentPerson = studentList.get(0);
        MTeacher tMenu = new MTeacher();
        Teacher teacher = teacherList.get(0);
        switch (choice) {
            case 0:
                br.close();
                System.exit(0);
            case 1:
                new MStudent().showAvailableCourses(coursesList, teacherList);
                break;
            case 2:
                new MStudent().showEnrolledCourses(coursesList, (Student) currentPerson);
break;
            case 11:
                tMenu.menu(br, teacher, studentList);
                break;
            case 3:
                new MStudent().showCompletedCourses(coursesList, (Student) currentPerson);
                break;
            case 0:
                br.close();
                System.exit(0);
        }
    }
}
