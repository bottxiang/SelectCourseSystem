<%@ page import="tool.DaoSc" %>
<%@ page import="bean.SC" %>
<%@ page import="bean.Teacher" %>
<%@ page import="tool.Conn" %>
<%@ page import="tool.DaoCou" %><%--
  Created by IntelliJ IDEA.
  User: wooHsi
  Date: 2019/6/13
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>学生选课信息管理系统-修改学生信息</title>
    <link href="style_1.css" type="text/css" rel="stylesheet"/>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<%
    Teacher tea = null;
    if(session.getAttribute("teacher")==null){
        response.sendRedirect("/Ten/Login.jsp");
    }else{
        tea = (Teacher) session.getAttribute("teacher");
    }
%>
<div class="top">
    <div class="title"><p> 学生选课信息管理系统</p></div>
</div>
<div class="main">
    <div class="main_left">

        <div class="main_left_class01"><a href="tea/selectCou.jsp">选课管理</a></div>
        <div class="main_left_class02"><a href="tea/selectStu.jsp">学生信息</a></div>
        <div class="main_left_class03"><a href="query.jsp">信息查询</a></div>
        <div class="main_left_class100">
            <input class="reset" type="button" value="注销" onClick="window.location.href=('/Ten/servlet/serDoLogout')">
        </div>
    </div>
    <div class="main_right">
        <div class="info">
            <p><%= tea.getTname() %>老师，你好！</p>
        </div>
        <div class="box">

            <div class="form">
                <div class="form_1">
                    <form action="servlet/serDoUpdateGrade" method="post">
                        <%
                            DaoSc selectone = new DaoSc();
                            SC sc = selectone.selectone(request.getParameter("Sno"),request.getParameter("Cno"));
                            if(sc!=null){
                                DaoCou cou = new DaoCou();
                                String cname = cou.selectCou(request.getParameter("Cno")).getCname();
                        %>
                        <table>

                            <tr><td></td></tr>
                            <tr><td>学号</td> <td><input  class="text" type="text" name="Sno" value="<%= sc.getSno() %>" readonly="true"/></td></tr>
                            <tr><td>课程号</td> <td><input  class="text" type="text" name="Cno" value="<%= sc.getCno() %>" readonly="true"/></td></tr>
                            <tr><td>成绩</td> <td><input  class="text" type="text" name="Grade" value="<%= sc.getGrade() %>"/></td></tr>
                            <tr><td></td><td><input class="btn" type="submit" value="提交成绩"/> <input class="btn" type="reset" value="取消"/>  </td></tr>

                            <%
                                }else {request.getRequestDispatcher("selectStu.jsp").forward(request, response);}
                            %>

                        </table>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>
</body>
</html>
