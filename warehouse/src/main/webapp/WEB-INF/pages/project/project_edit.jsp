<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
//初始化datepicker对象
$('.datepicker').datepicker({
	language:"zh-CN",
    format: 'yyyy-mm-dd',
    autoclose: true//选中自动关闭
})
</script>

<form  class="form-horizontal" role="form" id="editFormId">
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">送修时间:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker required" name="maintain_time" id="maintain_timeId" placeholder="请输入送修时间">
		</div>
	</div>
	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >品牌型号:</label> 
	    <div class="col-sm-10">
			<input type="text" class="form-control required"  maxlength="12" name="type" id="typeId"  placeholder="请输入品牌型号">
	    </div>
	</div>
	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >数量:</label> 
	    <div class="col-sm-10">
			<input type='text' class="form-control required" maxlength="3" name="number" id="numberId"  placeholder="请输入数量" onkeyup="this.value=this.value.replace(/[^0-9]+/,'');" />
	    </div>
	</div>
	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >单位:</label> 
	    <div class="col-sm-10">
	   		<select class="form-control required" name="unit" id="unitId">
	   			<option>台</option>
	   			<option>个</option>
	   			<option>套</option>
	   		</select>
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">故障现象:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" maxlength="16" name="malfunction" id="malfunctionId" placeholder="请输入故障现象">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">序列号:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control" name="keyId" id="keyId"  maxlength="18" placeholder="请输入序列号">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">项目学校:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control required" name="school" id="schoolId"  maxlength="10" placeholder="请输入项目学校">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">联系人:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control"  name="school_teachr" id="school_teachrId"  maxlength="4" placeholder="请输入项目/学校联系人">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">联系电话:</label> 
		<div class="col-sm-10">
		<input type='text' class="form-control" name="school_phone" id="school_phoneId" placeholder="请输入项目/学校联系电话" maxlength="11" onkeyup="this.value=this.value.replace(/[^0-9]+/,'');" />
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">入库时间:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker required "  name="school_time" id="school_timeId" placeholder="请输入入库时间">
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">入库人员:</label> 
		<div class="col-sm-10">
		<select class="form-control required "  name="school_name" id="school_nameId"></select>
		</div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">送修人员:</label> 
		<div class="col-sm-10">
		<select class="form-control required "  name="send_people" id="send_peopleId"></select>
		</div>
	</div>
	<div class="form-group">
         <label class="col-md-2 control-label"> 维修结果: </label>
         <div class="col-md-10">
            <label class="radio-inline"><input  type="radio" name=result checked value="1" >已修好</label>
            <label class="radio-inline"><input  type="radio" name="result" value="0"> 未修好</label>
          </div>
    </div>
	<div class="form-group">
		<label for="project-code"  class="col-sm-2 control-label">维修取货时间:</label> 
		<div class="col-sm-10">
		<input type="text" class="form-control datepicker " name="result_time" id="result_timeId" placeholder="请输入维修取货时间">
		</div>
	</div>
	<div class="form-group">
		<label for="nameId" class="col-sm-2 control-label" >维修金额:</label> 
	    <div class="col-sm-10">
	    	<input type='text' value="0" class="form-control required" name="cost" id="costrId" maxlength="8"  onkeyup="this.value=this.value.replace(/[^0-9.]+/,'');" />
	    </div>
	</div>
	<div class="form-group">
		<label for="project-code" class="col-sm-2 control-label">领取人员:</label> 
		<div class="col-sm-10">
		<select class="form-control required "  name="name" id="nameId"></select>
		</div>
	</div>
	<div class="form-group">
		<label for="noteId" class="col-sm-2 control-label">备注:</label>
		<div class="col-sm-10">
		<textarea class="form-control" name="remark" id="remarkId"></textarea>
		</div> 
	</div>
</form>
<c:url var="url" value="/js/project/project_edit.js"></c:url>
<script type="text/javascript" src="${url}"></script>