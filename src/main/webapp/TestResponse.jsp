<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Response</title>
</head>
<body>
Hello <%= request.getAttribute("firstname") %>
It appears that your last name is <%= request.getAttribute("lastname") %>
I see that your birth date is <%= request.getAttribute("birthdate") %>
That makes you <%= request.getAttribute("age") %> years old
And your favorite color is <%= request.getAttribute("color") %>
</body>
</html>