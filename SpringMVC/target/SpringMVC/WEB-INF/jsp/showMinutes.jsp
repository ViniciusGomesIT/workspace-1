<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Minutes</title>
</head>
<body bgcolor="grey">
	<form:form modelAttribute="exercise">
		<table>
			<tr>
				<td>Minutes to start calculate:</td>
				<td><form:input path="minutes"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Enter Exercise" />
				</td>
			</tr>
		</table>
	</form:form>
<!-- 	<h4 align="center" style="color: red"> -->
<%-- 		The result is: ${exercise.minutes} --%>
<!-- 	</h4> -->
</body>
</html>