package system.fileSystem;

import com.google.gson.*;
import system.SchoolSystem;
import system.data.course.Course;
import system.data.person.Student;
import system.data.person.Teacher;

import java.io.IOException;
import java.util.List;

public class JsonUtil {

    public void writeToJson(List<Teacher> teacherList, List<Student> studentList,
                            List<Course> coursesList){
        Gson gson = new Gson();
        StringBuilder sb = new StringBuilder();
        sb.append("students@")
            .append(gson.toJson(studentList))
            .append("@")
            .append("teachers@")
            .append(gson.toJson(teacherList))
            .append("@")
            .append("courses@")
            .append(gson.toJson(coursesList))
            .append("@");

        try{
            new FileWriter().writeToFile(sb.toString(), "test.dbj");
        } catch (IOException e) {
            System.out.println("Filename empty");
        }
    }

    public SchoolSystem readFromFile(String filename){
        Gson gson = new Gson();
        String tmp = "";
        try{
            tmp = new FileReader().readFromFile(filename);
        }
        catch (IOException e){
            System.out.println("File not found");
        }
        String[] tmpdivide = tmp.split(new String("@"));

        List<Teacher> teacherList = List.of(gson.fromJson(tmpdivide[3], Teacher[].class));
        List<Course> coursesList = List.of(gson.fromJson(tmpdivide[5], Course[].class));
        List<Student> studentList = List.of(gson.fromJson(tmpdivide[1], Student[].class));
        return null;
    }
}
