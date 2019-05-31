$(document).ready(function(){

	var url="echarts/echarts.do?t="+Math.random(1000);
	$("#container").load(url);
});
$('#load-project-id').click(function(){
	var url="project/listUI.do?t="+Math.random(1000);
	$("#container").load(url);
})
$('#load-team-id').click(function(){
	var url="Team/listUI.do?t="+Math.random(1000);
	$("#container").load(url);
})
$('#load-type-id').click(function(){
	var url="productType/listUI.do?t="+Math.random(1000);
	$("#container").load(url);
})
$('#load-projectIndex-id').click(function(){
	var url="echarts/echarts.do?t="+Math.random(1000);
	$("#container").load(url);
})