package system.menu;

import system.data.course.Course;
import system.data.person.Person;
import system.data.person.Student;
import system.data.person.Teacher;
import system.menu.teacher.MTeacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Menu {

    public int menuText(BufferedReader br, List<Teacher> teacherList, List<Student> studentList,
    List<Course> coursesList) throws IOException {
        Person currentPerson = studentList.get(0);
        System.out.println("======School System======");
        System.out.println("0: Exit System");
        System.out.println("1: login as a teacher");
        return Integer.parseInt(br.readLine());
    }

    public void menuChoices(BufferedReader br, int choice, List<Teacher> teacherList, List<Student> studentList,
                            List<Course> coursesList) throws IOException {
        Person currentPerson = studentList.get(0);
        MTeacher tMenu = new MTeacher();
        Teacher teacher = teacherList.get(0);
        switch (choice) {

            case 0:
                br.close();
                System.exit(0);
            case 1:
                tMenu.menu(br, teacher);
                break;
        }
    }
}
