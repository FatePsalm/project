$(document).ready(function(){
	$("#modal-dialog").on('click','.ok',doSaveOrUpdate);
	//获得模态框上绑定的id值
	var id=$("#modal-dialog").data("id");
	//console.log("id="+id);
	//假如id有值,说明这是修改,然后根据id获得对象,初始化模态框数据
	if(id)doGetObjectById(id);
	//当模态框隐藏时在.ok上绑定的事件执行解绑动作
	$("#modal-dialog").on("hidden.bs.modal",function() {
		$(this).off('click', '.ok').removeData("id")
	});
	/**解绑详细数据以便于添加和修改正常保存*/
	$("#modal-dialog").on("hidden.bs.modal",function() {
		$(this).off('click', '.ok').removeData("btn-particular")
		$("#particularId").removeAttr('disabled');
	});
})



//根据id查找project对象
function doGetObjectById(id){
	var url="project/doFindById.do";
	var params={"id":id};
	$.post(url,params,function(result){
		//console.log(result);
		doFillFormData(result);
	});
}

//将获得的数据填充到form表单中
function doFillFormData(obj){
	$("#maintain_timeId").val(obj.maintain_time);
	$("#modal-dialogId").data("obj.modal-dialog");
	$("#maintain_timeId").val(obj.maintain_time);
	$("#typeId").val(obj.type);
	$("#numberId").val(obj.number);
	$("#unitId").val(obj.unit);
	$("#malfunctionId").val(obj.malfunction);
	$("#keyId").val(obj.keyId);
	$("#costrId").val(obj.cost);
	$("#send_peopleId option[value='"+obj.send_people+"']").attr("selected","selected");
	$("#result_timeId").val(obj.result_time);
	$("#nameId option[value='"+obj.name+"']").attr("selected","selected");
	$("#nameId").val(obj.name);
	$("#school_nameId option[value='"+obj.school_name+"']").attr("selected","selected");
	$("#schoolId").val(obj.school);
	$("#school_timeId").val(obj.school_time);
	$("#school_teachrId").val(obj.school_teachr);
	$("#school_phoneId").val(obj.school_phone);
	$("#remarkId").html(obj.remark);
	//完成和未完成
	$('#editFormId input[name="result"]').each(function(){
		if($(this).val()==obj.result){
			$(this).prop("checked",true);
		}
	})
	
}
//保存或更新数据
function doSaveOrUpdate(){
	if($("#editFormId").valid()){//required
	//1.获得表单数据
	var params=doGetEditFormData();
	//2.将数据提交到服务端
	var id=$("#modal-dialog").data("id");
	var particular=$("#modal-dialog").data("btn-particular");
	if(particular==1){//particular==1时则是查看详细不保存记录
		//1)隐藏模态框
		$("#modal-dialog").modal("hide");
	}else{//particular没有值则是添加或者修改
		var url=id?"project/doUpdateProject.do":"project/doSaveProject.do";
		$.post(url,params,function(result){
			//1)隐藏模态框
			$("#modal-dialog").modal("hide");
			//2)重新查询列表数据
			doGetObjects();
			console.log("保存或者更新成功!");
		})
	}
	}
}
//获得表单数据
function doGetEditFormData(){
	var params={
			
			"id":$("#modal-dialog").data("id"),//更新时需要
			"maintain_time":$("#maintain_timeId").val(),
			"type":$("#typeId").val(),
			"number":$("#numberId").val(),
			"unit":$("#unitId").val(),
			"malfunction":$("#malfunctionId").val(),
			"keyId":$("#keyId").val(),
			"cost":$("#costrId").val(),
			"send_people":$("#send_peopleId").val(),
			"result":$('input[name="result"]:checked').val(),
			"result_time":$("#result_timeId").val(),
			"name":$("#nameId").val(),
			"school_name":$("#school_nameId").val(),
			"school":$("#schoolId").val(),
			"school_time":$("#school_timeId").val(),
			"school_teachr":$("#school_teachrId").val(),
			"school_phone":$("#school_phoneId").val(),
			"remark":$('#remarkId').val()};
			
	//检测获得的结果
	//console.log(JSON.stringify(params));
	return params;
}

