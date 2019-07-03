package servlet;

import bean.QueryResult;
import bean.Teacher;
import tool.DaoQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class serQuerySc extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
/************************************************************/
        if(session.getAttribute("teacher")==null){
            response.sendRedirect("../Login.jsp");
        }else{
            Teacher tea = (Teacher) session.getAttribute("teacher");
/*************************************************************/
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.println("  <BODY>");
            try{
                request.setCharacterEncoding("utf-8");

                String queryKey = request.getParameter("queryKey");//查询关键字
                int type = 5;
                if(request.getParameter("type")!=null){
                    type = Integer.parseInt(request.getParameter("type"));
                    System.out.println("serQuerySc type:" + type +"queryKey:" + queryKey);
                }
                DaoQuery query = new DaoQuery();
                List<QueryResult> list = new ArrayList<QueryResult>();
                switch(type){
                    case 1:
                        list = query.selectSno(queryKey);break;//学号
                    case 2:
                        list = query.selectSname(queryKey);break;//姓名
                    case 3:
                        list = query.selectCno(queryKey);break;//课程号
                    case 4:
                        list = query.selectCname(queryKey);break;//课程名
                    case 5:
                    default:
                        out.println("<center>错误，请重试！！</center>");break;
                }
                request.setAttribute("queryResult", list);
                request.getRequestDispatcher("/tea/query.jsp?type="+type+"&queryKey="+queryKey).forward(request, response);
            }catch(Exception e){response.sendRedirect("/Ten/tea/query.jsp");e.printStackTrace();}
            out.println("  </BODY>");
            out.println("</HTML>");
        }
        out.flush();
        out.close();
    }

}
