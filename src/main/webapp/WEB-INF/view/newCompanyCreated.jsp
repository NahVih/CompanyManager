<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<c:if test="${not empty companyName}">
		New Company ${ companyName } registered with success.
	</c:if>
	
	<c:if test="${empty companyName}">
		No company registered.
	</c:if>
</body>
</html>