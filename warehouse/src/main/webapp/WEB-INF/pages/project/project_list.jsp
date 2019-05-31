<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %> 
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>

<!-- 表单 -->
	<div class="container">
	   <!-- 页面导航 -->
	   <div class="page-header">
			<div class="page-title" style="padding-bottom: 5px">
				<ol class="breadcrumb">
				  <li>维修管理</li>
				  <li>维修信息</li>
				  <li class="active"><span id="getSumCost" style="color: red;"></span></li>
				</ol>
			</div>
			<div class="page-stats"></div>
		</div>
		<form method="post" id="queryFormId">
		    <!-- 查询表单 -->
			<div class="row page-search">
			 <div class="col-md-12">
				<ul class="list-unstyled list-inline">
					<li><input type="text" size="7" class="form-control datepicker required" name="start_time" id="start_timeId" placeholder="开始时间"></li>
					<li><input type="text" size="7" class="form-control datepicker required" name="end_time" id="end_timeId" placeholder="结束时间"></li>
					<li><input type="text" name="type" id="searchNameId" class="form-control"placeholder="品牌型号"></li>
					<li><select class="form-control" name="send_people" id="searchSend_peopleId"></select></li>
					<li><input type="text" name="school" id="searchSchoolId" class="form-control"placeholder="项目/学校"></li>
					<li><select name="result" id="searchValidId" class="form-control">
							<option value="3">选择状态</option>
							<option value="1">完成</option>
							<option value="0">未完成</option>
						</select></li>
					<li class='O1'><button type="button" class="btn btn-primary btn-search" >查询</button></li>
					<li class='O3'><button type="button" class="btn btn-primary btn-reset" >重置</button></li>
					<li class='O2'><button type="button" class="btn btn-primary btn-add">添加</button></li>
				</ul>
			  </div>
			</div>
			<!-- 列表显示内容 -->
			<div class="row col-md-12">
				<table class="table table-bordered" style="font-size:15px;">
					<thead>
						<tr>
							<th>序</th>
							<th>送修日期</th>
							<th>品牌型号</th>
							<th>数量</th>
							<th>单位</th>
							<th>故障情况</th>
							<th>费用</th>
							<th>送修人</th>
							<th>维修情况</th>
							<th>项目/学校</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="tbodyId"></tbody>
				</table>
				<%@include file="../common/page.jsp" %>
			</div>
		</form>
	</div>
<script type="text/javascript">
//初始化datepicker对象
$('.datepicker').datepicker({
	language:"zh-CN",
    format: 'yyyy-mm-dd',
    autoclose: true//选中自动关闭
})
</script>
<script src="${basePath}/js/common/page.js"></script>
<script type="text/javascript" src="${basePath}/js/project/project_list.js"></script>
