<%@page import="com.wj.client.model.VO.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>사원 로그인</title>
<style>
	html {overflow:hidden;}
</style>
</head>
<body>
	<c:if test="${result == 1}">
		<%	session.setAttribute("eid", request.getAttribute("eid"));
			session.setAttribute("productList", new ArrayList<ProductVO>());%>
		<script>
			sessionStorage.setItem("eid", '<%=request.getAttribute("eid") %>')
			alert("환영합니다");
			location.href="index.jsp";
		</script>
		
	</c:if>
	
	<c:if test="${result == -1}">
		<script>
			alert("아이디가 없습니다.");
			history.go(-1);
		</script>
	</c:if>
	
	<c:if test="${result == -2}">
		<script>
		alert("비밀번호가 틀립니다.");
		history.go(-1);
		</script>
	</c:if>
	
	<c:if test="${result==-3}">
		<script>
		alert("서버가 점검중입니다.");
		history.go(-1);
		</script>
	</c:if>	
</body>
</html>