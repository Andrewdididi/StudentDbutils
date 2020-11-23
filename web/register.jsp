<%--
  Created by IntelliJ IDEA.
  User: chang
  Date: 2020/11/1
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" language="java" %>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Register</title>

    <style>
      div{
        width: 250px;
        height: 500px;
        margin:0 auto;
      }
    </style>
  </head>
  <body>
  <meta charset="UTF-8">
    <div>

      <form action="register" method="post">
        <div>
          <h1>用户注册</h1><hr>
          邮箱：<input type="text" name="email"><br>
          密码：<input type="text" name="pwd"><br>
          性别：<input type="radio" name="sex" value="男">男
                <input type="radio" name="sex" value="女">女<br>
          学校：<input type="text" name="uni"><br>
          学院：<input type="text" name="college"><br>
          班级：<input type="text" name="class"><br><br>
          &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="submit" value="提交">
          &nbsp&nbsp&nbsp&nbsp<input type="reset" value="重置">
        </div>

      </form>



    </div>

  </body>
</html>
