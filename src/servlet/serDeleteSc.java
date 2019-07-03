package servlet;

import bean.Student;
import tool.DaoSc;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@SuppressWarnings("serial")
public class serDeleteSc extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        Student stu = null;
        if(session.getAttribute("student")==null){
            response.sendRedirect("../Login.jsp");
        }else{
            stu = (Student) session.getAttribute("student");
            out.println("Welcome SNO:"+stu.getSno());
            response.setContentType("text/html;charset=utf-8");
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.println("  <BODY>");
            try{
                String sno = stu.getSno();
                String cno = request.getParameter("cno");
                DaoSc delete = new DaoSc();
                int rs = delete.deleteSc(sno, cno);
                if(rs!=0) {
                    System.out.println("Sc one delete over!!");
                    out.println("<h2><center>成功取消选课</center></h2>");
                }else out.println("<h2><center>网络故障！ 请重试！</center></h2>");
                response.sendRedirect("../stu/showCou.jsp");
            }catch(Exception e){e.printStackTrace();}
        }
        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

}
