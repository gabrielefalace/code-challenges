<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="../js/home.js"></script>
		<script type="text/javascript" src="../js/inputCheck.js"></script>
		<link rel="stylesheet" href="../css/style.css">
		<title>Issue Tracker</title>
	</head>
	<body>

		<c:if test="${retrievedIssue.getClass().name == 'model.Bug'}">
			<h1> Update a Bug </h1> 
			<div id="createBugBox">
				<sf:form id="createBugForm" method="POST" modelAttribute="retrievedIssue" action="../bug">
					
					<%-- id and timestamp need to be preserved on updates: --%>
					<sf:hidden path="issueId" value="${retrievedIssue.issueId}"/>
					
					
					<sf:label path="title">Title</sf:label> <br/>
					<sf:input path="title" id="bugTitleText" /> <br/>
					<div id="bugTitleError"></div>
						
					<sf:label path="description">Description</sf:label> <br/>
					<sf:textarea path="description" id="bugDescriptionText" rows="5" cols="30" /> <br/>
					<div id="bugDescriptionError"></div>
						
					<sf:label path="developer">Developer</sf:label> <br/>
					<sf:select path="developer" items="${developers}"/> <br/>
						
					<sf:label path="priority">Priority</sf:label> <br/>
					<sf:select path="priority" items="${priorities}"/> <br/>
						
					<sf:label path="bugStatus">Status</sf:label> <br/>
					<sf:select path="bugStatus" items="${bugStatusList}"/> <br/>
		
					<input type="submit" value="Update" class="submitButton">
				</sf:form>
			</div>
		</c:if>
	
		<c:if test="${retrievedIssue.getClass().name == 'model.Story'}">
			<h1> Update a Story </h1> 
			<div id="createBugBox">
				<sf:form id="createStoryForm" method="POST" modelAttribute="retrievedIssue" action="../story">
				
					<%-- id and timestamp need to be preserved on updates: --%>
					<sf:hidden path="issueId" value="${retrievedIssue.issueId}"/>
					
					
					<sf:label path="title">Title</sf:label> <br/>
					<sf:input path="title" id="storyTitleText" /> <br/>
					<div id="storyTitleError"></div>
						
					<sf:label path="description">Description</sf:label> <br/>
					<sf:textarea path="description" id="storyDescriptionText" rows="5" cols="30" /> <br/>
					<div id="storyDescriptionError"></div>
						
					<sf:label path="developer">Developer</sf:label> <br/>
					<sf:select path="developer" items="${developers}"/> <br/>
						
					<sf:label path="estimatedPoints">Estimated points</sf:label> <br/>
					<sf:input path="estimatedPoints" id="pointsText" /> <br/>
					<div id="pointsError"></div>
						
					<sf:label path="storyStatus">Status</sf:label> <br/>
					<sf:select path="storyStatus" items="${storyStatusList}"/> <br/>
					<input type="submit" value="Update" class="submitButton">
				</sf:form>
			</div>
		</c:if>

		
	</body>
</html>