<%@page import="com.wj.employees.model.VO.EmProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>(주)WJ전자 상품 정보</title>
</head>
<body>
	<h3 align="center" >상품 정보</h3><br />
	<div id="main" align="center">
         <table border="1" class="colorstyle">
         	<tr style="width:60%" class="nonestyle">
  				<td align="center" width="20%" class="boldsize"><img src="${product.imageLink }" style="height: 100px; width: 100px;"> <br />
             		<b>${product.pName }</b></td>
                
              <% String[] infoArr = ((EmProductVO)request.getAttribute("product")).getInfo().split("\\+"); %>
                    
                        <td width="30%" class="boldsize"> <br /> &nbsp;&nbsp;&nbsp;
                        ${product.pCode } <br /><br />
                        <ul> <%for(String info : infoArr) { %>
                        	<li style="list-style: disc;"> <%=info %> </li> 
                        	<%} %>
                        </ul> <br /><br />&nbsp;&nbsp;&nbsp;
                        	
                        	가격 : &nbsp;${product.price }&nbsp;원 <br /><br /><br />&nbsp;&nbsp;
                     </td>
            </tr>
         </table>
	</div>
	<br />
	<div align="center">
		<input type="button" value="확인" onclick="javascript:self.close();" />
	</div>
</body>
</html>