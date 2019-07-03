<%@ page import="bean.Teacher" %>
<%@ page import="tool.DaoCou" %>
<%@ page import="bean.Course" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: wooHsi
  Date: 2019/6/12
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>学生选课信息管理系统-课程信息</title>
    <link href="style_1.css" type="text/css" rel="stylesheet"/>
</head>
<body>
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
        Teacher tea = null;
        if(session.getAttribute("teacher")==null){
            response.sendRedirect("/Ten/Login.jsp");
        }else{
            tea = (Teacher)session.getAttribute("teacher");
    %>
    <div class="main_right">
        <div class="info">
            <p><%= tea.getTname() %>老师，你好！</p>
        </div>
        <div class="box">

            <%
                DaoCou select = new DaoCou();
                Iterator<Course> list = select.selectCou(); %>
            <div class="form">
                <table>
                    <tr><td></td></tr>
                    <tr>
                        <td>课程号</td><td>课程名</td><td>先行课</td><td>学分</td><td></td><td></td>
                        <td><input class="btn" type="button" value="添加课程" onclick="window.location.href=('/Ten/tea/insertCou.jsp')"/></td>

                    </tr>
                    <%
                        while(list.hasNext()){
                            Course cou = list.next();
                    %>
                    <tr>
                        <td><%= cou.getCno() %></td>
                        <td><%= cou.getCname() %></td>
                        <td><%= cou.getCpno() %></td>
                        <td><%= cou.getCcredit() %></td>
                        <td><input  class="btn" type="button" value="修改课程" onClick="window.location.href=('/Ten/tea/updateCou.jsp?id=<%= cou.getCno() %>')"></td>
                        <td><input  class="btn" type="button" value="删除课程" onClick="window.location.href=('/Ten/servlet/serDeleteCou?id=<%= cou.getCno() %>')"></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </table>

            </div>
        </div>
    </div>
</div>
</body>
</html>
