package system.fileSystem;

import com.google.gson.Gson;
import system.SchoolSystem;
import system.data.course.Course;
import system.data.person.Student;
import system.data.person.Teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {

    public void writeToJson(List<Teacher> teacherList, List<Student> studentList,
                            List<Course> coursesList, SchoolSystem schoolSystem){
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
        for(int i = 0; i < tmpdivide.length; i++) {
            System.out.println(tmpdivide[i]);
        }
        Type type = new TypeToken<ArrayList<Teacher>>(){}.getType();
        List<Teacher> teacherList = gson.fromJson(tmpdivide[3], type);

        type = new TypeToken<ArrayList<Student>>(){}.getType();
        List<Student> studentList = gson.fromJson(tmpdivide[1], type);

        type = new TypeToken<ArrayList<Course>>(){}.getType();
        List<Course> coursesList = gson.fromJson(tmpdivide[5], type);
        return null;

    }



}
