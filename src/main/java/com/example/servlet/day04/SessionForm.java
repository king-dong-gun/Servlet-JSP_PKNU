package com.example.servlet.day04;

import com.example.servlet.day01.HelloServlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionForm extends HelloServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 새션 저장소 생성
        HttpSession session = request.getSession();

        // 입력 파라미터 설정
        String numStr = request.getParameter("num");
        String op = request.getParameter("operation");

        // 확인
        System.out.println("num: " + numStr);
        System.out.println("operation: " + op);

        // 형변환
        double num = numStr != null && !numStr.isEmpty() ? Double.parseDouble(numStr) : 0;

        // 이전 값, 연산자 가져오기
        Double sesNum = (Double) session.getAttribute("sesNum");
        String sesOp = (String) session.getAttribute("sesOp");

        if (sesNum == null) {
            // 처음 입력된 경우: 숫자와 연산자가 같음
            sesNum = num;
            sesOp = op;
        } else {
            // 이전 값이 있는 경우 연산 수행
            if (sesOp != null &&!"==".equals(op)) {
                switch (sesOp) {
                    case "+":
                        sesNum += num;
                        break;
                    case "-":
                        sesNum -= num;
                        break;
                    case "*":
                        sesNum *= num;
                        break;
                    case "/":
                        if (num != 0) {
                            sesNum /= num;
                        } else {
                            response.getWriter().write("0으로는 나눌 수 없습니다.");
                            return;
                        }
                        break;
                }
            }
            sesOp = op;
        }

        // 최종 결과 출력
        if ("=".equals(op)) {
            response.getWriter().write("result = " + sesNum);
            session.removeAttribute("sesNum");           // 숫자 삭제
            session.removeAttribute("sesOp");            // 연산자 삭제
        } else {
            // 중간 결과 저장
            session.setAttribute("sesNum", sesNum);   // 숫자 저장
            session.setAttribute("sesOp", sesOp);     // 연산자 저장
            // 페이지 전환 없음
            request.getRequestDispatcher("/day04/sessionForm.html").forward(request, response);
        }
    }
}


