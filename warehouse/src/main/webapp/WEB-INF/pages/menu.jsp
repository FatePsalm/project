<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix= "c" %> 
<c:set var="basePath" value="${pageContext.request.contextPath}"></c:set>
<div class="navbar navbar-inverse" role="navigation" style="cursor: pointer;">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#example-navbar-collapse">
				<span class="sr-only">切换导航</span> <span class="icon-bar"></span> 
				<span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><span style="font-size: 15px;">成都伟航</span></a>
		</div>
		<div class="collapse navbar-collapse" id="example-navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a class="icon-bar" href="#" id="load-projectIndex-id">仓库管理系统</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">维修管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li role="separator" class="divider"></li>
						<li><a id="load-project-id">维修信息</a></li>
					</ul></li>
					
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">物流管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li role="separator" class="divider"></li>
						<li><a id="load-project-id">物流信息</a></li>
						<li role="separator" class="divider"></li>
						<li><a id="load-project-id">发货信息</a></li>
					</ul></li>
			
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">系统管理 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li role="separator" class="divider"></li>
						<li><a id="load-org-id">组织管理</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">角色管理</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">权限管理</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">用户管理</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a>欢迎您,admin</a></li>
				<li><a href="#">安全退出</a></li>
			</ul>
		</div>
	</div>
</div>
<script type="text/javascript" src="${basePath}/js/system/menu.js"></script>
