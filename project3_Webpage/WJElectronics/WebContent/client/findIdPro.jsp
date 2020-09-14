<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>
<body>
	<div align="center" style="margin-top: 30%;">
		<% 	String result = (String)request.getAttribute("result");
			if(result.equals("-1")) { %>
				<script>
					alert("입력 정보가 다릅니다. \n내용을 확인해 주세요");
					history.go(-1);
				</script>
		<%}  else {%>
			<h2>${name }님의 아이디는 '${result }'입니다.</h2>
		<%} %>
	</div>
	<div align="center">
		<input type="button" value="확인" onclick="javascript:self.close();" />
	</div>
</body>
</html>