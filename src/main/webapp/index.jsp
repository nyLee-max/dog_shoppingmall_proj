<%@page import="dog_shoppingmall_proj.ds.JndiDs"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=JndiDs.getConnection() %>
<a href="dogList.do">개 쇼핑몰</a>
</body>
</html>