## 서블릿 4일차

### 서블릿 사용하기

### ServletContext 
- `ServletContext` 클래스는 톰캣 컨테이너가 실행되면 각 `context`마다 1개의 `ServletContext`를 생성한다.
- 톰캣 컨테이너가 종료되면 그 객체는 소멸된다.

```java
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
```

1. 클라이언트가 서버에 요청을 할때 `getServletContext`메서드를 호출하면 `ServletContext` 객체를 반환한다.
2. `setAttribute`메서드로 매개변수 속성 이름 `data` 지정 후 속성 값 `data`를 주어 데이터를 넘겨준다.
3.`getAttribute`메서드로 매개변수 속성 이름 `data`의 값을 받는다.


![getAttribute](https://github.com/king-dong-gun/Spring_PKUN/assets/160683545/5b0f483e-f49c-49fe-8f48-d1110724de00)


### 계산기 프로그램 만들기
- 하나의 `input`창으로 숫자와 연산자를 받아 이전 데이터를 유지하면서 연산하는 계산기 만들기
  - 연산자를 눌러 새 화면이 출력되어도 뒤로가기를 누르면서 데이터를 유지


1. 숫자를 받는 `input`창 1개 생성
2. 연산자를 받는 `+`, `-`, `*`, `/`, `=` 생성

#### html
```html
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>SingletonForm</title>
</head>
<body>
<form method="post" action="/single">
    <div>
        <label for="num">Number :</label>
        <input type="text" id="num" name="num">
    </div>
    <div>
        <input type="submit" name="operation" value="+">
        <input type="submit" name="operation" value="-">
        <input type="submit" name="operation" value="*">
        <input type="submit" name="operation" value="/">
        <input type="submit" name="operation" value="=">
    </div>
</form>
</body>
</html>

```
#### java
```java
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
            // 처음 입력된 경우
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
```
1. `ServletContext` 저장소를 생성한다.
2. 파라미터를 받을 `num`, `operation` 변수를 생성한다.
3. `double`로 문자열로 받은 `numStr`변수를 숫자로 형변환한다.(`null`이 아닌)
4. 이전에 입력받은 숫자 `appNum`, 연산자 `appOp` 변수를 생성한다.
5. 연산(`+`, `-`, `*`, `/`) 로직 실행 함수 생성한다.
6. `=` 입력 받는다면 `response.getWriter()` 함수로 결과값을 출력한다.
   - `application.removeAttribute()`로 입력받았던 숫자, 연산을 삭제한다.
7. `=` 이 아닌 연산자를 계속 받는다면 `application.setAttribute`로 중간 계산 결과 저장
8. `request.getRequsetDispatcher()` 함수로 뒤로가기를 설정한다.
    - `request.getRequestDispatcher().foward(requset, response)`는 페이지 전환 없음 함수

![singleton1](https://github.com/king-dong-gun/Spring_PKUN/assets/160683545/d1a1b7af-fc60-4751-99cd-4e8ec31b0f1e)



![singleton2](https://github.com/king-dong-gun/Spring_PKUN/assets/160683545/6901bd58-9c91-44d8-bca4-3fd232233741)



#### session
- 자바 서블릿은 `HttpSession`이라는 인터페이스를 가지고 있다.
  - 검색, 저장, 삭제의 기능을 가지고 있다
- `getSession`을 통해 새션 객체에 접근하며, `HttpSessionRequest 객체를 이용한다.

