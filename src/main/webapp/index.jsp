<%--
  Created by IntelliJ IDEA.
  User: oujh
  Date: 2018/7/24
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<%--搭建框架测试--%>
hello
<hr>
<form action="/saveInfo.action" method="post">
    name<input type="text" name="name">
    bir<input type="text" name="bir">
    <input type="submit" value="提交">
</form>
<hr>
<%--Echarts--%>
<a href="bar2.html">点击bar2</a>
<hr>
<a href="bar.jsp">点击bar</a>
<hr>
<a href="pie.jsp">点击pie</a>
<hr>
<a href="line.jsp">点击line</a>
<hr>
<a href="line2.jsp">点击line2</a>
<hr>
<a href="/getUserList.action">查看用户信息</a>
<hr>
<a href="${pageContext.request.contextPath}/jsp/userlist.jsp">跳转</a>
<hr>

</body>
</html>
