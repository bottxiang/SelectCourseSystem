package servlet;

import tool.DaoStu;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class serDeleteStu extends HttpServlet{
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
        out.println("  <BODY>");
        try{

            DaoStu delete = new DaoStu();
            int rs = delete.deleteStu(request.getParameter("id"));
            if(rs==0){
                out.println("<center>删除失败！</center>");
            }else {
                out.println("<center>删除成功！</center>");
            }
            response.setHeader("refresh","2;url=serSelectStu?page="+request.getParameter("page")+"");
            response.sendRedirect("/Ten/tea/selectStu.jsp");
        }catch(Exception e){e.printStackTrace();}
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }
}
