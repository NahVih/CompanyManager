<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,au.com.alura.manager.model.Company"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
</head>
<body>

	<c:if test="${not empty companyName}">
		New Company ${ companyName } registered with success.
	</c:if>
	

Companies list:

	<ul>
		<c:forEach items="${companies}" var="company">
			
			<li>
				${ company.name } - <fmt:formatDate value="${ company.openingDay }" pattern="dd/MM/yyyy"/>
				<a href="/manager/main?action=companyRemoving&id=${company.id}">remove</a>
				<a href="/manager/main?action=companyEditing&id=${company.id}">edit</a>
			</li>
		</c:forEach>
	</ul>
	
<a href="/manager/main?action=newCompany"> Form Create New Company</a>
</body>
</html>