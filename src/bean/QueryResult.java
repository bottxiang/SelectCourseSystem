package bean;

public class QueryResult {

    private String Sno;
    private String Sname;
    private String Cno;
    private String Cname;
    private int Grade;

    public String getSno() {
        return Sno;
    }

    public String getSname() {
        return Sname;
    }

    public String getCno() {
        return Cno;
    }

    public String getCname() {
        return Cname;
    }

    public int getGrade() {
        return Grade;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }
}
