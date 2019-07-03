package tool;
import bean.Course;
import bean.SC;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DaoSc {
    /*
     * 选课关系插入  	一次插入数条
     * */
    @SuppressWarnings("null")
    public int[] insertSc(SC sc[]){
        int[] rs = null;
        try{
            String sql = "insert into sc(Sno,Cno,Grade) values(?,?,?);";
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            SC tem = null;
            rs = new int[sc.length];
            for(int i = 0;i< sc.length;i++){
                tem = sc[i];
                pst.setString(1, tem.getSno());
                pst.setString(2, tem.getCno());
                pst.setInt(3, tem.getGrade());
                rs[i] = pst.executeUpdate();
            }

        }catch(Exception e){e.printStackTrace();}
        return rs;
    }

    /*
     * 选课关系删除  	一次删除一条
     * */
    public int deleteSc(String sno,String cno){
        int rs = 0;
        try{
            String sql = "delete from sc where Sno=? and Cno=?;";
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, sno);
            pst.setString(2, cno);
            rs = pst.executeUpdate();
        }catch(Exception e){e.printStackTrace();}
        return rs;
    }
    /*
     * 查询某位学生已选课程
     * */
    public Iterator<Course> selectSc(String Sno){
        Iterator<Course> listall = null;
        Course cou = null;
        try{
            List<Course> list  = new ArrayList<Course>();
            String sql = "select sc.Cno,Cname,Cpno,Ccredit from course,sc where course.Cno=sc.Cno and Sno=?;";
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, Sno);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                cou = new Course(rs.getString("sc.Cno"),rs.getString("Cname"),rs.getString("Cpno"),rs.getInt("Ccredit"));
                list.add(cou);
                System.out.println("selected course is over!!");
            }
            listall = list.iterator();
        }catch(Exception e){e.printStackTrace();}
        return listall;
    }
    /*
     * 根据学号、课号唯一查询选课关系
     * */
    public SC selectone(String sno,String cno){
        ResultSet rs = null;
        SC sc = null;
        try{
            String sql = "select * from sc where sno=? and cno=?;";
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,sno);
            pst.setString(2,cno);
            rs = pst.executeQuery();
            if(rs.next()){
                sc = new SC();
                sc.setSno(rs.getString("Sno"));
                sc.setCno(rs.getString("Cno"));
                sc.setGrade(rs.getInt("Grade"));
            }
        }catch(Exception e){e.printStackTrace();}

        return sc;
    }
    /*
     * 选课关系修改教师
     * */
    public int updateGrade(SC sc){
        int rs = 0;
        try{
            String sql = "update sc set Grade=? where Sno=? and Cno=?;";
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, sc.getGrade());
            pst.setString(2, sc.getSno());
            pst.setString(3, sc.getCno());
            rs = pst.executeUpdate();
            if(rs!=0) System.out.println("Grade update over!!");
        }catch(Exception e){e.printStackTrace();}
        return rs;
    }

}
