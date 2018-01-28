<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="../js/home.js"></script>
		<link rel="stylesheet" href="../css/style.css">
		<title>Issue Tracker</title>
	</head>
	<body>
	

		
			<c:choose>
				<c:when test="${plan==null}">
					<h1>No plan possible</h1>
					<h2>some stories exceed the maximum iteration (week) capacity: please re-elaborate your stories</h2>
				</c:when>
				<c:otherwise>
				
					<h1>Project Plan</h1>
				
					<%-- listing Weeks of the Plan --%>
					<c:forEach items="${plan}" var="week" varStatus="status">
						<div class="borderedBox">
							<table>
								<%-- week header --%>
								<tr>
									<td colspan="2">
										<h2>Week ${status.count} </h2>
									</td>
									<td align="right">
										<h2>${week.getFilledCapacity()} of ${week.getMaxCapacity()} Story Points</h2>
									</td>
								</tr>
								
								<%-- listing Stories of the Week --%>
								<tr>
									<td>
										<ul>
											<c:forEach items="${week.getStories()}" var="story">
												<li> ${story.getTitle()}    -       ${story.getEstimatedPoints()} Points</li>
											</c:forEach>
										</ul>
									</td>
								</tr>
							</table>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
	</body>
</html>