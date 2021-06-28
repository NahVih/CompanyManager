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
<c:import url="Logout-part.jsp" />
	<br>

	User Online: ${userOn.login }

	<br>

	<c:if test="${not empty companyName}">
		New Company ${ companyName } registered with success.
	</c:if>
	

Companies list:

	<ul>
		<c:forEach items="${companies}" var="company">
			
			<li>
				${ company.name } - <fmt:formatDate value="${ company.openingDay }" pattern="dd/MM/yyyy"/>
				<a href="/manager/main?action=CompanyRemoving&id=${company.id}">remove</a>
				<a href="/manager/main?action=CompanyEditing&id=${company.id}">edit</a>
			</li>
		</c:forEach>
	</ul>
	
<a href="/manager/main?action=CompanyNew"> Form Create New Company</a>
</body>
</html>