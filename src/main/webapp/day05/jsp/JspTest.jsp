<%--
  Created by IntelliJ IDEA.
  User: kdg
  Date: 2024. 5. 23.
  Time: PM 1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>JSP TEST</title>
</head>
<body>
<%  String id = "Adam";
    String pw = "1234";
%>

<div>
    id <input type="text" name="id" value="<%=id%>">
</div>
<div>
    pw <input type="password" name="pw" value="<%=pw%>">
</div>

</body>
</html>
