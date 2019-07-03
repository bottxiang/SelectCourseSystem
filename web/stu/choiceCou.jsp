<%@ page import="bean.Student" %>
<%@ page import="bean.Course" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="tool.DaoCou" %>
<%@ page import="tool.DaoSc" %><%--
  Created by IntelliJ IDEA.
  User: wooHsi
  Date: 2019/6/12
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>学生选课信息管理系统-正在选课</title>
    <link href="style_1.css" type="text/css" rel="stylesheet"/>
</head>

<body>
<%
    Student stu = null;
    if (session.getAttribute("student") == null) {
        response.sendRedirect("/Ten/Login.jsp");
    } else {
        stu = (Student) session.getAttribute("student");
    }%>
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

    <div class="main_right">
        <div class="info">
            <p><%= stu.getSname() %>同学，你好！</p>
        </div>
        <div class="box">

            <div class="form">
                <form action="servlet/serInsertSc" method="post">
                    <%
                        Course cou = null;
                        DaoCou selectcou = new DaoCou();
                        Iterator<Course> list = selectcou.selectCou();
                        DaoSc sc = new DaoSc();
                        boolean isDisabled;
                    %>
                    <table>
                        <tr>
                            <td>课程号</td>
                            <td>课程名</td>
                            <td>先行课</td>
                            <td>学分</td>

                        </tr>
                        <%
                            while (list.hasNext()) {
                                cou = list.next();
                                String sno = stu.getSno();
                                String cno = cou.getCno();
                                isDisabled = (sc.selectone(sno,cno)!=null);

                        %>

                        <tr>
                            <td><%= cou.getCno() %>
                            </td>
                            <td><%= cou.getCname() %>
                            </td>
                            <td><%= cou.getCpno() %>
                            </td>
                            <td><%= cou.getCcredit() %>
                            </td>
                            <td><input type="checkbox" id="checkbox"name="choiceCou" value="<%= cou.getCno()%>"/></td>
                        </tr>
                        <%
                            }
                        %>
                        <tr>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td><input class="sure" type="submit" value="确定"></td>
                            <td><input class="cancle" type="reset" value="取消"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>

