<%--
  Created by IntelliJ IDEA.
  User: kdg
  Date: 2024. 5. 23.
  Time: PM 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%--선언부 (메서드 선언)--%>
<%!
    public int add(int num1, int num2) {
        return num1 + num2;
    }
%>
<html>
<head>
    <title>calcTest</title>
</head>
<body>
<%
    int result = add(10, 20);
%>

<%="result1 = " + result%>
<br>
<%="result2 = " + add(10, 20)%>

</body>
</html>
