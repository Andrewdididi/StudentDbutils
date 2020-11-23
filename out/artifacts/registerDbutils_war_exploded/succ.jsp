<%--
  Created by IntelliJ IDEA.
  User: chang
  Date: 2020/11/3
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的系统</title>
</head>
<body>
    <h1>恭喜您，<%=request.getAttribute("email")%>，登录成功</h1>
    <%request.getSession().setAttribute("email",request.getAttribute("email"));%>

    <form action="deactivate">
        <input type="submit" value="注销">
    </form>
</body>
</html>
