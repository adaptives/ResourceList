<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.diycomputerscience.resourcelist.model.Topic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>${topic.title}</h2>
<div>
	${topic.description}
</div>
<div>
	<h3>Resources</h3>
	<c:forEach var="resource" items="${resources}">
		<div>
			<a href="${resource.url}" target="_blank" title="${resource.comments}">${resource.title}</a>
		</div>
	</c:forEach>
</div>
</body>
</html>