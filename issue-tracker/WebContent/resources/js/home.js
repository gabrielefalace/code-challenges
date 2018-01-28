$(document).ready(function(){
	
	// shows proper fields for entering a story
	$("#story_btn").click(function(){
		removeErrorStyle();
		$("#createStoryBox").show();
		$("#createBugBox").hide();
	});
	
	// shows proper fields for entering a bug
	$("#bug_btn").click(function(){
		removeErrorStyle();
		$("#createStoryBox").hide();
		$("#createBugBox").show();
	});
	
	// making bugs shown first by default
	$("#bug_btn").click();
	
	// coloring stories=green and bugs=light blue
	$(".issueBox:contains('Estimated points')").css("background-color", "#00CC66");
});