package com.example.servlet.day02;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/formtest")
public class FormTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String data1 = req.getParameter("data1");
        String data2 = req.getParameter("data2");
        out.append("<!doctype html><html><head><title>Hello Servlet</title></head><body>")
                .append(data1+"<br>")
                .append(data2)
                .append("</body></html>");
        //19, 22행 생략 할 경우
        //out.print(data1);
        //out.print(data2);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
