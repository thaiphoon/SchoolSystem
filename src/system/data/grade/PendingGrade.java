package system.data.grade;

public class PendingGrade extends Grade{
    public PendingGrade(int gradeId, int courseId)
    {
        super(gradeId, courseId);
        this.type = "pendinggrade";
    }
}