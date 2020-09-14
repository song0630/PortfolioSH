<%@page import="com.wj.client.model.VO.AsVO"%>
<%@page import="com.wj.client.model.DAO.AsDAO"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WJ 전자</title>
<style>
</style>
<script>
	function reply(index) {
		document.getElementById("commentLine" + index).style.display = '';
	}
	function cancel(index) {
		document.getElementById("commentLine" + index).style.display = 'none';
	}
</script>


</head>
<body>

	<!-- 네비게이션 부분 -->
	<header>
		<jsp:include page="topNav.jsp"></jsp:include>
	</header>



	<!-- 글쓰기  -->
	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="4"
							style="background-color: #eeeeee; text-align: center;">
							${vo.title }</th>
					</tr>

				</thead>
				<tbody>
					<tr>
						<td>작성자</td>
						<td width="250">${vo.writer }</td>
						<td>작성일</td>
						<td width="250">${vo.date }</td>
					</tr>

					<tr>
						<td colspan="4"
							style="height: 350px; background-color: #ffffff; opacity: 0.8;">${vo.content }</td>
					</tr>

					<tr>
						<td><c:if test="${vo.asNo < lastPage}">
								<a
									href="/WJElectronics/employees/asView.do?asno=${vo.asNo + 1 }">이전글
								</a>
							</c:if></td>
						<td colspan="2"><a
							href="/WJElectronics/employees/asListForm.do?pagenumber=1">목록</a></td>
						<td><c:if test="${vo.asNo > 1}">
								<a
									href="/WJElectronics/employees/asView.do?asno=${vo.asNo - 1 }">다음글</a>
							</c:if></td>
					</tr>

				</tbody>
			</table>
		</div>

		<!-- 댓글  -->
		<!-- 댓글 부분 -->
		<%
			int index = 0;
		%>
		<div id="comment">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #ffffff;">
				<!-- 댓글 목록 -->

				<c:if test="${not empty comment}">
					<c:forEach var="comment" items="${comment}">
						<%
							index++;
						%>
						<tr id="trId<%=index%>" bgcolor="#ffffff">
							<!-- 아이디, 작성날짜 -->
							<td>
								<div>
									${comment.id}<br> <font size="2" color="lightgray">${comment.date}</font>
								</div>
							</td>
							<!-- 본문내용 -->
							<td width="600" align="left">${comment.content}</td>
							<!-- 버튼 -->
							<td>
								<div id="btn" style="text-align: center;">

									<button onclick="reply('<%=index%>')" style="">답변</button>
									<br> <a
										href="/WJElectronics/employees/commentWriteAction.do?de=1&cono=${comment.cono}&asno=${vo.asNo}">[삭제]</a>
								</div>
							</td>
						</tr>
						<form method="post"
							action="/WJElectronics/employees/commentWriteAction.do?de=2">
							<tr bgcolor="#ffffff" style="display: none"
								id="commentLine<%=index%>">

								<!-- 아이디-->
								<td valign="middle"><input type="hidden" name="parent"
									value="${comment.cono}"> <input type="hidden"
									name="asno" value="${vo.asNo}"> <input type="hidden"
									name="id" value="${sessionScope.eid}">
									<div>
										<img src="../image/point.png"> ${sessionScope.eid}
									</div></td>
								<!-- 본문 작성-->
								<td width="600">
									<div>
										<textarea name="content" placeholder="답글 내용" rows="4"
											cols="70"></textarea>
									</div>
								</td>
								<!-- 댓글 등록 버튼 -->
								<td valign="middle"><input type="submit" value="등록">
									<button onclick="cancel('<%=index%>')">취소</button></td>
							</tr>
						</form>


						<!-- 대댓글for문 -->
						<c:forEach var="cc" items="${ccomment}">
							<c:if test="${comment.cono == cc.parent }">
								<tr bgcolor="#ffffff">
									<!-- 아이디, 작성날짜 -->
									<td>
										<div>
											<img src="../image/comment.png"> ${cc.id}<br> <font
												size="2" color="lightgray">${cc.date}</font>
										</div>
									</td>
									<!-- 본문내용 -->
									<td width="600" align="left">${cc.content}</td>
									<!-- 버튼 -->
									<td>
										<div id="btn" style="text-align: center;">
											<!-- <a href="#">[수정]</a>
										<br> -->
											<a
												href="/WJElectronics/employees/commentWriteAction.do?de=1&cono=${cc.cono}&asno=${vo.asNo}">[삭제]</a>
							</c:if>
							</div>
							</td>
							</tr>

						</c:forEach>
					</c:forEach>

				</c:if>
				
					<form method="post"
						action="/WJElectronics/employees/commentWriteAction.do?de=0">
						<tr bgcolor="#F5F5F5">
							<!-- 아이디-->
							<td valign="middle"><input type="hidden" name="asno"
								value="${vo.asNo}">
								<div>admin</div></td>
							<!-- 본문 작성-->
							<td width="600">
								<div>
									<textarea name="content" placeholder="댓글 내용" rows="4" cols="70"></textarea>
								</div>
							</td>
							<!-- 댓글 등록 버튼 -->
							<td valign="middle"><input type="submit" value="[댓글등록]">
							</td>
						</tr>
					</form>

			</table>
		</div>



	</div>

	<footer>
		<jsp:include page="./footer.jsp"></jsp:include>
	</footer>

</body>
</html>