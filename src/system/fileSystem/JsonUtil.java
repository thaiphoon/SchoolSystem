package system.fileSystem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.typeadapters.RuntimeTypeAdapterFactory;
import system.SchoolSystem;
import system.data.course.Course;
import system.data.grade.Grade;
import system.data.grade.LetterGrade;
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
                            List<Course> coursesList, SchoolSystem schoolSystem){
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

    public SchoolSystem readFromFile(String[] filenames ){
        Gson gson = new Gson();
        String[] tmp = new String[filenames.length];
        try{
            for(int i = 0; i < filenames.length; i++){
                Path path = Paths.get(filenames[i]);
                tmp[i] = Files.readString(path);
            }
        }
        catch (IOException e){
            System.out.println("File not found");
        }

        RuntimeTypeAdapterFactory<Grade> gradeAdapter = RuntimeTypeAdapterFactory
                .of(Grade.class, "type")
                .registerSubtype(LetterGrade.class, "lettergrade");
//                .registerSubtype(LetterGrade.class, "attendance");
//                .registerSubtype(LetterGrade.class, "failedsuccess");


        RuntimeTypeAdapterFactory<Person> studentAdapter = RuntimeTypeAdapterFactory
                .of(Person.class, "type")
                .registerSubtype(Student.class, "student")
                .registerSubtype(Teacher.class, "teacher");

        gson = new GsonBuilder()
                .registerTypeAdapterFactory(gradeAdapter)
                .registerTypeAdapterFactory(studentAdapter)
                .setPrettyPrinting()
                .create();

        Type type = new TypeToken<Map<String, List<Student>>>(){}.getType();
        Map<String, List<Student>> students = gson.fromJson(tmp[0], type);
        System.out.println("studentList.size: " + students.size());

        List<Student> studentList = new ArrayList<>();
        for (Map.Entry<String, List<Student>> entry : students.entrySet()) {
            studentList.addAll(entry.getValue());
        }


        Type typeTeacher = new TypeToken<Map<String, List<Teacher>>>(){}.getType();
        Map<String, List<Teacher>> teachers = gson.fromJson(tmp[1], typeTeacher);
        teachers.size();

        List<Teacher> teachersList = new ArrayList<>();
        for (Map.Entry<String, List<Teacher>> entry : teachers.entrySet()) {
            teachersList.addAll(entry.getValue());
        }

        Type typeCourse = new TypeToken<Map<String, List<Course>>>(){}.getType();
        Map<String, List<Course>> course = gson.fromJson(tmp[2], typeCourse);
        course.size();

        List<Course> courseList = new ArrayList<>();
        for (Map.Entry<String, List<Course>> entry : course.entrySet()) {
            courseList.addAll(entry.getValue());
        }
        return null;

    }



}
