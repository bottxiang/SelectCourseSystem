package tool;

import bean.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DaoStu {
    /**
     * 学生登录
     * **/
    public Student loginStu(Student stu){
        Student stu1 = null;
        String sql_loginS="select * from student where Sno=? and Spassword=?;";
        try{
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql_loginS);
            pst.setString(1, stu.getSno());
            pst.setString(2,stu.getSpassword());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                stu1 = new Student(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
                System.out.println("student login select over");
            }
        }catch(Exception e){e.printStackTrace();}
        return stu1;
    }

    /*
     * 查询所有学生
     * */
    public List<Student> selectStu(){
        List<Student> list = null;
        try{
            String sql_select = "select Sno,Spassword,Sname,Ssex,Sage,Sdept from student;";//查询全部学生信息+学分学分;//查询所有的sql语句
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql_select);
            ResultSet rs = pst.executeQuery();
            list = new ArrayList<Student>();
            DaoCou scredit = new DaoCou();
            while(rs.next()){
                Student stu = new Student(rs.getString("Sno"),rs.getString("Spassword"),rs.getString("Sname"),rs.getString("Ssex")
                        ,rs.getInt("Sage"), rs.getString("Sdept"));
                list.add(stu);
            }
        }catch(Exception e){e.printStackTrace();}
        return list;
    }

    /*
     * 查询某条个学生
     * */
    public Student selectStu(String id){
        Student Stu = null;
        try{
            String sql_selectone = "select * from student where Sno=?";//查询某一条课程
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql_selectone);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                System.out.println(rs.getString("Sname"));
                Stu = new Student(rs.getString("Sno"),rs.getString("Spassword"),rs.getString("Sname"),rs.getString("Ssex")
                        ,rs.getInt("Sage"), rs.getString("Sdept"));
            }
        }catch(Exception e){e.printStackTrace();}
        return Stu;
    }
    /*
     * 查询某个学生信息（模糊查询）
     * */
    public Iterator<Student> wideSelectStu(String aa){//aa作为模糊查询的关键字
        List<Student> list = null;
        Iterator<Student> listall = null;
        try{
            String sql_selectfuz = "select * from student where CNo=? or....";//fuzzy query模糊查询
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql_selectfuz);
            ResultSet rs = pst.executeQuery();
            list = new ArrayList<Student>();
            while(rs.next()){
                Student stu = new Student(rs.getString("Sno"),rs.getString("Spassword"),rs.getString("Sname"),rs.getString("Ssex")
                        ,rs.getInt("Sage"), rs.getString("Sdept"));
                list.add(stu);
            }
            listall = list.iterator();
        }catch(Exception e){e.printStackTrace();}
        return listall;
    }
    /*
     * 修改某个学生信息
     * */
    public int updateStu(Student stu){
        int rs = 0;
        try{
            String sql_update = "update Student set Sno=?,Spassword=?,Sname=?,Ssex=?,Sage=?,Sdept=? where Sno=?;";//修改一条学生信息
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql_update);
            pst.setString(1, stu.getSno());
            pst.setString(2, stu.getSpassword());
            pst.setString(3, stu.getSname());
            pst.setString(4, stu.getSsex());
            pst.setInt(5, stu.getSage());
            pst.setString(6, stu.getSdept());
            pst.setString(7, stu.getSno());
            rs = pst.executeUpdate();
            if(rs!=0){
                System.out.println("Student_id"+stu.getSno()+"update over!");
            }
        }catch(Exception e){e.printStackTrace();}
        return rs;
    }
    /*
     * 删除某个学生信息
     * */
    public int deleteStu(String id){
        int rs = 0;
        try{
            String sql_delete = "delete from student where SNo=?;";//删除一条课程信息
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql_delete);
            pst.setString(1, id);
            rs = pst.executeUpdate();
            if(rs!=0){
                System.out.println("Student_id"+id+"delete over!");
            }
        }catch(Exception e){e.printStackTrace();}
        return rs;
    }
    /*
     * 添加一位学生信息
     * */
    public int insertStu(Student stu){
        int rs = 0;
        try{
            String sql_insert = "insert into student(Sno,Spassword,Sname,Ssex,Sage,Sdept) values(?,?,?,?,?,?);";//添加一条课程信息
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql_insert);
            pst.setString(1, stu.getSno());
            pst.setString(2, stu.getSpassword());
            pst.setString(3, stu.getSname());
            pst.setString(4, stu.getSsex());
            pst.setInt(5, stu.getSage());
            pst.setString(6, stu.getSdept());
            rs = pst.executeUpdate();
            if(rs!=0){
                System.out.println("Student_id"+stu.getSno()+"insert over!");
            }
        }catch(Exception e){e.printStackTrace();}
        return rs;
    }
}
