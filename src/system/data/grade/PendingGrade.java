package system.data.grade;

public class PendingGrade extends Grade{
    public PendingGrade(int gradeId, int courseId, String value)
    {
        super(gradeId, courseId, value);
        this.type = "pendinggrade";
    }
}