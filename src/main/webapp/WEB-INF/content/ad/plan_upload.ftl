<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>plan</title>
		<link rel="stylesheet" type="text/css" href="${base}/css/base.css"/>
		<link rel="stylesheet" type="text/css" href="${base}/css/public.css"/>
	</head>
	<body>
	   <div id="container">
		      <#include "../common/header.html">
		      <div class="content">
		            <#include "../common/menu.html"/>
		            <section class="grid-right">
		                <article class="table-list clearfix">
		                    <div class="list-head">
							    <h2>查询条件</h2>
								<div class="searchbox clearfix">
								   <form name="search-form">
								       <input type="hidden" name="searchBy" value="task_name"/>								   							   
									   <label>广告名称：</label><input type="text" name="keyword"/>
									   <!--  
									   <label>开始日期：</label><input type="date" name="task_startdate"/>
									   <label>结束日期：</label><input type="date" name="task_enddate"/>
									   -->
									   <input type="button" value="查询" class="btn btn-primary" id="searchBtn"/>
									   <a class="btn-add fr" href="${base}/ad/edit/">新建广告<span class="icon icon-add"></span></a>
									   <!--  
									   <a class="btn-add fr" id="batchImportBtn">批量上传</a>
									   -->
								   </form>
								</div>
							</div>
		                    <div class="list-body">
		                           <div id="page-info" class="page-info"></div>
		                           <ul class="table-head">
		                                <li class="list-item">
		                                   <span class="head-column col-small"><input type="checkbox" id="checkall"/>全选</span>
		                                   <span  class="head-column col-xx-large">ID</span>
		                                   <span  class="head-column col-normal">广告名称</span>
		                                   <span  class="head-column col-large">开始时间</span>
		                                   <span  class="head-column col-large">结束时间</span>
		                                   <span  class="head-column col-small">状态</span>
		                                   <span  class="head-column col-x-large">操作</span>
		                                 </li>
		                            </ul>
		                            <ul class="table-body" id="ad-list-wrap">
		                                <li class="list-item">
		                                   <div class="loading tc">正在加载</div>
		                                </li>
		                            </ul>
		                            <div class="delete-wrap"><a class="btn" id="deleteByIdsBtn">删除</a></div>
		                    </div>
		                    <div id="pager-wrap"></div>
		                </article>
		            </section>
		      </div>
		      <#include "../common/footer.html"/>
		 </div>
	   
	</body>
	<#include "../common/dialog.html"/>
    <#include "../common/config.html"/>
	<script type="text/javascript" src="${base}/js/libs/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="${base}/js/libs/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${base}/js/libs/template.js"></script>
	<script type="text/javascript" src="${base}/js/common/utils.js"></script>
</html>