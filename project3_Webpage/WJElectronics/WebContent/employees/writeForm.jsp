<%@page import="com.wj.employees.model.VO.*"%>
<%@page import="com.wj.employees.model.DAO.*"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 뷰 포트 -->
<meta name="viewport" content="width=device-width", initial-scale="1" />
<!-- 스타일시트 참조 -->
<link rel="stylesheet" href="../Resources/css/bootstrap.css">
<script src = "../Resources/jquery-3.3.1.js"></script>
<script src  = "../Resources/js/bootstrap.js"></script>
<script src  = "../Resources/script.js"></script>
<script>
function WriteASInputCheck() {
	if(document.getElementById("title").value.replace(/(\s*)/gi, "") == "") {
		alert("글 제목을 입력해 주세요");
		document.getElementById("title").focus();
		return false;
	}
	if(document.getElementById("content").value.replace(/(\s*)/gi, "") == "") {
		alert("문의 내용을 입력해 주세요");
		document.getElementById("content").focus();
		return false;
	}
}
</script>
<title>WJ 전자</title>
</head>
<body>
	
<!-- 네비게이션 부분 -->
<header>
		<jsp:include page="topNav.jsp"></jsp:include>
</header>

	<!-- 글쓰기  -->
	<div class="container">
		<div class="row">
			<form method="post" action="/WJElectronics/employees/write.do?id=<%=session.getAttribute("eid") %>" name="writeForm" onsubmit="return WriteASInputCheck()" >
				<table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">
								공지문</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control" placeholder="공지 제목" id="title" name="title" maxlength="50"/></td>
						</tr>

						<tr>
							<td><textarea class="form-control" placeholder="공지 내용" id="content" name="content" maxlength="2045" style="height:350px;"></textarea></td>
						</tr>
						
						
					</tbody>
				</table>
				<input type="submit" class="btn btn-primany pull-right" value="글쓰기"/>
			</form>
		</div>
	</div>
	
<div>
		<footer>
			<jsp:include page="footer.jsp"></jsp:include>
		</footer>
</div> 
</body>
</html>