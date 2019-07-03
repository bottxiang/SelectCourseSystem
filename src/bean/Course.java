package bean;

public class Course {

    private String Cno;
    private String Cname;
    private String Cpno;
    private int Ccredit;

    public Course(String cno, String cname, String cpno, int ccredit) {
        Cno = cno;
        Cname = cname;
        Cpno = cpno;
        Ccredit = ccredit;
    }

    public String getCno() {
        return Cno;
    }

    public String getCname() {
        return Cname;
    }

    public String getCpno() {
        return Cpno;
    }

    public int getCcredit() {
        return Ccredit;
    }

    public void setCno(String cno) {
        Cno = cno;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public void setCpno(String cpno) {
        Cpno = cpno;
    }

    public void setCcredit(int ccredit) {
        Ccredit = ccredit;
    }


}
