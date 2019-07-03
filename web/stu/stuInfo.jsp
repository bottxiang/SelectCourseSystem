<%@ page import="bean.Student" %>
<%@ page import="tool.DaoStu" %><%--
  Created by IntelliJ IDEA.
  User: wooHsi
  Date: 2019/6/12
  Time: 23:38
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
    <title>学生选课信息管理系统-显示学生个人信息</title>
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
<div class="top">
    <div class="title"><p> 学生选课信息管理系统 </p></div>
</div>
<div class="main">
    <div class="main_left">

        <div class="main_left_class01"><a href="stu/choiceCou.jsp">学生选课</a></div>
        <div class="main_left_class02"><a href="stu/showCou.jsp">课程查询</a></div>
        <div class="main_left_class03"><a href="stu/stuInfo.jsp">学籍信息</a></div>
        <div class="main_left_class100">
            <input class="reset" type="button" value="注销" onClick="window.location.href=('/Ten/servlet/serDoLogout')">
        </div>
    </div>
    <%
        Student stu = null;
        if(session.getAttribute("student")==null){
            response.sendRedirect("/Ten/Login.jsp");
        }else{
            stu = (Student)session.getAttribute("student");%>
    <div class="main_right">
        <div class="info">
            <p><%= stu.getSname() %>同学，你好！</p>
        </div>
        <div class="box">

            <div class="form">
                <div class="form_1">
                    <table class="info">
                        <%
                            DaoStu select1 = new DaoStu();
                        %>
                        <tr><td></td><td><input class="text" type="text" value="<%= stu.getSname() %>" readonly="true"></tr>
                        <tr><td></td><td><input class="text" type="text" value="学号：<%= stu.getSno() %>" readonly="true"></input></td></tr>
                        <tr><td></td><td><input class="text" type="text" value="密码：<%= stu.getSpassword() %>" readonly="true"></td></tr>
                        <tr><td></td><td><input class="text" type="text" value="性别：<%= stu.getSsex() %>" readonly="true"></td></tr>
                        <tr><td></td><td><input class="text" type="text" value="年龄：<%= stu.getSage() %>" readonly="true"></td></tr>
                        <tr><td></td><td><input class="text" type="text" value="专业：<%= stu.getSdept() %>" readonly="true"></td></tr>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
