<%@ page import="bean.Teacher" %>
<%@ page import="bean.QueryResult" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: wooHsi
  Date: 2019/6/12
  Time: 17:06
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

    <meta charset="UTF-8">
    <title>学生选课信息管理系统-信息查询</title>
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

        <div class="main_left_class01"><a href="tea/selectCou.jsp">选课管理</a></div>
        <div class="main_left_class02"><a href="tea/selectStu.jsp">学生信息</a></div>
        <div class="main_left_class03"><a href="tea/query.jsp">信息查询</a></div>
        <div class="main_left_class100">
            <input class="reset" type="button" value="注销" onClick="window.location.href=('/Ten/servlet/serDoLogout')">
        </div>
    </div>
    <%
        request.setCharacterEncoding("utf-8");
        Teacher tea = null;
        if (session.getAttribute("teacher") == null) {
            response.sendRedirect("/Ten/Login.jsp");
        } else {
            tea = (Teacher) session.getAttribute("teacher");%>
    <div class="main_right">
        <div class="info">
            <p><%= tea.getTname() %>老师，你好！</p>
        </div>
        <div class="box">

            <div class="form">
                <div class="form_1">
                    <form action="servlet/serQuerySc" method="post">
                        <table class="form_1_table">
                            <tr>
                                <td><input class="text" type="text" name="queryKey" placeholder="请输入查询项"/></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td>
                                    <select name="type">
                                        <option value="1">学号</option>
                                        <option value="2">姓名</option>
                                        <option value="3">课程号</option>
                                        <option value="4">课程名</option>
                                    </select>
                                </td>
                                <td><input class="btn" type="submit" value="查询"/></td>
                            </tr>

                            <%
                                if (request.getAttribute("queryResult") == null) {
                            %>
                        </table>
                    </form>
                    <%

                    } else {

                        int type = Integer.parseInt(request.getParameter("type"));
                        String queryKey = request.getParameter("querykey");
                        System.out.println("query: type:" + type +"queryKey:" + queryKey);
                        List<QueryResult> list = (List<QueryResult>) request.getAttribute("queryResult");
                        Iterator<QueryResult> ite = list.iterator();
                        if (ite.hasNext() && type != 5) {//查询结果不为空，输出表格
                            QueryResult tem = null;%>
                    <table>
                        <tr>
                            <td>学号</td>
                            <td>姓名</td>
                            <td>课程号</td>
                            <td>课程名</td>
                            <td>成绩</td>
                        </tr>

                        <%
                            while (ite.hasNext()) {
                                tem = ite.next();
                        %>

                        <tr>
                            <td><%=tem.getSno() %>
                            </td>
                            <td><%=tem.getSname() %>
                            </td>
                            <td><%=tem.getCno() %>
                            </td>
                            <td><%=tem.getCname() %>
                            </td>
                            <td><%=tem.getGrade() %>
                            </td>
                            <td><input class="btn" type="button" value="更新成绩"
                                       onclick="window.location.href=('/Ten/tea/updateSc.jsp?Sno=<%=tem.getSno() %>&Cno=<%=tem.getCno() %>&type=<%= type %>&queryKey=<%=queryKey%> ')"/>
                            </td>
                        </tr>

                        <% }%>
                    </table>

                    <%

                    } else if (type != 5) {
                    %>
                    <table><p>结果为空，选课关系不存在 或输入项错误</p></table>
                    <%
                            }
                        }

                    %>
                </div>
            </div>
            <%} %>
        </div>
    </div>
</div>
</body>
</html>

