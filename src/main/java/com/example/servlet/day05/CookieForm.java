package com.example.servlet.day05;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/cook")
public class CookieForm extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ServletContext 저장소 생성
        ServletContext application = request.getServletContext();


        // 입력 파라미터 설정
        String numStr = request.getParameter("num");
        String op = request.getParameter("operation");

        // 확인
        System.out.println("num = " + numStr);
        System.out.println("operation = " + op);

        // 숫자로 형변환
        double num = numStr != null && !numStr.isEmpty() ? Double.parseDouble(numStr) : 0;

        // 이전 값과 연산자 가져오기
        Double appNum = (Double) application.getAttribute("appNum");
        String appOp = (String) application.getAttribute("appOp");

        if (appNum == null) {
            // 처음 입력된 경우: 숫자와 연산자가 같음
            appNum = num;
            appOp = op;
        } else {
            // 이전 값이 있는 경우 연산 수행
            if (appOp != null) {
                switch (appOp) {
                    case "+":
                        appNum += num;
                        break;
                    case "-":
                        appNum -= num;
                        break;
                    case "*":
                        appNum *= num;
                        break;
                    case "/":
                        if (num != 0) {
                            appNum /= num;
                        } else {
                            response.getWriter().write("0으로는 나눌 수 없습니다.");
                            return;
                        }
                        break;
                }
            }
            appOp = op;
        }

        // 최종 결과 출력
        if ("=".equals(op)) {
            response.getWriter().write("result = " + appNum);
            application.removeAttribute("appNum");           // 숫자 삭제
            application.removeAttribute("appOp");            // 연산자 삭제
        } else {
            // 중간 결과 저장
            application.setAttribute("appNum", appNum);   // 숫자 저장
            application.setAttribute("appOp", appOp);     // 연산자 저장
            // 뒤로가기
//            request.getRequestDispatcher("/day04/singletonForm.html");
//             페이지 전환 없음
            request.getRequestDispatcher("/day05/cookieForm.html").forward(request, response);
        }

        // 쿠키 생성
//        String encodedNum = URLEncoder.encode(Double.toString(num), StandardCharsets.UTF_8.toString());
//        String encodedAppNum = URLEncoder.encode(Double.toString(appNum), StandardCharsets.UTF_8.toString());
//        Cookie cookie1 = new Cookie("num", encodedNum);
//        Cookie cookie2 = new Cookie("appNum", encodedAppNum);
//        Cookie cookie3 = new Cookie("appOp", appOp);
        Cookie opCookie = new Cookie("op", op);
        Cookie valueCookie = new Cookie("result", appNum.toString());


        // 쿠키 설정
//        cookie1.setMaxAge(60 * 60);  // 쿠키 유효시간을 1시간으로 설정
//        cookie1.setPath("/");    // 쿠키의 유효 경로 설정
//        cookie2.setMaxAge(60 * 60);
//        cookie2.setPath("/");
//        cookie3.setMaxAge(60 * 60);
//        cookie3.setPath("/");

        // 쿠키 전송
//        response.addCookie(cookie1);
//        response.addCookie(cookie2);
//        response.addCookie(cookie3);

        response.addCookie(opCookie);
        response.addCookie(valueCookie);


        // 쿠키 추출
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("op") || c.getName().equals("appNum")) {
                    String decodedValue = URLDecoder.decode(c.getValue(), StandardCharsets.UTF_8.toString());
                    System.out.println(c.getName() + " = " + decodedValue);
                }
            }
        }
    }
}

//package com.example.servlet.day05;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//import java.net.URLDecoder;
//import java.net.URLEncoder;
//import java.nio.charset.StandardCharsets;
//
//@WebServlet("/cook")
//public class CookieForm extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    @Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // 입력 파라미터 설정
//      String num = request.getParameter("num");
//      String op = request.getParameter("operation");
//    }
//}