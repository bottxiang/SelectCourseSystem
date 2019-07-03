<%@ page import="bean.Teacher" %>
<%@ page import="bean.Student" %>
<%@ page import="tool.DaoStu" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: wooHsi
  Date: 2019/6/12
  Time: 16:10
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
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>学生选课信息管理系统-学生信息</title>
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
    @SuppressWarnings("unused")
    Teacher tea = null;
    if(session.getAttribute("teacher")==null){
        response.sendRedirect("../Login.jsp");
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
        <div class="main_left_class03"><a href="tea/query.jsp">信息查询</a></div>
        <div class="main_left_class100">
            <input class="reset" type="button" value="注销" onClick="window.location.href=('/Ten/servlet/serDoLogout')">
        </div>
    </div>
    <%
        DaoStu select = new DaoStu();
        List<Student> list = select.selectStu();
        Iterator<Student> ite1 = list.iterator();
    %>
    <div class="main_right">
        <div class="info">
            <p><%= tea.getTname() %>老师，你好！</p>
        </div>
        <div class="box">

            <div class="form">
                <table>

                    <tr>
                        <td>学号</td><td>登录密码</td><td>姓名</td><td>性别</td><td>年龄</td><td>专业</td><td></td><td></td>
                        <td><input class="btn" type="button" value="添加学生" onclick="window.location.href=('/Ten/tea/insertStu.jsp')"/></td>

                    </tr>
                    <%
                        while(ite1.hasNext()){
                            Student stu = ite1.next();
                    %>
                    <tr>
                        <td><%= stu.getSno() %></td>
                        <td><%= stu.getSpassword() %></td>
                        <td><%= stu.getSname() %></td>
                        <td><%= stu.getSsex() %></td>
                        <td><%= stu.getSage() %></td>
                        <td><%= stu.getSdept() %></td>
                        <td><input class="btn" type="button" value="修改信息" onClick="window.location.href=('/Ten/tea/updateStu.jsp?id=<%= stu.getSno() %>')"></td>
                        <td><input class="btn" type="button" value="删除信息" onClick="window.location.href=('/Ten/servlet/serDeleteStu?id=<%= stu.getSno() %>')"></td>
                    </tr>
                    <%} %>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>