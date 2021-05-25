<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/CreatedNewCompany" var="CreatedNewCompany"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action ="${CreatedNewCompany}" method="post">
		Name: <input type="text" name="name"/>
		Opening Day: <input type="text" name="date" />
		<input type="submit"/>
	</form>

</body>
</html>