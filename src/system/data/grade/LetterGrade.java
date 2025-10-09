package system.data.grade;

public class LetterGrade extends Grade{
    Rank rank;

    public enum Rank {A, B, C, D, F}
    public LetterGrade(int gradeId, int courseId, Rank rank) {

        super(gradeId, courseId);
        this.rank = rank;
    }

    public LetterGrade(Rank rank, int gradeID, int courseId) {
        super(gradeID, courseId);
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }
}
