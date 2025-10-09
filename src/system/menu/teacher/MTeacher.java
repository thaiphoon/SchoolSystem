package system.menu.teacher;

import com.sun.jdi.connect.Connector;
import system.data.course.Course;
import system.data.grade.LetterGrade;
import system.data.person.Student;
import system.data.person.Teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MTeacher {

public MTeacher(){

}

public void menu(BufferedReader br, Teacher teacher){
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
            // all students in all clsses, no duplicates
            List<Student> uniqueStudents = new TreeSet<Student>(teacher.getCourseList().stream()
                    .flatMap(c -> c.getStudents().stream()).toList()).stream().toList();

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
