package com.example.servlet.day03;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class FilterTest implements Filter {

    @Override
    public void destroy() {
        // 필터 해제 코드
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("doFilter 코드 실행 시작");

        // ip 주소 가져오기
        String ip = request.getRemoteAddr();
        System.out.println("Remote IP Address: " + ip);
        System.out.flush();  // 플러시 추가

        // 필터체인 실행
        chain.doFilter(request, response);

        // doFilter 호출 이후에 후 처리 코드
        System.out.println("doFilter 코드 실행 완료");
        System.out.flush();  // 플러시 추가
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        // 필터 초기화 코드
    }
}


//1. 클라이언트 요청
//2. 웹서버 서블릿 컨테이너에게 해당 요청을 넘김
//3. `httpServletRequest`, `httpServletResponse` 객체 생성
//4. `httpServletRequeset`에게 받은 요청을 담는다.
//5. 서블릿 컨텍스트의 메서드를 호출해서 `web.xml` 같은 설정파일을 통해 해당 요청을 처리할 서블릿을 매핑시킨다.
//6. 매핑된 서블릿에 `httpServletRequest`, `httpServletResponse`를 전달한다.
//7. `service()` 메서드를 호출한다 -> `Get`, `Post` 여부에 따라 `doGet`, `doPost` 실행결과를 `httpServletResponse`에 담는다.
//8. `httpServletResponse` 웹서버에게 전달하면 웹서버가 클라이언트에 전달한다.
//9. 응답이 끝난 후에는 생성되었던 객체들을 소멸시킨다.