<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List, au.com.alura.manager.servelet.Company"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>
Companies list:

	<ul>
		<c:forEach items="${companies}" var="company">
			<li>${ company.name }</li>
		</c:forEach>
	</ul>
</body>
</html>