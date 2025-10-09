package system.fileSystem;

import system.data.course.Course;
import system.data.person.Student;
import system.data.person.Teacher;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {

    private static volatile FileSystem instance;
    private List<Teacher> teacherList;
    private List<Student> studentList;
    private List<Course> coursesList;
    private JsonUtil jsonUtil;

    private FileSystem(){
        this.teacherList = new ArrayList<>();
        this.studentList = new ArrayList<>();
        this.coursesList = new ArrayList<>();
        this.jsonUtil = new JsonUtil();
    }

    public List<Teacher> getTeacherList(){ return this.teacherList; }
    public List<Student> getStudentList(){ return this.studentList; }
    public List<Course> getCoursesList(){ return this.coursesList; }

    public static FileSystem getInstance() {
        if (instance == null) {
            synchronized (FileSystem.class) {
                if (instance == null) {
                    instance = new FileSystem();
                }
            }
        }
        return instance;
    }

    public void addTeachers(List<Teacher> teachers){
        this.teacherList = teachers;
        writeToJson();
    }
    public void addStudents(List<Student> students){
        this.studentList = students;
        writeToJson();
    }
    public void addCourses(List<Course> courses){
        this.coursesList = courses;
        writeToJson();
    }

    public void writeToJson(){
        jsonUtil.writeToJson(this.teacherList, this.studentList, this.coursesList);
    }

    public void readJson(){
        readStudentsJson();
        readTeachersJson();
        readCoursesJson();
    }

    public void readTeachersJson(){
        this.teacherList = jsonUtil.readTeachersFromFile("file/teacher.json");
    }

    public void readCoursesJson(){
        this.coursesList = jsonUtil.readCoursesFromFile("file/course.json");
    }

    public void readStudentsJson(){
        this.studentList = jsonUtil.readStudentsFromFile("file/student.json");
    }
}
