<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<body>
	<%	int result = (int)request.getAttribute("result");
		if(result == 1) { %>
			<div align="center">
				<h3 align="center">임시 비밀번호가 메일로 발송되었습니다.</h3>
				<div align="center">
					<input type="button" value="확인" onclick="javascript:self.close();" />
				</div>
			</div>
			
	<% } else { %>
		<script>
			alert("입력 하신정보가 맞지 않습니다.\n내용을 확인해 주세요");
			history.go(-1);
		</script>
	<% } %>
</body>
</html>