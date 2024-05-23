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
<form method="post" action="Calculator.jsp">
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

