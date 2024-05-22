package com.example.servlet.day04;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/single")
public class SingletonForm extends HttpServlet {
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
            request.getRequestDispatcher("/day04/singletonForm.html");
            // 페이지 전환 없음
            // request.getRequestDispatcher("/day04/singletonForm.html").forward(request, response);
        }
    }
}
