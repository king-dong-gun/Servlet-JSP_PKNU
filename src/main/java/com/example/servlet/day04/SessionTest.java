package com.example.servlet.day04;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/sessionTest")
public class SessionTest extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 새션 저장소 생성
        HttpSession session = request.getSession();
        String data = request.getParameter("data");

        // 확인
        System.out.println("data: " + data);

        // 저장
        session.setAttribute("data", data);

        // 꺼내기
        session.getAttribute("data");

        System.out.println("data2: " + data);

    }
}
