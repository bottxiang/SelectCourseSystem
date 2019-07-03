package servlet;

import bean.Student;
import bean.Teacher;
import tool.DaoStu;
import tool.DaoTea;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@SuppressWarnings("serial")
public class serDoLogin extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        //response.setCharacterEncoding("utf-8");
        //response.setHeader("content-type","text/html;charset=utf-8");
        try{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String type  = null;
            if(request.getParameter("type")!=null)
                type = request.getParameter("type");
            if(type.equals("tea")){//判断是否为老师
                Teacher tea = new Teacher(username, password, null);
                DaoTea logint = new DaoTea();
                tea = logint.loginTea(tea);
                if(tea!=null){
                    session.setAttribute("teacher", tea);
                    response.sendRedirect("/Ten/tea/teacher.jsp");
                }else{
                    out.println("T用户名或密码不正确，请核对后重试!!");
                    response.setHeader("refresh","2;url=/Ten/tea/teaLogin.jsp");
                }
            }else if(type.equals("stu")){	//判断是否为学生
                Student stu = new Student(username,password,null,null,0,null);
                out.println(stu.getSname()+"::"+stu.getSpassword()+"<br>");
                out.println(stu.getSname()+"::"+stu.getSpassword()+"<br>");
                DaoStu logins  = new DaoStu();
                stu = logins.loginStu(stu);
                if(stu!=null){
                    session.setAttribute("student", stu);
                    response.sendRedirect("/Ten/stu/student.jsp");
                }else{
                    out.println("S用户名或密码不正确，请核对后重试!!");
                    response.setHeader("refresh","2;url=/Ten/Login.jsp");
                }
            }else{
                out.println("错误！请登录！");
                response.setHeader("refresh","2;url=/Ten/Login.jsp");
            }
        }catch(Exception e){ e.printStackTrace();response.sendRedirect("/Ten/Login.jsp");}
        out.flush();
        out.close();
    }

}
