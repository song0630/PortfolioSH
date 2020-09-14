<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WJ 전자</title>
<script>
	var height = window.screen.height/2.4;
	var width = window.screen.width/3.2;
	var X = (window.screen.width /2) - (width / 2);
	var Y= (window.screen.height /2) - (height / 2);

	function openSearchIdForm() {
		url = "findIdForm.jsp";
		window.open(url,"post",'status=no, height=' + height + ', width=' + width + ', left='+ X + ', top='+ Y);
	}
	function openSearchPasswordForm() {
		url = "findPasswordForm.jsp";
		window.open(url,"post",'status=no, height=' + height + ', width=' + width + ', left='+ X + ', top='+ Y);
	}

</script>
</head>
<body>
	<header>
		<jsp:include page="topNav.jsp"></jsp:include>
	</header>

	<div class="container" style="width: 100%; height: 90%">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<div class="jumbotron" style="padding-top: 20px; margin-top: 50px;">
				<form action="/WJElectronics/client/login.do" method="post"
					name="loginform" onsubmit="return loginInputCheck()">
					<h3 style="text-align: center">로그인</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디"
							name="id" maxlength="20" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호"
							name="pw" maxlength="20" />
					</div>
					<input type="submit" class="btn btn-primary form-control"
						value="로그인" />
				</form>
				<br />
				<br />
				<table style="width: 100%;">
					<tr>
						<td><a  href="/WJElectronics/employees/login.jsp">사원이신가요?</a></td>
						<td align="right">
							<button onclick="openSearchIdForm();">아이디</button>
							/
							<button onclick="openSearchPasswordForm();">비밀번호 찾기</button></td>
					</tr>
				</table>
				
				
			</div>
		</div>
		<div class="col-lg-4"></div>
	</div>


	<div>
		<footer>
			<jsp:include page="footer.jsp"></jsp:include>
		</footer>
	</div>
</body>
</html>