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
