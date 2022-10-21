<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	
	<form  method="get" action="Addroom.jsp" >
	<table border="3" align="center">
		<tr>
		 <th>Id </th>
		 <td> <input Type ="number" name="roomId" />
		 
		 <th>Type</th>
		  <td> <input Type ="text" name="type" />
		 
		 <th>Status</th>
		  <td> <input Type ="text" name="status" />
		 
		 <th>CostperDay</th>
		  <td> <input Type ="number" name="costperday" />
		 <select name="Status">
		 <option value="AVAILABLE">Available</option>
		 <option value="BOOKED">Booked</option>
		 
		</select>
		</td>
		</tr>
		<tr>
<td>
<input type="Submit"  value="Addroom">
</td>
</tr>
	  
	 </table>
	</form>
	<c:if test="${param.tid!=null && param.type!=null && param.status!=null && param.costperday!=null}">
		<jsp:useBean id="beanOyo" class="com.infinite.booking.Oyo"/>
		<jsp:setProperty property="*" name="beanOyo"/>
		<jsp:useBean id="beanDao" class="com.infinite.booking.OyoDAO"/>
		<c:out value="${beanDao.addRoom(beanRoom)}"/>
		</c:if>
</body>
</html>