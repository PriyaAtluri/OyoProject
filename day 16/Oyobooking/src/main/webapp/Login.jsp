<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Login.jsp">
		customer Name : 
		<input type="text" name="custName" /> <br/><br/> 
		Room Type :
		<input type="roomtype" name="roomtype" /> <br/><br/>
		<input type="submit" value="Login" />
	</form>
	<c:if test="${param.userName!=null && param.passWord!=null}">
		<jsp:useBean id="beanOyo" class="com.infinite.booking.Oyo"/>
		<jsp:setProperty property="*" name="beanLibUsers"/>
		<jsp:useBean id="beanDao" class="com.infinite.booking.OyoDAO"/>
		<c:set var="custname" value="${param.customerName}"/>
		<c:set var="roomtype" value="${param.RoomType}"/>
		<c:set var="count" value="${beanDao.loginCheck(custname,roomtype)}"/>
		<c:if test="${count==1}">
		<c:set var="custname" value="${custname}" scope="session" />
			<jsp:forward page="Account.jsp"/>
		</c:if>
		<c:if test="${count==0}">
			<c:out value="Invalid Credentials..."/>
		</c:if>
	</c:if>
</body>
</html>