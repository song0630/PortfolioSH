<%@page import="com.wj.employees.model.DAO.PurchaseManageDAO"%>
<%@page import="com.wj.employees.model.VO.EmPurchaseManageVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WJ 전자</title>
</head>
<style>
.colorstyle:not(.nonestyle) {
   background-color: #ffffff;
   opacity: 0.8;
}	
</style>
<script>
	function updateState(index) {
		
		var renewURL = location.href;
		var status = document.getElementById("selectBox"+index).value;
		var purchaseCode = document.getElementById("purchaseCode"+index).value;
		
		var url = "/WJElectronics/employees/purchaseStateUpdate.do?purchaseCode="+purchaseCode + "&status=" + status;
		var frame = document.getElementById("hiddenframe1");
		frame.src = url;
	}
	function openEmProductInfoForm(productCode) {
		var height = window.screen.height/1.6;
		var width = window.screen.width/2.4;
		var X = (window.screen.width /2) - (width / 2);
		var Y= (window.screen.height /2) - (height / 2);
		
		url = "/WJElectronics/employees/productInfoForm.do?productCode=" + productCode;
		window.open(url,"post",'status=no, height=' + height + ', width=' + width + ', left='+ X + ', top='+ Y);
	}
</script>
<body>
	<header>
		<jsp:include page="topNav.jsp"></jsp:include>
	</header>
	
	
	<%-- <%
String id=request.getParameter("id");
String name=request.getParameter("name");
String code=request.getParameter("code");
%>

 --%>
	
	<iframe width=0 height=0 id="hiddenframe1" name="hiddenframe1" style="display:none;"></iframe>
	<div align="center" style="margin-left: 20%; margin-right: 20%;">
		<h1 style="margin-bottom: 10%">배송 관리</h1>
		<div id="main" align="center" style="margin-bottom: 5%;">
		
			<%	int selectindex=0;
				ArrayList<EmPurchaseManageVO> purchaseList = (ArrayList<EmPurchaseManageVO>)request.getAttribute("purchaseList"); 
			%>
				 
			<%for(int i = 0; i < purchaseList.size(); i++) { %>
				<input type="hidden" id="purchaseCode<%=i%>" value="<%=purchaseList.get(i).getPurchaseCode() %>" />
				<table border="1" style="width:60%; margin-bottom: 5%;" class="colorstyle">
					<tr><th style="text-align: center;">고객 id</th>
						<th style="text-align: center;">거래 코드</th><th style="text-align: center;">거래 품목</th><th style="text-align: center;">수량</th>
						<th style="text-align: center;">총액</th><th style="text-align: center;">거래일</th><th style="text-align: center;">상태</th>
					</tr>
					
					
					<% 
					
					if(purchaseList.get(i).getPurchaseType().equals("singleProduct")) { %>
						<tr>
							<td align="center"><b><%=purchaseList.get(i).getBuyerId() %>  </b> </td>
							<td align="center"><b><%=purchaseList.get(i).getPurchaseCode() %></b></td>
							<td align="center"><br /><b style="color: blue;"><button onclick="openEmProductInfoForm('<%=purchaseList.get(i).getProductCode() %>');"><%=purchaseList.get(i).getProductCode() %></button></b><br /><br /></td>
							<td align="center"><b><%=purchaseList.get(i).getQuantity() %></b></td>
							<td align="center"><b><%=purchaseList.get(i).getPrice() %></b></td>
							<td align="center"><b><%=purchaseList.get(i).getPurchaseDate() %></b></td>
							<td align="center"><b>
							<select name="배송상태" id="selectBox<%=i %>" onchange="updateState(<%=i%>)">
								<option value="접수 완료" <% if(purchaseList.get(i).getStatus().equals("접수 완료")) { %> selected <%}  %>>접수 완료</option>
								<option value="배송중" <% if(purchaseList.get(i).getStatus().equals("배송중")) { %> selected <%}  %>>배송중</option>
								<option value="배송 완료" <% if(purchaseList.get(i).getStatus().equals("배송 완료")) { %> selected <%}  %>>배송 완료</option>
							</select></b>
							</td>
							
						</tr>
					<%} 
					
					
					%>
					<!-- <script> 
					function changeSelect(){ 
					var Select = document.getElementById("selectBox");  
					var selectValue = Select.options[Select.selectedIndex].value; // select element에서 선택된 option의 value가 저장된다.//접수완료
					var selectText = Select.options[Select.selectedIndex].text; // select element에서 선택된 option의 text가 저장된다. //
					window.location.reload(true);
					} 
					</script> -->
					
					

					
					
					<% if(purchaseList.get(i).getPurchaseType().equals("multiProduct")) { %>
						<%	String[] productCode = purchaseList.get(i).getProductCode().split("~");
							String[] quantitys = purchaseList.get(i).getQuantity().split("~");
							%>
						<tr>
							<td align="center"> <b><%=purchaseList.get(i).getBuyerId() %></b></td>
							<td align="center"><b id="productCode<%=i%>"><%=purchaseList.get(i).getPurchaseCode() %></b></td>
							
							<td align="center"> <%	for(int j = 0; j < productCode.length; j++) { %>
							<br /><b style="color: blue;"><button onclick="openEmProductInfoForm('<%=productCode[j] %>');"><%=productCode[j] %></button></b><br /><br />
							<% } %> </td>
							<td align="center"> <%	for(int j = 0; j < productCode.length; j++) { %>
								<br /><b><%=quantitys[j] %></b> <br /><br />
							<% } %> </td>
							<td align="center"><b><%=purchaseList.get(i).getPrice() %></b></td>
							<td align="center"><b><%=purchaseList.get(i).getPurchaseDate() %></b></td>
							<td align="center"><b>
							<select name="배송상태" id="selectBox<%=i %>" onchange="updateState(<%=i%>)">
								<option value="접수 완료" <% if(purchaseList.get(i).getStatus().equals("접수 완료")) { %> selected <%}  %>>접수 완료</option>
								<option value="배송중" <% if(purchaseList.get(i).getStatus().equals("배송중")) { %> selected <%}  %>>배송중</option>
								<option value="배송 완료" <% if(purchaseList.get(i).getStatus().equals("배송 완료")) { %> selected <%}  %>>배송 완료</option>
							</select></b>
							</td>
						
						</tr>
					<%} %>
				</table>
				<script>
				function reload() {
		
				   window.location.reload(true);
				}
				
				</script>
			<%} 
			
			
			%>
		</div>
		<div class="page" align="center" style="margin-bottom: 10%; margin-left: 10%">
		<c:if test="${count>0 }">
			<c:set var="imsi" value="${count % pageSize == 0 ? 0: 1}" />
			<c:set var="pageCount" value="${count / pageSize + imsi}" />
			<c:set var="pageBlock" value="${3 }" />
			<fmt:parseNumber var="result" value="${(pageNum-1) / pageBlock}"
				integerOnly="true" />
			<c:set var="startPage" value="${result*pageBlock+1}" />
			<c:set var="endPage" value="${startPage + pageBlock-1}" />
			<c:if test="${endPage > pageCount}">
				<c:set var="endPage" value="${pageCount}"></c:set>
			</c:if>
			<c:if test="${startPage > pageBlock}">
				<a
					href="/WJElectronics/employees/purchaseManage.do?cmd=getPurchaseList&pageNum=${startPage - pageBlock}">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<a
					href="/WJElectronics/employees/purchaseManage.do?cmd=getPurchaseList&pageNum=${i}">[${i}]</a>
			</c:forEach>
			<c:if test="${endPage < pageCount}">
				<a
					href="/WJElectronics/employees/purchaseManage.do?cmd=getPurchaseList&pageNum=${startPage  + pageBlock}">[다음]</a>
			</c:if>
		</c:if>
	</div>
	</div>
	
	<div>
		<footer>
			<jsp:include page="footer.jsp"></jsp:include>
		</footer>
	</div>
</body>
</html>

