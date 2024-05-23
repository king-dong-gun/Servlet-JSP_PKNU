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
