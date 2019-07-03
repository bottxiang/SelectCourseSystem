package bean;

public class Teacher {

    private String Tno;
    private String Tpassword;
    private String Tname;

    public Teacher(String tno, String tpassword, String tname) {
        Tno = tno;
        Tpassword = tpassword;
        Tname = tname;
    }

    public String getTno() {
        return Tno;
    }

    public String getTpassword() {
        return Tpassword;
    }

    public String getTname() {
        return Tname;
    }

    public void setTno(String tno) {
        Tno = tno;
    }

    public void setTpassword(String tpassword) {
        Tpassword = tpassword;
    }

    public void setTname(String tname) {
        Tname = tname;
    }
}
