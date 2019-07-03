package servlet;

import bean.Course;
import tool.DaoCou;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class serDoInsertCou extends HttpServlet {



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
            Course cou = new Course(request.getParameter("Cno"),request.getParameter("Cname"),request.getParameter("Cpno"),Integer.parseInt(request.getParameter("Ccredit")));
            DaoCou insert = new DaoCou();
            int rs = insert.insertCou(cou);
            if(rs!=0){
                out.println("添加成功："+cou.getCno());
            }else{
                out.println("添加失败"+cou.getCno());

            }
            response.sendRedirect("/Ten/tea/selectCou.jsp");
        }catch(Exception e){e.printStackTrace();}
        out.println("  </center></BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }


}
