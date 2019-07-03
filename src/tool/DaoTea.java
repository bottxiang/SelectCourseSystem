package tool;

import bean.Teacher;
import java.sql.*;
public class DaoTea {

    /**
     * 教师登录
     * **/
    public Teacher loginTea(Teacher tea){
        Teacher tea1 = null;
        try{
            String sql_loginT="select * from teacher where Tno=? and Tpassword=?;";
            Connection conn = new Conn().getConn();
            PreparedStatement pst = conn.prepareStatement(sql_loginT);
            pst.setString(1, tea.getTno());
            pst.setString(2,tea.getTpassword());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                tea1 = new Teacher(rs.getString("Tno"),rs.getString("Tpassword"),rs.getString("Tname"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return tea1;
    }

}