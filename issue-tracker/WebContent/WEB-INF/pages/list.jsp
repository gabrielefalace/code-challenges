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

		<a href="createIssue"> Create new issue </a>  |  <a href="storyPlan"> Story Planning </a>
				
		
		<c:if test="${listType == 'Open'}">
			<h1> List of open issues (${list.size()}) </h1> 
			<a href="../page/listAll"> Show All </a>
		</c:if>
		<c:if test="${listType == 'All'}">
			<h1> List of all issues (${list.size()}) </h1> 
			<a href="../page/listOpen"> Show only open </a>
		</c:if>
		
		
		<table>
			<c:forEach items="${list}" var="issue">
				<tr>
					<td> 
						<div class="issueBox">
							<h3> ${issue.title}  </h3> 
							<p class="descriptionText"> ${issue.description} </p>
							<p>Assigned developer:  ${issue.developer} </p>
							
							<c:if test="${issue.getClass().name=='model.Bug'}">
								<p>Priority: ${issue.priority} </p>
								<p>Status: ${issue.bugStatus} </p>
								<p>Created on: <span class="timestamp"> <fmt:formatDate type="both" dateStyle="medium" timeStyle="short" value="${issue.creationDate}" /> </span>   |  <a class="editLink" href="../bug/${issue.issueId}">edit</a> </p> 
							</c:if>
							<c:if test="${issue.getClass().name=='model.Story'}">
								<p>Estimated points: ${issue.estimatedPoints} </p>
								<p>Status: ${issue.storyStatus} </p>
								<p>Created on: <span class="timestamp"> <fmt:formatDate type="both" dateStyle="medium" timeStyle="short" value="${issue.creationDate}" /> </span>  |  <a class="editLink" href="../story/${issue.issueId}">edit</a> </p> 
							</c:if>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>