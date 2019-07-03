<%@ page import="bean.Student" %>
<%@ page import="tool.DaoSc" %>
<%@ page import="bean.Course" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: wooHsi
  Date: 2019/6/12
  Time: 10:54
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
    <title>学生选课信息管理系统-显示已选课程</title>
    <link href="style_1.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<%
    Student stu = null;
    if(session.getAttribute("student")==null){
        response.sendRedirect("/Ten/Login.jsp");
    }else{
        stu = (Student)session.getAttribute("student");%>
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
                <table>
                    <tr>
                        <td>课程号</td><td>课程名</td><td>先行课</td><td>学分</td><td>取消选课</td>

                    </tr>
                    <%
                        DaoSc select = new DaoSc();
                        Iterator<Course> list = select.selectSc(stu.getSno());
                        Course cou = null;
                        while(list.hasNext()){
                            cou = list.next();
                    %>
                    <tr>
                        <td><%= cou.getCno() %></td>
                        <td><%= cou.getCname() %></td>
                        <td><%= cou.getCpno() %></td>
                        <td><%= cou.getCcredit() %></td>
                        <td><input class="cancle" type="button" value="取消" onClick="window.location.href=('/Ten/servlet/serDeleteSc?cno=<%= cou.getCno() %>')"></td>
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

