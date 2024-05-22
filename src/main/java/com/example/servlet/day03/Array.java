package com.example.servlet.day03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/array")
public class Array extends HttpServlet {

    // doPost 메서드를 오버라이드하여 HTTP POST 요청을 처리합니다.
    @Override   // doPost 메서드를 오버라이드 함을 나타냅니다.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // HTTP 응답의 문자 인코딩과 콘텐츠 타입을 설정합니다.
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        // HTTP 응답으로부터 PrintWriter를 가져와 출력을 위해 사용합니다.
        PrintWriter out = response.getWriter();

        // HTML 폼에서 입력된 모든 숫자를 받아옵니다.
        String[] num_ = request.getParameterValues("n");
        // 합계를 저장할 변수를 초기화합니다.
        int result = 0;

        // 입력된 모든 숫자를 합계를 계산합니다.
        for (int i = 0; i < num_.length; i++) {
            // 문자열 형태인 숫자를 정수형으로 변환하여 합계를 계산합니다.
            int num = Integer.parseInt(num_[i]);
            result += num;
        }

        // 합계를 출력합니다.
        out.println("합 = " + result);
    }
}
