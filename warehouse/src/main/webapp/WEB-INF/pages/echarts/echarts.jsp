<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<div style="height: 100%; width: 100%;">
	<div style="height: 30%; width: 25%;float: left;border:1px solid #878787;border-right:0px">
		<div style="height: 15%; width: 100%;">
		   <ol class="breadcrumb">
			<li>维修管理</li>
			<li class="active">维修统计</li>
			<li><span id="breadcrumbId"></span></li>
		   </ol>
		</div>
		<div id="echarts" style="height: 85%; width: 100%;"></div>
	</div>
	<div style="height: 30%; width: 25%;border:1px solid #878787;float: left;border-right:0px">
		<div style="height: 15%; width: 100%;">
			 <ol class="breadcrumb">
			  <li>维修管理</li>
			  <li class="active">维修统计信息</li>
			  <li><span id="breadcrumbId1"></span></li>
		    </ol>
		</div>
		<div id="echarts1"  style="height: 85%; width: 100%;"></div>
	</div>
	<div style="height: 30%; width: 25%;border:1px solid #878787;float: left;border-right:0px">
		<div style="height: 15%; width: 100%;">
			 <ol class="breadcrumb">
			  <li>维修管理</li>
			  <li class="active">维修统计信息</li>
			  <li><span id="breadcrumbId2"></span></li>
		    </ol>
		</div>
		<div id="echarts2"  style="height: 85%; width: 100%;"></div>
	</div>
	<div style="height: 30%; width: 25%;float: left;border:1px solid #878787;border-right:0px">
		<div style="height: 15%; width: 100%;">
		   <ol class="breadcrumb">
			<li>维修管理</li>
			<li class="active">维修统计信息</li>
			<li><span id="breadcrumbId"></span></li>
		   </ol>
		</div>
		<div id="echarts3" style="height: 85%; width: 100%;"></div>
	</div>
	<div style="height: 30%; width: 25%;float: left;border:1px solid #878787;border-top: 0px">
		<div style="height: 15%; width: 100%;">
		   <ol class="breadcrumb">
			<li>维修管理</li>
			<li class="active">维修统计信息</li>
			<li><span id="breadcrumbId"></span></li>
		   </ol>
		</div>
		<div id="echarts4" style="height: 85%; width: 100%;"></div>
	</div>
</div>
<script type="text/javascript" src="${basePath}/js/echarts/echarts.js"></script>

