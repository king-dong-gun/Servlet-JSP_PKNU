package com.example.servlet.day04;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/app")
public class ApplicationTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Application 저장소 생성
        ServletContext application = request.getServletContext();

        String data = request.getParameter("data");

        // 확인
        System.out.println("data1 = " + data);
        // 저장
        application.setAttribute("data", data);
        // 꺼내기
        application.getAttribute("data");

        System.out.println("data2 = " + data);

    }
}
