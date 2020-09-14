<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width" , initial-scale="1" />
<link rel="stylesheet" href="../Resources/css/bootstrap.css">
<link rel="stylesheet" href="../Resources/css/index.css?ver=1">
<script src="../Resources/jquery-3.3.1.js"></script>
<script src="../Resources/js/bootstrap.js"></script>
<script src="../Resources/script.js"></script>
<style>
 body{background: url('../Resources/images/bae.jpg')
}
</style>
<nav class="navbar navbar-default" id="topNav" style="background:#333;">
	<div class="nav navbar-nav navbar-right" id="Top_sns">
		<ul class="sns" id="TOP_sns">
			<li class="fb"><a href="https://www.facebook.com">Facebook</a></li>
			<li class="blog"><a href="http://blog.naver.com">Blog</a></li>
			<li class="insta"><a href="https://instagram.com/pascucci_kr">Instagram</a></li>
			<li class="youtube"><a
				href="https://www.youtube.com/channel/UCHKRIWTWjq0uzJOAm6KFHOg">Youtube</a></li>
		</ul>
	</div>
	<div>
		<img src="../image/wjLogo.png" width="200">
		<div>
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">WJElectronics</a>
		</div>
	</div>
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<div id="menu">
			<ul class="dept01">
				
				<li><a href="/WJElectronics/employees/asListForm.do?pagenumber=1">AS</a>
				</li>
				<li><a href="/WJElectronics/employees/cliNotice.do?pagenumber=1">공지사항</a>
				</li>
			</ul>
		</div>
		<ul class="nav navbar-nav navbar-right">

			<c:if test="${sessionScope.eid == null }">
				<li><a href="login.jsp">사원 로그인</a></li>
			</c:if>

			<c:if test="${sessionScope.eid != null }">
				<li><a href="purchaseManage.do?cmd=getPurchaseList&pageNum=1" >배송 관리</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"> ${sessionScope.eid } <span
						class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="logout.jsp">로그아웃</a></li>
					</ul></li>
			</c:if>
		</ul>
	</div>
</nav>