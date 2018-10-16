<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Minutes</title>
</head>
<body bgcolor="grey">
	<form:form modelAttribute="exercise">
	<!-- parâmetro usado(mapeado) no interceptor -->
	Language: <a href="?language=en">English</a> | <a href="?language=es">Spanish</a> 
		<table>
			<tr>
				<td><spring:message code="message.default"/></td>
				<td><form:input path="minutes" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Enter Exercise" />
				</td>
			</tr>
		</table>
	</form:form>
	<!-- 	<h4 align="center" style="color: red"> -->
	<%-- 		The result is: ${exercise.minutes} --%>
	<!-- 	</h4> -->
</body>
</html>