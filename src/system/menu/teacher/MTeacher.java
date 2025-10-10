package system.menu.teacher;

import com.sun.jdi.connect.Connector;
import system.data.course.Course;
import system.data.grade.Grade;
import system.data.grade.LetterGrade;
import system.data.person.Student;
import system.data.person.Teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class MTeacher {

public MTeacher(){

}

public void menu(BufferedReader br, Teacher teacher, List<Student> students){
    System.out.println("Options");
    System.out.println("1. view courses");
    System.out.println("2. select student");
    Integer i = 0;
     try {
        i = Integer.parseInt(br.readLine());
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    switch(i){
        case 1:
            int nr_1 = 1;
            for(Course c : teacher.getCourseList()){
                System.out.println("#" + (nr_1++) +" "+c.getName() + " course code: "  + c.getId());
            }
            break;
        case 2:
        //     all students in all clsses, no duplicates
            HashMap<Integer, ArrayList<Student>> teachersStudents = new HashMap<>();
            for(int k = 0; k < teacher.getCourseList().size(); k++){
                teachersStudents.put(teacher.getCourseList().get(k).getId(), new ArrayList<>());
                for(int l = 0; l < students.size(); l++){
                    int finalK = k;
                    if(students.get(l).getGrades().stream().filter(grade -> grade.getCourseId()
                    == teacher.getCourseList().get(finalK).getId()).toList().size() > 0){
                        teachersStudents.get(teacher.getCourseList().get(k).getId()).add(students.get(l));
                    }
                }
            }

            List<Student> uniqueStudents = new ArrayList<>();

            for(int h = 0; h < teachersStudents.size(); h++){
                if(teachersStudents.get(teachersStudents.keySet().toArray()[h]).isEmpty()){
                    break;
                }
                for(int j = 0; j < teachersStudents.get(teachersStudents.keySet().toArray()[h]).size();
                    j++){
                    if(!uniqueStudents.contains(teachersStudents
                            .get(teachersStudents.keySet().toArray()[h]).get(j))){
                        uniqueStudents.add(teachersStudents.get(teachersStudents.keySet().toArray()[h]).get(j));
                    }
                }
            }

            int nr_2 = 1;
            for(Student st : uniqueStudents){
                System.out.println("#" + (nr_2++) + st.getName());
            }
            int i2 = 0;
            try {
                i2 = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(uniqueStudents.size());
            Student selectedStudent = uniqueStudents.get(i2 - 1);

            System.out.println("Options:");
            System.out.println("#0 go back");
            System.out.println("#1 assign grade to student");

            int i2s = 0;
            try {
                i2s = Integer.parseInt(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            switch (i2s){
                case 1:
                    int gradId, coursId;
                    String value;
                    System.out.println("Choose grade ID");
                    try {
                        gradId = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Choose course ID");
                    try {
                        coursId = Integer.parseInt(br.readLine());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Choose grade");
                    try {
                        value = br.readLine();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    LetterGrade.Rank rank = switch (value) {
                        case "A" -> LetterGrade.Rank.A;
                        case "B" -> LetterGrade.Rank.B;
                        case "C" -> LetterGrade.Rank.C;
                        case "D" -> LetterGrade.Rank.D;
                        case "F" -> LetterGrade.Rank.F;
                        default -> null;
                    };

                    selectedStudent.addGrade(new LetterGrade(gradId, coursId, rank));
                break;
                default:
            }

    }


}


}
