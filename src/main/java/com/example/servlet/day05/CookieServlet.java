package com.example.servlet.day05;

import com.example.servlet.day01.HelloServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/cookie")
public class CookieServlet extends HelloServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 쿠키 생성
        Cookie cookie1 = new Cookie("ive", "LoveDive");
        Cookie cookie2 = new Cookie("newjeans", URLEncoder.encode("내가만든 쿠키", "UTF-8"));

        // 응답에 쿠키 추가 -> 응답헤더에 실어서
        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }
}
