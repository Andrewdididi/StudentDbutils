package com.chb;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import packageUtils.DbUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

    private static Connection conn = DbUtils.getConn();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        request.setAttribute("email",email);
        String sql = "select count(*) from users where email=? and pwd=?";
        QueryRunner runner = new QueryRunner();
        try{
            Long cnt = runner.query(conn, sql, new ScalarHandler<>(),email,pwd);
            System.out.println(cnt.toString());
            if (cnt>0){
                request.getRequestDispatcher("/succ.jsp").forward(request,response);
            }
            else{
                response.sendRedirect(request.getContextPath()+"/index.jsp?c=1");
                //request.setAttribute("msg","用户名或密码错误");
                //request.getRequestDispatcher("/index.jsp").forward(request,response);
                //out.print("<script>alert('用户名或密码错误');</script>");
                System.out.println("用户名或密码错误");
                //request.getRequestDispatcher("/index.jsp");
            }
        }
        catch (Exception e){
            System.out.println("query error");
            request.getRequestDispatcher("/index.jsp");
        }

    }
}
