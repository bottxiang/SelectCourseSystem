<%@ page import="bean.Teacher" %>
<%@ page import="tool.DaoCou" %>
<%@ page import="bean.Course" %><%--
  Created by IntelliJ IDEA.
  User: wooHsi
  Date: 2019/6/12
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>学生选课信息管理系统-修改课程信息</title>
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
    if (session.getAttribute("teacher") == null) {
        response.sendRedirect("/Ten/Login.jsp");
    } else {
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
                    <form action="servlet/serDoUpdateCou" method="post">
                        <%
                            DaoCou selectone = new DaoCou();
                            Course cou = selectone.selectCou(request.getParameter("id"));
                            if (cou != null) {
                        %>

                        <table>
                            <tr>
                                <td></td>
                            </tr>
                            <tr>
                                <td>课程号</td>
                                <td><input class="text" type="text" name="Cno" value="<%= cou.getCno() %>"
                                           readonly="true"/></td>
                            </tr>
                            <tr>
                                <td>课程名</td>
                                <td><input class="text" type="text" name="Cname" value="<%= cou.getCname() %>"/></td>
                            </tr>
                            <tr>
                                <td>先行课</td>
                                <td><input class="text" type="text" name="Cpo" value="<%= cou.getCpno() %>"/></td>
                            </tr>
                            <tr>
                                <td>学分</td>
                                <td><input class="text" type="text" name="Ccredit" value="<%= cou.getCcredit() %>"/>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input class="btn" type="submit" value="确认修改"/> <input class="btn" type="reset"
                                                                                           value="取消修改"/></td>
                            </tr>

                            <%
                                } else {
                                    response.sendRedirect("/Ten/tea/selectCou.jsp");
                                }
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
