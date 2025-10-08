package system;

import system.data.course.Course;
import system.data.grade.Grade;
import system.data.grade.LetterGrade;
import system.data.person.Person;
import system.data.person.Student;
import system.data.person.Teacher;
import system.fileSystem.JsonUtil;
import system.menu.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.PatternSyntaxException;

public class SchoolSystem {

    List<Teacher> teacherList;
    List<Student> studentList;
    List<Course> coursesList;

    public SchoolSystem(){
        teacherList = new ArrayList<Teacher>();
        studentList = new ArrayList<Student>();
        coursesList = new ArrayList<Course>();

        teacherList.add(new Teacher(1, "Ibrahim Hazem"));
        teacherList.add(new Teacher(2, "Bill Palmstedt"));

        studentList.add(new Student(3, "Anthony Rizk Gustavsson"));
        studentList.add(new Student(4, "Joakim Tubring"));
        studentList.add(new Student(5, "Niklas Holmström"));
        studentList.add(new Student(6, "Begaiym Kalilova"));
        studentList.add(new Student(7, "Yuka Tatsumi"));

        coursesList.add(new Course(101, "Java 101"));
        coursesList.add(new Course(102, "Math 101"));
        coursesList.add(new Course(103, "Geography 101"));
        coursesList.add(new Course(104, "History 101"));
        coursesList.add(new Course(105, "Woodshop 101"));

        teacherList.get(0).addCourse(coursesList.get(1));
        teacherList.get(1).addCourse(coursesList.get(0));

        studentList.get(0).addGrade(new LetterGrade(1, 101, "A"));
        JsonUtil jsonUtil = new JsonUtil();
        jsonUtil.writeToJson(teacherList, studentList, coursesList, this);
        jsonUtil.readFromFile("test.dbj");
    }

    private void run(){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Menu menu = new Menu();

        while(true){
            try{
                menu.menuChoices(br, menu.menuText(br, teacherList, studentList, coursesList),
                        teacherList, studentList, coursesList);
            }
            catch (PatternSyntaxException e){
                System.out.println("Regex incomplete");
                e.printStackTrace();
            }
            catch (IOException e){
                System.out.println("Stream closed, check that bufferedreader is active");
                e.printStackTrace();
            }
        }
    }
}
