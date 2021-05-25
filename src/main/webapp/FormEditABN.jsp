<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/companyEdited" var="CreatedNewCompany"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action ="${CreatedNewCompany}" method="post">
		Name: <input type="text" name="name" value="${company.name}"/>
		Opening Day: <input type="text" name="date" value="<fmt:formatDate value="${ company.openingDay }" pattern="dd/MM/yyyy"/>"/>
		<input type="hidden" name="id" value="${company.id}">
		<input type="submit"/>
	</form>

</body>
</html>