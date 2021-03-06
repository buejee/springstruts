<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>文件列表</title>
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
									   <label>文件名称：</label><input type="text" name="keyword"/>
									   <!--  
									   <label>开始日期：</label><input type="date" name="task_startdate"/>
									   <label>结束日期：</label><input type="date" name="task_enddate"/>
									   -->
									   <input type="button" value="查询" class="btn btn-primary" id="searchBtn"/>
									   <a class="btn-add fr" href="${base}/ad/plan!upload">新建上传<span class="icon icon-add"></span></a>
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
		                                   <span  class="head-column col-normal">文件名称</span>
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
	<script type="text/template" id="list-item-template">
     {{each list as item}}
        <li class="list-item">
             <span class="head-column col-small"><input type="checkbox" id="{{item.id}}" name="ids"/></span>
             <span class="head-column col-xx-large">{{item.id}}</span>
             <span class="head-column col-normal">{{item.name}}</span>
             <span class="head-column col-x-large">
                   <a class="item-delete" data-id="{{item.id}}">下载</a>
				   <a href="http://127.0.0.1:8080/springstruts/ad/plan!download.action?fileName={{item.name}}">download</a>
             </span>
        </li>
      {{/each}}
    </script>
    <#include "../common/pager.html"/>
    <#include "../common/dialog.html"/>
    <#include "../common/config.html"/>
	<script type="text/javascript" src="${base}/js/libs/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="${base}/js/libs/ajaxfileupload.js"></script>
	<script type="text/javascript" src="${base}/js/libs/template.js"></script>
	<script type="text/javascript" src="${base}/js/common/utils.js"></script>
	<script type="text/javascript" src="${base}/js/common/table_list.js"></script>
	<script type="text/javascript" src="${base}/js/ad/ad_list.js"></script>
</html>