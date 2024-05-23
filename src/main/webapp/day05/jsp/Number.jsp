<%--
  Created by IntelliJ IDEA.
  User: kdg
  Date: 2024. 5. 23.
  Time: PM 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Number</title>
</head>
<body>


<%
    int sum = 0;
    for (int i = 1; i <= 100; i++) {
        sum += i;
    }
%>
<%="sum = " + sum%>


</body>
</html>
