<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"   "http://www.w3.org/TR/html4/loose.dtd">
<h1>
Welcome to Fleet Man , the date and time is ${dateAndTime}
</h1>

<c:forEach var="i" begin="1" end="5" >
	<p>${i} </p>
</c:forEach>
