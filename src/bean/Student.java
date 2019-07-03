package bean;

public class Student {

    private String Sno;
    private String Spassword;
    private String Sname;
    private String Ssex;
    private int Sage;
    private String Sdept;

    public Student(String sno, String spassword, String sname, String ssex, int sage, String sdept) {
        Sno = sno;
        Spassword = spassword;
        Sname = sname;
        Ssex = ssex;
        Sage = sage;
        Sdept = sdept;
    }

    public String getSno() {
        return Sno;
    }

    public String getSpassword() {
        return Spassword;
    }

    public String getSname() {
        return Sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public int getSage() {
        return Sage;
    }

    public String getSdept() {
        return Sdept;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public void setSpassword(String spassword) {
        Spassword = spassword;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public void setSage(int sage) {
        Sage = sage;
    }

    public void setSdept(String sdept) {
        Sdept = sdept;
    }
}
