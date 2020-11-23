package com.chb;

import org.apache.commons.dbutils.QueryRunner;
import packageUtils.DbUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;


@WebServlet("/deactivate")
public class deaServlet extends HttpServlet {
    private static Connection conn = DbUtils.getConn();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String email = (String)request.getSession().getAttribute("email");
        System.out.println(email);
        String sql = "delete from users where email=?";
        QueryRunner runner = new QueryRunner();
        try{
            //request.getRequestDispatcher("/index.jsp");
            runner.update(conn,sql,email);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
        catch (Exception e){
            System.out.println("delete error");
            request.getRequestDispatcher("/succ.jsp").forward(request,response);
        }
    }
}
