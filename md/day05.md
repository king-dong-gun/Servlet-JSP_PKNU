## 서블릿 5일차

### 서블릿 사용하기

### cookie
> 서버가 클라이언트에 저장하는 정보로서 클라이언트 쪽에 필요한 정보를 저장해놓고 필요할 때 추출하는 것
- 쿠키는 클라이언트에 대한 정보를 클라이언트의 하드디스크에 저장한 TEXT 파일이다.
  - TEXT 형태로 저장되기 때문에 보안성이 없다.
- 쿠키 정보는 `javax.servlet.http.Cookie` 클래스에서 관리된다.
- 일반적으로 브라우저는 각 웹서버 당 20개의 쿠키와 총 300개의 쿠키를 지원하며 쿠키의 크기는 각 4kg로 제한될 수 있다.

1. 쿠키 설정
    - 지정한 이름과 값을 가진 쿠키 객체를 생성한다.
    - 이름과 값은 영숫자와 공백을 포함할 수 있다.
```java
Cookie cookie1 = new Cookie("ive", "LoveDive");
```

```java
Cookie cookie2 = new Cookie("newjeans", URLEncoder.encode("내가만든 쿠키", "UTF-8"));
```


2. 응답 헤더에 쿠키 추가
    - `HttpServletResponse` 인터페이스의 `addCookie` 메서드에 의해 HTTP 응답 헤더에 쿠키를 보낸다.
```java
response.addCookie(cookie1);
response.addCookie(cookie2);
```


![cookie](https://github.com/king-dong-gun/Servlet_PKUN/assets/160683545/476a08d2-d325-40d8-a09e-1198331a8369)


### JSP 학습 1일차

### JSP (Java Server Pages)
- HTML 문서안에 Java 언어를 삽입해 웹 서버에서 동적으로 페이지를 생성한다.
- JSP의 위치는 `webapp` 폴더
- 모든 JSP는 서블릿으로 바뀌어서 동작한다.


### JSP 실행 구조


![다운로드](https://github.com/king-dong-gun/Servlet-JSP_PKUN/assets/160683545/196d306b-714c-473c-a3f2-2fc6321d6866)




#### JSP 기초 문법
1. 지시어: `<%@  %>`
2. 스크립트 요소(선언부): `<%!  %>`
3. 스크립트 요소(표현식): `<%  %>`
4. 표현식(출력): `<%=  %>`
5. 주석: `<%--  --%>`


```html
<%--
  Created by IntelliJ IDEA.
  User: kdg
  Date: 2024. 5. 23.
  Time: PM 12:27
  To change this template use File | Settings | File Templates.
--%>

<!--지시어-->
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!--스크립트 요소(선언부)-->
<%!
String str1 = "JSP";
String str2 = "안녕하세요!!";
%>
<html>
<head>
    <title>HelloJsp</title>
</head>
<body>
<h2>
    처음 만들어보는 <%=str1%> <!--스크립트 요소(표현식)-->
</h2>
<p>
    <!--웹에 띄우기-->
    <%= str2 + str1 + "학습 1일차입니다. 화이팅~!" %>
    <!--콘솔에 띄우기-->
    <%System.out.println(str2 + str1 + "학습 1일차입니다. 화이팅~!");%>
</p>

</body>
</html>
```


![jspFirst](https://github.com/king-dong-gun/Servlet-JSP_PKUN/assets/160683545/c3adc28c-ef67-4f9d-9832-298dccf57beb)

#### 메서드 선언 후 호출
```html
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--선언부 (메서드 선언)--%>
<%!
    public int add(int num1, int num2) {
        return num1 + num2;
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    int result = add(10, 20);
%>

<%="result1 = " + result%>
<%="result2 = " + add(10, 20)%>

</body>
</html>
```

![스크린샷 2024-05-23 오후 2 32 46](https://github.com/king-dong-gun/Servlet-JSP_PKUN/assets/160683545/f226b207-0c5a-4749-b55a-2f9f291dbaaf)


> `result`를 따로 선언해서 호출해도 되고 표현식에 메서드를 바로 호출해도 결과는 같다.


### JSP로 계산기 만들기

```html
<%--
  Created by IntelliJ IDEA.
  User: kdg
  Date: 2024. 5. 23.
  Time: PM 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<%
    // 변수 선언
    int result = 0;

    // Get Post는 대문자로만 작성
    // form 태그 method가 post 이므로 post 요청이 들어왔을 경우
    if (request.getMethod().equals("POST")) {
        String operator = request.getParameter("operator");

        // 파라미터 값은 문자열이기 때문에 형변환
        int number1 = Integer.parseInt(request.getParameter("number1"));
        int number2 = Integer.parseInt(request.getParameter("number2"));

        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;

        }
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
</head>
<body>
<h2>Calculator JSP</h2>
<hr>
<form method="post" name="JspCalc">
    <input type="text" name="number1" size="10">
    <select name="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="text" name="number2" size="10">
    <input type="submit" value="계산">
    <br>
</form>
<hr>
<%="계산결과 = " + result%>
</body>
</html>


```

1. `<% %>`로 표현식을 작성한다,
   - `post`형식으로 받고, `operator`의 파라미터를 가져온다.
   - 파라미터의 값은 문자열이기 때문에 `number1`, `number2`의 값을 형변환 한다.
   - `switch`문으로 연산 형식 로직을 만든다.
2. HTML 작성
3. 결과값을 `<%= %>` 출력문으로 `result`를 불러온다.

#### 계산 전

![스크린샷 2024-05-23 오후 3 02 32](https://github.com/king-dong-gun/Servlet-JSP_PKUN/assets/160683545/d1bd5f29-ddcf-4489-be2f-82c6d487a3d0)

#### 계산 후

![스크린샷 2024-05-23 오후 3 02 48](https://github.com/king-dong-gun/Servlet-JSP_PKUN/assets/160683545/793a39b7-8d63-4891-a1fa-36126fa659c0)


### 액션 태그(Action Tag)

#### 기본 구조
- 자바 코드 형태로 작성할 수 있는 것을 **태그 형태**로 정의한 것이다.
- 코드 양을 줄일 수 있고, 가독성이 높다.
- JSP와 JSP 사이를 제어하거나 다른 페이지의 실행 결과를 현재 페이지에 포함시킬 수 있다.
- `jsp:사용할 태그`로 사용한다.

#### 액션태그 종류
1. `<jsp:forward>`: 현재 JSP 페이지에서 URL로 지정한 특정 페이지로 넘어갈 때 사용한다.
```html
<jsp:forward page = "이동할 외부 파일명">
```
2. `<jsp:include>`: 정적 혹은 동적인 자원을 현재 페이지의 내용에 포함시킨다.
```html
<jsp:include page = "외부 파일명 flush = false" />
```
3. `<jsp:useBean>`: 자바빈즈를 생성하고 사용하기 위한 환경을 정의 한다.
```html
<jsp:useBean id="식별자" class = "자바빈즈 이름" scope = "범위" />
```
4. `<jsp:setProperty>`: 자바빈즈 property를 설정한다.
```html
<!--
name: 사용할 빈의 이름을 지정(필수속성)
property: 값을 저장할 프로퍼티명을 지정(필수속성)
value: 프로퍼티에 저장할 값을 지정(생략가능)
-->
<jsp:property name="식별자" property="프로퍼티 이름" value="값" />
```
5. `<jsp:getProperty>`: 자바빈즈의 property를 가져온다.
```html
<!--
name: 사용할 빈의 이름을 지정
property: 값을 가져올 빈의 변수를 지정
-->
<jsp:getProperty name="식별자" property="프로퍼티 이름"/>
```
6. `<jsp:param>`: 매개변수 값을 설정한다.
   - 주로 `forward`, `include`에서 사용한다.
```html
<!--
단독으로는 사용하지 못함, forward 또는 include 태그 내부에 사용
-->
<jsp:include page="외부파일명" name="식별자" value="값" />
```

#### 자바 빈즈
- `자바 빈즈`: JSP의 표준 액션 태그로 접근할 수 있는 자바 클래스, **자바 객체**이다.
  - 값을 가지는 속성 **(맴버변수)** 과 값을 설정하는 메서드 **(setter)**, 값을 추출하는 메서드 **(getter)** 로 이루어져있다.
- 맴버변수 접근자를 `pirvate`로 설정해야한다.
- `getter`, `setter`메서드를 작성하고 접근자는 `public`으로 한다.
- 기본 생성자를 선언한다.

### 자바 빈즈를 이용해 계산기 만들기

#### html
```html
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>CookieForm</title>
</head>
<body>
<h2>Calculator JSP</h2>
<hr>
<form method="post" action="jsp/BeanTest.jsp">
    <input type="text" name="number1" size="10">
    <select name="operator">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="text" name="number2" size="10">
    <input type="submit" value="계산">
    <br>
</form>
</body>
</html>

```

#### java
```java
package com.example.servlet.day05;

// default 생성자 -> 생략가능
// 맴버 변수
// setter, getter
public class BeanTest {
    // 맴버 변수
    private int number1;
    private int number2;
    private String operator;

    public void setNumber1(int number1) {
        this.number1 = number1;
    }

    public void setNumber2(int number2) {
        this.number2 = number2;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public String getOperator() {
        return operator;
    }

    public int getResult() {
        int result = 0;
        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
        } return result;
    }
}

```
#### jsp
```html
<%--
  Created by IntelliJ IDEA.
  User: kdg
  Date: 2024. 5. 23.
  Time: PM 4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>JavaBeans Calculator</title>
</head>
<body>
<!-- 액션 태그를 사용하여 JavaBean을 선언하고 인스턴스를 생성 -->
<!--id를 통해 빈에 접근, class 완전한 패키지 경로, scope 빈이 HTTP 요청 동안에만 유효함(request)-->
<jsp:useBean id="test" class="com.example.servlet.day05.BeanTest" scope="request" />
<!--name 빈에서 정의한 ID, property 빈의 속성 이름, param HTTP 요청에서 가져올 파라미터 이름-->
<jsp:setProperty name="test" property="number1" param="number1" />
<jsp:setProperty name="test" property="number2" param="number2" />
<jsp:setProperty name="test" property="operator" param="operator" />

<h2>Calculation Result</h2>
<p>
    <%= test.getNumber1() %> <%= test.getOperator() %> <%= test.getNumber2() %> = <%= test.getResult() %>
</p>

</body>
</html>

```

1. html 파일 생성
    - `action` 값을 jsp 파일로 준다.
2. 자바 빈즈 클래스 생성
    - 맴버 변수 `number1`, `number2`, `operator` 선언
    - `getter`, `setter` 생성
    - `getResult()` 결과값 연산 함수 생성
3. jsp 파일에 **액션태그** 생성
- `<jsp:useBean id="test" class="com.example.servlet.day05.BeanTest" scope="request" />`
  - id는 인스턴스에 할당된 id -> id를 통해 빈에 접근한다.
  - class는 자바 빈스 클래스의 패키지 경로 -> 이 경로를 통해 jsp는 클래스를 찾고 인스턴스화 한다.
  - scope는 빈의 범위를 지정한다. -> 빈이 HTTP 요청 동안에만 유효함을 의미한다.
- `<jsp:setProperty name="test" property="number1" param="number1" />`
- `<jsp:setProperty name="test" property="number2" param="number2" />`
- `<jsp:setProperty name="test" property="operator" param="operator" />`
  - name은 `jsp:useBean` 태그에서 정의한 id -> 빈에 속성을 설정한다.
  - property는 빈의 속성 이름 -> 자바 빈스 클래스의 `number1` 속성을 의미한다.
  - param은 HTTP 요청에서 가져올 파라미터 이름이다.

#### 동작
- 클라이언트가 jsp 페이지에 접근하면 `jsp:useBean`태그는 자바 빈스 클래스의 인스턴스를 생성한다.
  - 이 인스턴스는 `test`라는 id로 페이지 범위에서 접근한다.
- 폼이 접근하면 `number1`, `number2`, `operator` 요청 파라미터가 전달된다.
  - `jsp:setProperty` 태그가 파라미터 값을 가져와 빈의 속성을 설정한다.
- jsp 페이지에서 빈 속성 값을 사용하여 연산을 수행하고 결과를 출력한다.


![jspCalc](https://github.com/king-dong-gun/Servlet-JSP_PKUN/assets/160683545/6a102bdb-f462-4586-bf94-a8a83f5062b9)



![jspCalc2](https://github.com/king-dong-gun/Servlet-JSP_PKUN/assets/160683545/afe357f9-3613-4ff6-9a68-34f358d3f304)
