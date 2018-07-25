<%--
  Created by IntelliJ IDEA.
  User: oujh
  Date: 2018/7/24
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--要记得传入c标签--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html>
<head>
    <%--这个一定要在head里面--%>
    <base href="<%=basePath%>">

        <%--excel导出--%>
    <script src="js/jquery-1.8.1.js"></script>
    <script TYPE="text/javascript">
        function exp() {
            $.ajax({
                type:'get',
                url:'exp.action',
                success:function (data) {

                    if(data=='ok'){
                        alert('导出成功')
                    }
                },
                error:function () {
                    alert('导出失败')
                }
            })
        }

    </script>

</head>

    <title>Title</title>
<body>

<%--将在controller中获取的userlist域中的数据变量，并分别输出id 和 name--%>
<table border="1" width="100%">
    <tr>
        <th>id</th><th>name</th>
    </tr>
    <c:forEach var="user" items="${userlist}">
        <tr>
            <td>
                    ${user.id}
            </td>
            <td>
                    ${user.name}
            </td>
        </tr>
    </c:forEach>
</table>

<%--导入文本框--%>
<form action="/excelImport.action" method="post" enctype="multipart/form-data">
    <input type="file" name="excel">
    <input type="submit" value="导入">
</form>


<%--导出文本框--%>
<input type="button" value="导出" onclick="exp()">



</body>
</html>
