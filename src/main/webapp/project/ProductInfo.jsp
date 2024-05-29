<%--
  Created by IntelliJ IDEA.
  User: kdg
  Date: 2024. 5. 27.
  Time: AM 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>상품 정보 조회</title>
</head>
<body>
<h2>상품 정보 조회</h2>
<hr>
<ul>
    <li>상품 코드: ${p.id}</li>
    <li>상품 명: ${p.name}</li>
    <li>상품 가격: ${p.price}</li>
    <li>제조사: ${p.maker}</li>
    <li>등록일: ${p.date}</li>
</ul>
</body>
</html>
