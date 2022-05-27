<%@page import="Linkcode.bank.Model.Account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>List of All Accounts</h2>
<c:if test="${requestScope.message !=null}">
NOTE : ${message}
</c:if>
<c:if test="${requestScope.acclist !=null and 
not empty requestScope.acclist}">
<table border="1" cellpadding="3">
<tr>
<td>Account Number</td>
<td>Customer Name</td>
<td>User Name</td>
<td>Balance</td>
<td>&nbsp;</td>
</tr>
</table>
</c:if>
</body>
</html>