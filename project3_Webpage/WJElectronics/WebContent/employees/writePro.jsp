<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
        <%

	request.setCharacterEncoding("UTF-8");

	response.setContentType("text/html; charset=UTF-8"); //set���ξ��� �������̼���.

	%>

<!-- �Ѹ��� ȸ�������� ��� userŬ������ �ڹ� ����� ��� / scope:������ ������ ������������ ���-->
		<!-- �ڹ�Ŭ������ -->     <!-- ��Ű����.Ŭ������ -->
<jsp:useBean id="emVO" class="com.wj.employees.model.VO.EmployeesNoticeVO" scope="page" />

				<!-- �ڹ�Ŭ������ -->
<jsp:setProperty name="emVO" property="title" />
				<!-- �ڹ�Ŭ������ -->
<jsp:setProperty name="emVO" property="content" />
				<!-- �ڹ�Ŭ������ -->
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${result eq 1 }">
		<script>
			alert("���ǻ����� ��ϵǾ����ϴ�.");
			location.href="/WJElectronics/employees/employeesNotice.do?pagenumber=1";
		</script>
	</c:if>
	<c:if test="${result != 1 }">
		<script>
			alert("���� �������Դϴ�. ����� �õ����ּ���");
			history.go(-1);
		</script>
	</c:if>
</body>
</html>