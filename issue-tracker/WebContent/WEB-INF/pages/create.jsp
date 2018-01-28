<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

	<h1>Create new Issue</h1>


	<div id="switch">
		<span id="bug_btn" class="button"> Bug </span>
	
		<span id="story_btn" class="button"> Story </span>
	</div>


	<div id="createBugBox">
		<h3>Create a new Bug</h3>
	
		<sf:form id="createBugForm" method="POST" modelAttribute="bug" action="../bug">
			<sf:label path="title">Title</sf:label> <br/>
			<sf:input id="bugTitleText" path="title" /> <br/>
			<div id="bugTitleError"></div>
				
			<sf:label path="description">Description</sf:label> <br/>
			<sf:textarea id="bugDescriptionText" path="description" rows="5" cols="30" /> <br/>
			<div id="bugDescriptionError"></div>
				
			<sf:label path="developer">Developer</sf:label> <br/>
			<sf:select path="developer" items="${developers}"/> <br/>
				
			<sf:label path="priority">Priority</sf:label> <br/>
			<sf:select path="priority" items="${priorities}"/> <br/>

			<sf:hidden path="bugStatus" value="NEW"/>

			<input type="submit" value="Create" class="submitButton">

		</sf:form>
	</div>


	<div id="createStoryBox" class="nonVisible">
		<h3>Create a new Story</h3>
		
		<sf:form id="createStoryForm" method="POST" modelAttribute="story" action="../story">
				
			<sf:label path="title">Title</sf:label> <br/>
			<sf:input id="storyTitleText" path="title" /> <br/>
			<div id="storyTitleError"></div>
			
			<sf:label path="description">Description</sf:label> <br/>
			<sf:textarea id="storyDescriptionText" path="description" rows="5" cols="30" /> <br/>
			<div id="storyDescriptionError"></div>
				
			<sf:label path="developer">Developer</sf:label> <br/>
			<sf:select path="developer" items="${developers}"/> <br/>
				
			<sf:label path="estimatedPoints">Estimated points</sf:label> <br/>
			<sf:input id="pointsText" path="estimatedPoints" />
			<div id="pointsError"></div>
			
			<sf:hidden path="storyStatus" value="NEW"/>
			
			<input type="submit" value="Create" class="submitButton">
		</sf:form>
	</div>

</body>
</html>