package tool;

import java.sql.*;

import bean.Course;

import java.util.*;

public class DaoCou {

    public static final String sql_select = "select * from course;";//查询所有的sql语句
    public static final String sql_selectfuz = "select * from course where Cno=? or....";//fuzzy query模糊查询
    public static final String sql_selectone = "select * from course where Cno=?";//查询某一条课程
    public static final String sql_update = "update course set Cname=?, Cpno=?, Ccredit=? where Cno=?;";//修改一条课程信息
    public static final String sql_delete = "delete from course where Cno=?;";//删除一条课程信息
    public static final String sql_insert = "insert into course(Cno,Cname,Cpno,Ccredit) values(?,?,?,?);";//添加一条课程信息


    /*
     * 查询所有课程信息
     * */
    public Iterator<Course> selectCou() {
        List<Course> list = null;
        Iterator<Course> listall = null;
        try {
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql_select);
            ResultSet rs = pst.executeQuery();
            list = new ArrayList<Course>();
            while (rs.next()) {
                Course cou = new Course(rs.getString("Cno"), rs.getString("Cname"), rs.getString("Cpno"), rs.getInt("Ccredit"));
                list.add(cou);
            }
            listall = list.iterator();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listall;
    }

    /*
     * 查询某条课程信息
     * */
    public Course selectCou(String id) {
        Course cou = null;
        try {
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql_selectone);
            pst.setString(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                cou = new Course(rs.getString("Cno"), rs.getString("Cname"), rs.getString("Cpno"), rs.getInt("Ccredit"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cou;
    }

    /*
     * 修改某条课程信息
     * */
    public int updateCou(Course cou) {
        int rs = 0;
        try {
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql_update);
            pst.setString(1, cou.getCname());
            pst.setString(2, cou.getCpno());
            pst.setInt(3, cou.getCcredit());
            pst.setString(4, cou.getCno());
            rs = pst.executeUpdate();
            if (rs != 0) {
                System.out.println("course_id" + cou.getCno() + "update over!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    /*
     * 删除某条课程信息
     * */
    public int deleteCou(String id) {
        int rs = 0;
        try {
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql_delete);
            pst.setString(1, id);
            rs = pst.executeUpdate();
            if (rs != 0) {
                System.out.println("course_id" + id + "delete over!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    /*
     * 添加一条课程信息
     * */
    public int insertCou(Course cou) {
        int rs = 0;
        try {
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql_insert);
            pst.setString(1, cou.getCno());
            pst.setString(2, cou.getCname());
            pst.setString(3, (!cou.getCpno().equals("")) ? cou.getCpno() : null);
            pst.setInt(4, cou.getCcredit());
            rs = pst.executeUpdate();
            if (rs != 0) {
                System.out.println("course_id" + cou.getCname() + "insert over!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

}