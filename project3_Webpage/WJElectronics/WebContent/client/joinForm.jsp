<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../Resources/css/join.css?ver=1">
<title>WJ 전자</title>
</head>
<body>
	<header>
		<jsp:include page="topNav.jsp"></jsp:include>
	</header>

	<div class="jointable">
		<div align="center">
			<div id="content">
				<h1 align="center">WJ Electronics</h1><br><br>
				<form action="/WJElectronics/client/join.do?cmd=join" method="post"
					name="joinForm" onsubmit="return joinInputCheck()">
					<input type="hidden" name="checkedID" id="checkedID" />
					<div class="join_content">
					<div class="row_group">
					<div class="join_row">
						<h3 class="join_title">아이디</h3>
						<span class="etc int_id idcheckbtn">
							<input type="text" id="id" name="id" class="int" title="ID" maxlength="20">
						</span>
						<div class="btn_area">
						<input type="button" value="중복확인" class="btn_type btn_primary" onclick="idDoubleCheck(this.form.id.value)" />
						</div>
					</div>
					</div>
					<div class="row_group">
					<div class="join_row">
                        <h3 class="join_title"><label>비밀번호</label></h3>
                        <span class="etc int_pass" id="pswd1Img">
							<input type="password" id="pswd1" name="pswd1" class="int" title="비밀번호 입력" aria-describedby="pswd1Msg" maxlength="20">
                            <span class="lbl"><span id="pswd1Span" class="step_txt"></span></span>
						</span>
                        <h3 class="join_title"><label>비밀번호 재확인</label></h3>
                        <span class="etc int_pass_check" id="pswd2Img">
							<input type="password" id="pswd2" name="pswd2" class="int" title="비밀번호 재확인 입력" aria-describedby="pswd2Blind" maxlength="20">
						</span>
						
                    </div>
					</div>
					<div class="row_group join_mobile">
                    <div class="join_row">
                        <h3 class="join_title"><label>이름</label></h3>
                        <span class="etc box_right_space">
							<input type="text" id="name" name="name" title="이름" class="int" maxlength="40">
						</span>
                    </div>
                    <div class="join_row join_tel">
                        <h3 class="join_title"><label>전화번호</label></h3>
                        <div class="tel_wrap">
                            <div class="sbox">
								<span class="etc">
									<select id="tel1" class="tel1" aria-label="첫번째자리">
										<option value="02">02</option>
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="016">016</option>
										<option value="017">017</option>
										<option value="018">018</option>
										<option value="019">019</option>
									</select>
								</span>
                            </div>
                            <div class="secondnum">
								<span class="etc">
									<input type="text" id="secindnum" name = "secindnum" aria-label="secondnum" class="int" maxlength="4">
								</span>
                            </div>
                            <div class="thirdnum">
								<span class="etc">
									<input type="text" id="thirdnum" name="thirdnum" aria-label="thirdnum" class="int" maxlength="4">
									<label for="thirdnum" class="lbl"></label>
								</span>
                            </div>
                        </div>
                    </div>
                    <div class="join_row">
                    	<h3 class="join_title"></h3><label for="email">이메일</label></h3>
                    	<span class="etc etc2 box_right_space">
							<input type="text" id="email" name="email" class="int" maxlength="100">
						</span>
                    </div>
                    <div class="join_row">
                    	<h3 class="join_title"><label for="zipcode">우편번호</label></h3>
                    	<div class="etc3_area">
						<span class="etc etc3">
							<input type="text" id="zipcode" name="zipcode" aria-label="우편번호" class="int" maxlength="16">
							<label for="zipcode" class="lbl"></label>
						</span>
                            <span class=""><input type="button" class="btn_verify btn_primary" id="btnSend" value="우편번호 찾기" onclick="zipCheck()"></span>
                    	</div>
                    	<div>
                    		<span class="etc"><input type="text" class="int" name="address1" id="address1"></span>
                    	</div>
                    	<div>
                    		<span class="etc"><input type="text" class="int" name="address2" id="address2"></span>
                    	</div>
                    </div>
                    <div class="btn_area">
                    	<input type="submit" id="btnJoin" class="btn_type btn_primary" value="회원 가입">
                	</div>
                </div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div>
		<footer>
			<jsp:include page="footer.jsp"></jsp:include>
		</footer>
	</div>
</body>
</html>