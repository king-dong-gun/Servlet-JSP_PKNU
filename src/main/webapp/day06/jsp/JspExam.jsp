<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%--
  Created by IntelliJ IDEA.
  User: kdg
  Date: 2024. 5. 27.
  Time: AM 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%-- taglib 지시어를 통한 커스텀 태그 선언 --%>
<html>
<head>
  <meta charset="UTF-8">
  <title>JSTL Example</title>
</head>
<body>
<h2>JSTL</h2>
<h3>set, out</h3>
<c:set var="Product1" value="<h2>애플 아이폰</h2>"/>
<c:set var="Product2" value="<h2>삼성 갤럭시</h2>"/>
<c:set var="intArray" value="${[1,2,3,4,5]}"/>
<p>
  product1(jstl):
  <c:out value="${Product1}" default="Not registered" escapeXml="true"/>
</p>
<p>product1(el): ${Product1}</p>
<p>intArray[2]: ${intArray[2]}</p>
<hr>
<h3>forEach 배열 출력</h3>
<ul>
  <c:forEach var="num" varStatus="i" items="${intArray}">
      <li>${i.index}: ${num}</li>
    </c:forEach>
</ul>
<hr>
<h3>if</h3>
<c:set var="checkout" value="true"/>
<c:if test="${checkout}">
  <p>주문 제품: ${Product2}</p>
</c:if>
<c:if test="${!checkout}">
  <p>체크아웃 상태가 아님</p>
</c:if>
</body>
</html>
