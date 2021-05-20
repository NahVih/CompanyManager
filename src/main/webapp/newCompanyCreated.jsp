<%
String name = (String)request.getAttribute("companyName");
System.out.println(name);
%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>New Company Registered</title>
</head>
<body>
New Company <% out.println(name); %> registered with success.
New Company <%= name %> registered with success.
</body>
</html>