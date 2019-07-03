package servlet;

import bean.SC;
import tool.DaoSc;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class serDoUpdateGrade extends HttpServlet {

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
           // int type = Integer.parseInt(request.getParameter("type"));
            String queryKey = request.getParameter("queryKey");
            SC sc = new SC(request.getParameter("Sno"),request.getParameter("Cno"),Integer.parseInt(request.getParameter("Grade")));
            DaoSc update = new DaoSc();
            int rs = update.updateGrade(sc);
            if(rs!=0){
                out.println("修改成功："+sc.getSno() + " " + sc.getCno());
            }else{
                out.println("修改失败"+sc.getCno() + " " + sc.getCno());
            }
            response.sendRedirect("/Ten/tea/query.jsp");
        }catch(Exception e){e.printStackTrace();}

        out.println("</center></BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }


}
