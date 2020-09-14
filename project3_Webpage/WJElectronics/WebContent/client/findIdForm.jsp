<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>

<style>
.colorstyle:not (.nonestyle ) {
	background-color: #ffffff;
	opacity: 0.8;
}
</style>
<script>
	function InputCheck() {
		if(document.searchIdForm.id.value.replace(/(\s*)/gi, "") == "") {
			alert("이름을 입력하십시오.");
			document.searchIdForm.id.focus();
			return false;
		}
		
		if(document.searchIdForm.pw.value.replace(/(\s*)/gi, "") == "") {
			alert("이메일을 입력하십시오.");
			document.searchIdForm.pw.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<div align="center" style="margin-top: 50px; border: 1px;">
	<h3 align="center">아이디 찾기</h3>
	<br />
	<div id="main" align="center" style="width: 300px; height: 200px;">
		<form action="/WJElectronics/client/searchClient.do" id="searchIdForm" onsubmit="InputCheck()">
			<input type="hidden" name="cmd" value="searchId" />
			<table class="colorstyle" border="1">
				<tr>
					<td>이름 :</td>
					<td><input type="text" name="name" id="name" /></td>
				</tr>
				<tr>
					<td>이메일 :</td>
					<td ><input type="email" name="email" id="email" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="아이디 찾기" /> &nbsp;
						<input type="reset" value="다시 입력" /> &nbsp;
						<input type="button" value="취소" onclick="javascript:self.close();" />&nbsp;
					</td>
				</tr>
				<tr align="right">
					<td colspan="2">
						<a href="findPasswordForm.jsp">비밀번호 찾기</a>
					</td>
				</tr>
			</table>
			<br />
		</form>
	</div>
	</div>
</body>
</html>