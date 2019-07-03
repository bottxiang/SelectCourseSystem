package tool;

import java.sql.*;

public class Conn {
    Connection conn = null;
    public static final String DBDRIVER="com.mysql.jdbc.Driver";
    public static final String DBURL="jdbc:mysql://localhost:3306/teach?useUnicode=true&characterEncoding=utf8";
    public static final String DBUSER="root";
    public static final String DBPASS="sesame";

    public Connection getConn()
    {
        try{
            Class.forName(DBDRIVER);
            conn = DriverManager.getConnection(DBURL,DBUSER,DBPASS);
        }catch(Exception e){e.printStackTrace();}
        return conn;
    }

}