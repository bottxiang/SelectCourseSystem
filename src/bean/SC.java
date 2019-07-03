package bean;

public class SC {

    private String Sno;
    private String Cno;
    private int Grade;

    public SC(String sno, String cno, int grade) {
        Sno = sno;
        Cno = cno;
        Grade = grade;
    }
    public SC() {

    }

    public String getSno() {
        return Sno;
    }

    public String getCno() {
        return Cno;
    }

    public int getGrade() {
        return Grade;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }
}
