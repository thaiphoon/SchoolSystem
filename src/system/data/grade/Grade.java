package system.data.grade;

public abstract class Grade {
    int courseId;
    int gradeId;

    public Grade(int gradeID, int courseId) {
        this.gradeId = gradeID;
        this.courseId = courseId;

    }

    public int getGradeId() {
        return gradeId;
    }

    public int getCourseId() {
        return courseId;
    }

}