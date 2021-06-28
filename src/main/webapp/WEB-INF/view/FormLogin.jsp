<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/main" var="CreatedNewCompany"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action ="${CreatedNewCompany}" method="post">
		Login: <input type="text" name="login"/>
		Password: <input type="password" name="password" />
		
		<input type="hidden" name="action" value="Login">
		
		<input type="submit"/>
	</form>

</body>
</html>