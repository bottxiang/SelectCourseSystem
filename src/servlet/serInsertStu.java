package servlet;

import bean.Student;
import tool.DaoStu;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.*;

public class serInsertStu extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
        out.println("  <BODY><center>");
        try{
            request.setCharacterEncoding("utf-8");
            Student stu = new Student(request.getParameter("Sno"),request.getParameter("Spassword"),
                    request.getParameter("Sname"),request.getParameter("Ssex"),Integer.parseInt(request.getParameter("Sage")),request.getParameter("Sdept"));
            DaoStu insert = new DaoStu();
            int rs = insert.insertStu(stu);
            if(rs!=0){
                out.println("添加成功："+stu.getSno());
            }else{
                out.println("添加失败"+stu.getSno());
            }
            response.sendRedirect("/Ten/tea/selectStu.jsp");
        }catch(Exception e){e.printStackTrace();}
        out.println("  </center></BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
