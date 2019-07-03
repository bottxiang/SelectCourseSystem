package tool;

import bean.QueryResult;

import java.sql.*;
import java.util.*;

public class DaoQuery {
    /*
     * 根据学号查询选课情况
     * */
    public List<QueryResult> selectSno(String sno){
        List<QueryResult> list = null;
        try{
            list = new ArrayList<QueryResult>();
            String sql = "select student.Sno,Sname,course.Cno,Cname,Grade from student,sc,course " +
                    "where student.Sno=sc.Sno and sc.Cno=course.Cno and student.Sno=?;";
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, sno);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                QueryResult qrs = new QueryResult();
                qrs.setSno(rs.getString("sno"));
                qrs.setCno(rs.getString("cno"));
                qrs.setSname(rs.getString("sname"));
                qrs.setCname(rs.getString("cname"));
                qrs.setGrade(rs.getInt("grade"));
                list.add(qrs);
            }

        }catch(Exception e){e.printStackTrace();}
        return list;
    }
    /*
     * 根据学生姓名查询选课情况
     * */
    public List<QueryResult> selectSname(String name){
        List<QueryResult> list = null;
        try{
            list = new ArrayList<QueryResult>();
            String sql = "select student.Sno,Sname,course.Cno,Cname,Grade from student,sc,course " +
                    "where student.Sno=sc.Sno and sc.Cno=course.Cno and student.Sname=?;";
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, name);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                QueryResult qrs = new QueryResult();
                qrs.setSno(rs.getString("Sno"));
                qrs.setCno(rs.getString("Cno"));
                qrs.setSname(rs.getString("Sname"));
                qrs.setCname(rs.getString("Cname"));
                qrs.setGrade(rs.getInt("Grade"));
                list.add(qrs);
            }
        }catch(Exception e){e.printStackTrace();}
        return list;
    }

    /*
     * 根据课程号查询选课情况
     * */
    public List<QueryResult> selectCno(String cno){
        System.out.println(cno);
        List<QueryResult> list = null;
        try{
            list = new ArrayList<QueryResult>();
            String sql = "select student.Sno,Sname,course.Cno,Cname,Grade from student,sc,course " +
                    "where student.Sno=sc.Sno and sc.Cno=course.Cno and course.Cno=?;";
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cno);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                QueryResult qrs = new QueryResult();
                qrs.setSno(rs.getString("Sno"));
                qrs.setCno(rs.getString("Cno"));
                qrs.setSname(rs.getString("Sname"));
                qrs.setCname(rs.getString("Cname"));
                qrs.setGrade(rs.getInt("Grade"));
                list.add(qrs);
            }

        }catch(Exception e){e.printStackTrace();}
        return list;
    }
    /*
     * 根据课程名查询选课情况
     * */
    public List<QueryResult> selectCname(String cname){
        List<QueryResult> list = null;
        try{
            list = new ArrayList<QueryResult>();
            String sql = "select student.Sno,Sname,course.Cno,Cname,Grade from student,sc,course " +
                    "where student.Sno=sc.Sno and sc.Cno=course.Cno and Cname=?;";
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, cname);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                QueryResult qrs = new QueryResult();
                qrs.setSno(rs.getString("Sno"));
                qrs.setCno(rs.getString("Cno"));
                qrs.setSname(rs.getString("Sname"));
                qrs.setCname(rs.getString("Cname"));
                qrs.setGrade(rs.getInt("Grade"));
                list.add(qrs);
            }

        }catch(Exception e){e.printStackTrace();}
        return list;
    }

}
