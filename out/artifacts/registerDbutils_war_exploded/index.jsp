<%--
  Created by IntelliJ IDEA.
  User: chang
  Date: 2020/11/3
  Time: 11:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>登陆</title>
</head>
<body>

<script>

    var msg=<%=request.getParameter("c")%>;
    if (msg=="1")
        alert("username or password error");

</script>
<center>
    <form action="login" method="post">
        <div>
            <h1>用户登陆</h1><hr>
            邮箱：<input type="text" name="email"><br>
            密码：<input type="password" name="pwd"><br><br>
            &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" value="提交">
            &nbsp&nbsp&nbsp&nbsp<input type="button" value="注册" onclick="window.location.href='http://localhost:8080/registerDbutils_war_exploded/register.jsp'">
        </div>
    </form>

</center>
</body>
</html>
