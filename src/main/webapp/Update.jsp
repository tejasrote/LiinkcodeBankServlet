<%@page import="Linkcode.bank.Model.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
</head>
<body>
<form action="UpdateController">
Account Number<input type="text" name="accno"><br>

Balance<input type="text" name="bal"><br>
<input type="Submit" value="Update">
</form>

</body>
</html>