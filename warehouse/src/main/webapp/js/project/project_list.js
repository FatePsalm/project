$(document).ready(function(){
	$("#queryFormId").on("click",".btn-search",doGetObjects);	
	$("#queryFormId").on("click",".btn-add,.btn-update",showEditDialog);
	$("#queryFormId").on("click",".btn-reset",ResetSearch);
	$("#queryFormId").on("click",".btn-particular",showEditDialog);
//页面加载完成执行此方法
//1.发起ajax请求(findObjects.do)
//2.将返回的结果填充到content位置
  doGetDepartmentMen();
  doGetObjects();
});

//重置查询
function ResetSearch(){
	console.log('重置按钮');
	$("#start_timeId").val('');
	$("#end_timeId").val('');
	$("#searchNameId").val('');
	$("#searchSend_peopleId option[value='']").prop("selected","selected");
	$("#searchSchoolId").val('');
	$("#searchValidId option[value='3']").prop("selected","selected");
	doGetObjects();
}
//查询送修人下拉菜单
function doGetDepartmentMen(){
	var url="department/doGetDepartment.do";
	$.post(url,function(result){
		$("#searchSend_peopleId").prepend('<option value="">送修人</option>')
		for (var i = result.length - 1; i >= 0; i--) {
			$("#searchSend_peopleId").prepend('<option value="' +result[i].department_name+ '">' + result[i].department_name + '</option>')
		};
	});
}
//获取数据库内人员名单填充到表格
function doGetDepartment(){
	var url="department/doGetDepartment.do";
	$.post(url,function(result){
			  $("#nameId").prepend('<option value="未领取">未领取</option>')
		for (var i = result.length - 1; i >= 0; i--) {
			  //console.log('名字='+result[i].department_name);
			  $("#school_nameId").prepend('<option value="' + result[i].department_name + '">' + result[i].department_name+'" "短号:'+result[i].department_phoneCornet + '</option>')
			  $("#send_peopleId").prepend('<option value="' + result[i].department_name + '">' + result[i].department_name + '</option>')
			  $("#nameId").prepend('<option value="' +result[i].department_name+ '">' + result[i].department_name + '</option>')
		};
	});
}

//显示编辑模态框
function showEditDialog(){
	var url="project/editUI.do";
	var title;
	if($(this).hasClass("btn-add")){
		title="添加维修记录"
	}
	if($(this).hasClass("btn-update")){
		title="修改维修记录"
		//将要修改的记录的id值绑定到模态框上
		//目的时通过一个模块实现添加或更新操作
		$("#modal-dialog").data("id",
		$(this).parent().parent().data("id"));//
	}
	if($(this).hasClass("btn-particular")){
		title="维修记录详情"
		//将要修改的记录的id值绑定到模态框上
		//目的时通过一个模块实现添加或更新操作
			$("#modal-dialog").data("id",
			$(this).parent().parent().data("id"));
			$("#modal-dialog").data("btn-particular",1);
			$("#particularId").attr('disabled','disabled');
	}
	//在模态框的.moday-body位置异步加载url
	$("#modal-dialog .modal-body").load(url,
			function(){//加载完成执行此
		 $(".modal-title").html(title);
		 $("#modal-dialog").modal("show");
		 doGetDepartment();
	})
	
}

//获取项目信息
function doGetObjects(){
  var params=getQueryFormData();
  var pageCurrent=$("#pagination").data("pageCurrent");
  if(pageCurrent){params.pageCurrent=pageCurrent};
  //console.log(params);
  var url="project/doFindPageObjects.do";//findPageObject(Project project,PageObject object)
  $.post(url,params,function(result){//map{"list":[{},{}],"pageObject":{"pageCount":2,...}}
	  //console.log(result.list);
	  //console.log(result.pageObject);
	  console.log(result.cost);
	  /**填充表单*/
	  setTableRows(result.list,result.cost);
	  /**设置分页*/
	  setPagination(result.pageObject);
	  /**获取当前页面不越界*/
	  getPageCurrent();
  });
}
//获得查询表单中的数据
function getQueryFormData(){
	var params={
	"start_time":$("#start_timeId").val(),
	"end_time":$("#end_timeId").val(),
	"type":$("#searchNameId").val(),
	"send_people":$("#searchSend_peopleId").val(),
	"school":$("#searchSchoolId").val(),
	"result":$("#searchValidId").val(),
	}
	return params;
}
//获取项目
//将从服务端获得的列表数据填充的表格中
function setTableRows(list,cost){
	$('#getSumCost').html('SUM('+cost+')RMB');
	 var tBody=$('#tbodyId');
	 tBody.empty();
	 var temp='<td><span value="[ProjectId]">[id]</span></td>'
	       +'<td>[maintain_time]</td>'
	       +'<td>[type]</td>'
	       +'<td>[number]</td>'
	       +'<td>[unit]</td>'
	       +'<td>[malfunction]</td>'
	       +'<td>[cost]</td>'
	       +'<td>[send_people]</td>'
	       +'<td>[result]</td>'
	       +'<td>[school]</td>'
	       +'<td><input type="button"  class="btn btn-success btn-particular" value="详细">'
	       +'<span> </span><input type="button"  class="btn btn-success btn-update" value="修改"></td>'
		   //追加新的数据
	       var costs;
		 for(var i in list){//循环一次取一行数据(对应一对tr对象)
		  var tr=$('<tr></tr>');//创建一对tr对象
		  tr.data("id",list[i].id);//绑定数据,便于后续获得此数据进行修改等操作
          tr.append(temp
        		  	 .replace('[ProjectId]',list[i].id)
        		  	 .replace('[id]',eval(i)+1)
        	         .replace('[maintain_time]',list[i].maintain_time)		        
        	         .replace('[type]',list[i].type)
        	         .replace('[number]',list[i].number)
        	         .replace('[unit]',list[i].unit)
        			 .replace('[malfunction]',list[i].malfunction)
        			 .replace('[cost]',list[i].cost)
        			 .replace('[send_people]',list[i].send_people)
        	         .replace('[result]',list[i].result?'完成':'未完成')
        	         .replace('[school]',list[i].school)
        	          );
         tBody.append(tr);//将tr对象追加tbody
		 }
}









