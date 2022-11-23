package com.atguigu.json;

import com.atguigu.pojo.User;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/json.do")
public class JsonServlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*System.out.println( request.getParameter("uname"));
        System.out.println(request.getParameter("pwd"));

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.write(" 这是从服务器返回的一段数据");

        throw new RuntimeException("服务器报错");*/

        // 1.由于请求体数据有可能很大，所以Servlet标准在设计API的时候要求我们通过输入流来读取
        BufferedReader reader = request.getReader();

        // 2.创建StringBuilder对象来累加存储从请求体中读取到的每一行
        StringBuilder builder = new StringBuilder();

        // 3.声明临时变量
        String bufferStr = null;

        // 4.循环读取
        while ((bufferStr = reader.readLine()) != null) {
            builder.append(bufferStr);
        }

        String str= builder.toString();

        System.out.println(str);

        Gson gson=new Gson();

        User user=gson.fromJson(str,User.class);

        user.setUname("cxk");
        user.setPwd("123456");

        System.out.println(user);

//        假设user是从数据库取出的,现在要将对象转化到json字符串
        String userJsonStr = gson.toJson(user);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        response.getWriter().write(userJsonStr);


    }
}
