<%--
  Created by IntelliJ IDEA.
  User: wooHsi
  Date: 2019/6/11
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生选课信息管理系统</title>
    <link href="style.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="login_bg">
    <div class="login_box">
        <div class="login_content">
            <h2>学生选课信息管理系统</h2>
            <p></p>
            <form action="servlet/serDoLogin?type=stu" method="post">
                <div class="login_input">
                    <input type="text" placeholder="请输入学号" class="login_username" name="username">
                </div>

                <div class="login_input">
                    <input type="password" placeholder="请输入密码" class="login_password" name="password">
                </div>

                <div class="">
                    <input class="login_btn sure" type="submit" value="登录">
                    <input class="login_btn cancle" type="button" value="教师入口 "
                           onclick="window.location.href='tea/teaLogin.jsp'">
                </div>
            </form>
        </div>
    </div>

</div>
</body>
</html>

