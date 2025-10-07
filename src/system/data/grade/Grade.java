package system.data.grade;

public abstract class Grade {
    int courseId;
    int gradeId;
    String value;

    public Grade(int gradeID, int courseId, String value) {
        this.gradeId = gradeID;
        this.courseId = courseId;
        this.value = value;
    }

    public int getGradeId() {
        return gradeId;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getValue() {
        return value;
    }
}