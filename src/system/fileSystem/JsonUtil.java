package system.fileSystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import system.data.course.Course;
import system.data.grade.Grade;
import system.data.grade.LetterGrade;
import system.data.grade.PendingGrade;
import system.data.person.Person;
import system.data.person.Student;
import system.data.person.Teacher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.reflect.TypeToken;

public class JsonUtil {

    public void writeToJson(List<Teacher> teacherList, List<Student> studentList,
                            List<Course> coursesList){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String[] names = new String[3];
        Map<String, Object> dataS = new HashMap<>();
        dataS.put("student", studentList);
        names[0] = "student";
        Map<String, Object> dataT = new HashMap<>();

        dataT.put("teacher", teacherList);
        names[1] = "teacher";

        Map<String, Object> dataC = new HashMap<>();
        dataC.put("course", coursesList);
        names[2] = "course";

        String[] jsonOutput = new String[]{ gson.toJson(dataS), gson.toJson(dataT), gson.toJson(dataC) };

        try{
            for (int i = 0; i < 3; i++) {
                String newFile = "file/" + names[i] + ".json";
                Path path = Paths.get(newFile);
                Files.createDirectories(path.getParent());
                Files.writeString(path, jsonOutput[i]);
                System.out.println("JSON file successfully written to: " + path.toAbsolutePath());
            }
        } catch (IOException e) {
            System.out.println("Filename empty");
        }
    }

    public List<Teacher> readTeachersFromFile(String filename){
        Gson gson = new Gson();
        Path path = Paths.get(filename);
        String tmp = "";
        try {
            tmp = Files.readString(path);
        } catch (IOException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);
        }
        Type typeTeacher = new TypeToken<Map<String, List<Teacher>>>(){}.getType();
        Map<String, List<Teacher>> teachers = gson.fromJson(tmp, typeTeacher);
        System.out.println(teachers.size());

        List<Teacher> teachersList = new ArrayList<>();
        for (Map.Entry<String, List<Teacher>> entry : teachers.entrySet()) {
            teachersList.addAll(entry.getValue());
        }
        return teachersList;
    }

    public List<Course> readCoursesFromFile(String filename){
        Gson gson = new Gson();
        Path path = Paths.get(filename);
        String tmp = "";
        try {
            tmp = Files.readString(path);
        } catch (IOException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);
        }

        Type typeCourse = new TypeToken<Map<String, List<Course>>>(){}.getType();
        Map<String, List<Course>> course = gson.fromJson(tmp, typeCourse);
        System.out.println(course.size());

        List<Course> courseList = new ArrayList<>();
        for (Map.Entry<String, List<Course>> entry : course.entrySet()) {
            courseList.addAll(entry.getValue());
        }
        return courseList;
    }


    public List<Student> readStudentsFromFile(String filename){

        Gson gson = new Gson();
        Path path = Paths.get(filename);
        String tmp = "";
        try {
            tmp = Files.readString(path);
        } catch (IOException e) {
            System.out.println("File not found");
            throw new RuntimeException(e);
        }

        RuntimeTypeAdapterFactory<Grade> gradeAdapter = RuntimeTypeAdapterFactory
                .of(Grade.class, "type")
                .registerSubtype(LetterGrade.class, "lettergrade")
                .registerSubtype(PendingGrade.class, "pendinggrade");

        RuntimeTypeAdapterFactory<Person> studentAdapter = RuntimeTypeAdapterFactory
                .of(Person.class, "type")
                .registerSubtype(Student.class, "student");

        gson = new GsonBuilder()
                .registerTypeAdapterFactory(gradeAdapter)
                .registerTypeAdapterFactory(studentAdapter)
                .setPrettyPrinting()
                .create();

        Type type = new TypeToken<Map<String, List<Student>>>(){}.getType();
        Map<String, List<Student>> students = gson.fromJson(tmp, type);
        System.out.println("studentList.size: " + students.size());

        List<Student> studentList = new ArrayList<>();
        for (Map.Entry<String, List<Student>> entry : students.entrySet()) {
            studentList.addAll(entry.getValue());
        }
        return studentList;
    }
}
