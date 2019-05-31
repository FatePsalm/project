<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %> 
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>

<!-- 表单 -->
	<div class="container">
	   <!-- 页面导航 -->
	   <div class="page-header">
			<div class="page-title" style="padding-bottom: 5px">
				<h3>旅游管理系统</h3>
				<ol class="breadcrumb">
				  <li>系统管理</li>
				  <li>菜单管理</li>
				  <li class="active">菜单信息管理</li>
				</ol>
			</div>
		</div>
		<form method="post" id="formHead">
		    <!-- 查询表单 -->
			<div class="row page-search">
			 <div class="col-md-12">
				<ul class="list-unstyled list-inline">
					<li class='O1'><button type="button" class="btn btn-primary btn_add">新增</button></li>
					<li class='O2'><button type="button" class="btn btn-primary btn_update">修改</button></li>
					<li class='O3'><button type="button" class="btn btn-primary btn_delete">删除</button></li>
				</ul>
			  </div>
			</div>
			<!-- 列表显示内容 -->
			<div class="row col-md-12">
				<table id="menuTable" data-click-to-select="true">
					<thead>
					<tr>
						<th data-field="selectItem" data-checkbox="true"></th>
					</tr>
					</thead>
				</table>
			</div>
		</form>
	</div>
<script type="text/javascript" src="${basePath}/js/system/menu_list.js"></script>