<%@page import="com.wj.utils.ConnUtil"%>
<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8" import="java.sql.*"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <%

    
  PreparedStatement pstmt = null;
  request.setCharacterEncoding("utf-8");
 	Connection conn = null;
  try {
	  conn = ConnUtil.getConnection();
	  
  } catch(Exception e) {
	  
  }
  		if (conn== null) {
	   out.println("Connection Failed.");
	  } 
  %>
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>사원급식표</title>
<style>
	#p1{
		background-color: rgba( 255, 255, 255, 0.5 );
	}
</style>
 </head>
 <body>
   <header>
      <jsp:include page="topNav.jsp"></jsp:include>
   </header>
  <%
  java.util.Calendar cal=java.util.Calendar.getInstance(); 
  
  int currentYear=cal.get(java.util.Calendar.YEAR); 
  int currentMonth=cal.get(java.util.Calendar.MONTH);
  int currentDate=cal.get(java.util.Calendar.DATE);
  
  String Year=request.getParameter("year"); 
  String Month=request.getParameter("month");
  
  int year, month;
  if(Year == null && Month == null){ //처음 호출했을 때
  		year=currentYear;
  		month=currentMonth;
  } else { //나타내고자 하는 날짜를 숫자로 변환
  		 year=Integer.parseInt(Year);
   		 month=Integer.parseInt(Month);
         if(month<0) { 
        	 month=11; year=year-1; 
        	 } //1월부터 12월까지 범위 지정.
         }
   		if(month>11) { 
   			month=0; year=year+1; 
   		}
  %>
  <center>
  <table border=3 id="p1">
   <tr>
    <td align=center width=200 height="50"> <!-- 년 도-->
    <a href="Calendar.jsp?year=<%out.print(year-1);%>&month=<%out.print(month);%>">◀</a>
    <% out.print(year); %>년
    <a href="Calendar.jsp?year=<%out.print(year+1);%>&month=<%out.print(month);%>">▶</a>
    </td>
    <td align=center width=200> <!-- 월 -->
    <a href="Calendar.jsp?year=<%out.print(year);%>&month=<%out.print(month-1);%>">◀</a>
    <% out.print(month+1); %>월
    <a href="Calendar.jsp?year=<%out.print(year);%>&month=<%out.print(month+1);%>">▶</a>
    </td>
    <td align=center width=200><% out.print(currentYear + "-" + (currentMonth+1) + "-" + currentDate); %></td>
   </tr>
  </table>
  <table id="p1" width="70%" border="3" cellspacing="1" cellpadding="1" id="KOO" style='border:solid 1px black;' cellspacing="0" cellpadding="0" >
   <tr bgcolor="#CECECE">
    <td width=150 align = center>일</td> 
    <td width=150 align = center>월</td>
    <td width=150 align = center>화</td>
    <td width=150 align = center>수</td>
    <td width=150 align = center>목</td> 
    <td width=150 align = center>금</td> 
    <td width=150 align = center>토</td> 
   </tr>
   <tr height=15>
   <%
   cal.set(year, month, 1); 
   int startDay=cal.get(java.util.Calendar.DAY_OF_WEEK); 
   int end=cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH); 
   int br=0; //7일마다 줄 바꾸기
   for(int i=0; i<(startDay-1); i++) { //빈칸출력
    out.println("<td>&nbsp;</td>");
    br++;
    if((br%7)==0) {
     out.println("<br>");
    }
   }
   for(int i=1; i<=end; i++) { //날짜출력
    out.println("<td>" + i + "<br>");
      //일정 추가
      int memoyear, memomonth, memoday;
      try{
		   String sql = "select year,month,day,menu1,menu2,menu3,menu4,origin,kcal from sawonDiet";
		   pstmt= conn.prepareStatement(sql);
		   ResultSet rs = pstmt.executeQuery();
		   while(rs.next()) {
			   memoyear = rs.getInt("year");
			   memomonth = rs.getInt("month");
			   memoday = rs.getInt("day");
			   if(year==memoyear && month+1==memomonth && i==memoday) {
				    out.println("<hr style='border:solid 1px black;'>");
				    out.println("● " +  rs.getString("menu1"));
				    out.println("<br>");
				    out.println("● " +  rs.getString("menu2"));
				    out.println("<br>");
				    out.println("● " +  rs.getString("menu3"));
				    out.println("<br>");
				    out.println("● " +  rs.getString("menu4"));
				    out.println("<hr style='border:solid 1px black;'>");
			   		out.println("● " +  rs.getString("kcal"));
			   		out.println("<hr style='border:solid 1px black;'>");
			   		out.println("● " +  rs.getString("origin"));
			   }
		   }
      }
      catch(Exception e) {
       System.out.println(e);
      };
    out.println("</td>");
    br++;
    if((br%7)==0 && i!=end) {
     out.println("</tr><tr height=30>");

    }
   }
   while((br++)%7!=0)
    out.println("<td>&nbsp;</td>");
   %>
   </tr>
  </table>
  </center>
     <div>
   <footer>
      <jsp:include page="footer.jsp"></jsp:include>
   </footer>
   </div>
 </body>
</html>
   <%
       pstmt.close();
       conn.close();
   %>