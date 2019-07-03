package servlet;

import bean.SC;
import bean.Student;
import tool.DaoCou;
import tool.DaoSc;
import tool.DaoStu;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class serInsertSc extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
/******************************************************************************/
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        Student stu = null;
        if(session.getAttribute("student")==null){
            response.sendRedirect("../Login.jsp");
        }else{
            stu = (Student) session.getAttribute("student");
            //out.println(stu.getSNo()+"SNO");

/******************************************************************************/
            out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
            out.println("  <BODY>");
            try{
                String choiceR[] = request.getParameterValues("choiceCou");
                DaoStu selects = new DaoStu();
                DaoCou selectc = new DaoCou();
                String sno = stu.getSno();
                if(choiceR.length!=0){
                    SC sc[] = new SC[choiceR.length];
                    for(int i =0;i<choiceR.length;i++){
                        sc[i] = new SC();
                        sc[i].setSno(sno);
                        sc[i].setCno(choiceR[i]);
                        sc[i].setGrade(0);
                    }

                    DaoSc insert = new DaoSc();
                    int rs[] = insert.insertSc(sc),sum =0;
                    for(int i =0;i<rs.length;i++){
                        if(rs[i]==0) System.out.println("rs"+i+"is null  !!");
                        sum += rs[i];
                    }
                    if(sum!=0) {
                        out.println("<h2><center>选课成功</cneter></h2>");
                        response.sendRedirect("../stu/showCou.jsp");
                    }
                }else {
                    out.println("<h2><center>选课失败</cneter></h2>");
                    response.setHeader("refresh", "2;url=../stu/choiceCou.jsp");
                }
            }catch(Exception e){e.printStackTrace();out.println("选课失败!");response.setHeader("refresh", "2;url=../stu/choiceCou.jsp");}
            out.println("  </BODY>");
            out.println("</HTML>");}
        out.flush();
        out.close();
    }

}

