package com.chb;

import org.apache.commons.dbutils.QueryRunner;
import packageUtils.DbUtils;
import dbtest.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/register")

public class regServlet extends HttpServlet {

    //private static Test t=new Test();
    private static Connection conn = DbUtils.getConn();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");
        String uni = request.getParameter("uni");
        String college = request.getParameter("college");
        String aClass = request.getParameter("class");

        String sql = "insert into users values(?,?,?,?,?,?)";
        System.out.println(sex);
        QueryRunner runner = new QueryRunner();
        try{
            runner.update(conn, sql, email,pwd,sex,uni,college,aClass);
        }
        catch (Exception e){
            System.out.println("insert error");
        }
        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }
}
