// global variable
MIN_TEXT = 5;

$(document).ready(function(){
	
	$("#createStoryForm").bind("submit", function(){
		removeErrorStyle();
		return checkStory();
	});
	
	$("#createBugForm").bind("submit", function(){
		removeErrorStyle();
		return checkBug();
	});
});

function checkStory(){
	var outcome = true;
	var title = $.trim($("#storyTitleText").val());
	var description = $.trim( $("#storyDescriptionText").val() );
	
	var estimatedPointsText = $.trim( $("#pointsText").val() );
	var estimatedPoints = parseFloat(estimatedPointsText);
	
	if(isNaN(estimatedPoints) || estimatedPoints <= 0){
		$("#pointsText").addClass("error");
		$("#pointsError").html("estimated points needs an integer bigger than 0").css("color", "red");
		outcome = false;
	}
	if(title.length < MIN_TEXT){
		$("#storyTitleText").addClass("error");
		$("#storyTitleError").html("Title cannot be empty - minimum length is 5").css("color", "red");
		outcome = false;
	}
	if(description.length < MIN_TEXT){
		$("#storyDescriptionText").addClass("error");
		$("#storyDescriptionError").html("Title cannot be empty - minimum length is 5").css("color", "red");
		outcome = false;
	}
	return outcome;
}


function checkBug(){
	var outcome = true;
	var title = $.trim($("#bugTitleText").val());
	var description = $.trim( $("#bugDescriptionText").val() );
	
	if(title.length < MIN_TEXT){
		$("#bugTitleText").addClass("error");
		$("#bugTitleError").html("Title cannot be empty - minimum length is 5").css("color", "red");
		outcome = false;
	}
	if(description.length < MIN_TEXT){
		$("#bugDescriptionText").addClass("error");
		$("#bugDescriptionError").html("Title cannot be empty - minimum length is 5").css("color", "red");
		outcome = false;
	}
	return outcome;
}


function removeErrorStyle(){
	// cleaning stories' fields
	$("#pointsText").removeClass("error");
	$("#pointsError").html("");
	$("#storyTitleText").removeClass("error");
	$("#storyTitleError").html("");
	$("#storyDescriptionText").removeClass("error");
	$("#storyDescriptionError").html("");
	
	// cleaning bugs' fields
	$("#bugTitleText").removeClass("error");
	$("#bugTitleError").html("");
	$("#bugDescriptionText").removeClass("error");
	$("#bugDescriptionError").html("");
}

