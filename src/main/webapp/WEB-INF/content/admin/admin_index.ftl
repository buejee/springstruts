<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>admin</title>
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
	<script type="text/template" id="list-item-template">
     {{each list as item}}
        <li class="list-item">
             <span class="head-column col-small"><input type="checkbox" id="{{item.id}}" name="ids"/></span>
             <span class="head-column col-xx-large">{{item.id}}</span>
             <span class="head-column col-normal">{{item.task_name}}</span>     
             <span class="head-column col-large">{{item.task_startdate | xx:'yyyy-MM-dd hh:mm:ss'}}</span>
             <span class="head-column col-large">{{item.task_enddate | xx:'yyyy-MM-dd hh:mm:ss'}}</span>
             <span class="head-column col-small">{{item.task_status | taskStatusFilter }}</span>
             <span class="head-column col-x-large">
                   <a class="item-edit" href="${base}/ad/edit?id={{item.id}}">编辑</a>
                   <a class="item-open" data-id="{{item.id}}">查看</a>
                   {{if item.task_status=='01'}}
                      <a class="item-dostream" data-id="{{item.id}}">投放</a>
                   {{/if}}
                   {{if item.task_status=='02'}}
                      <a class="item-pause" data-id="{{item.id}}">暂停</a>
                      <a class="item-done" data-id="{{item.id}}">完成</a>
                   {{/if}}
                   <a class="item-delete" data-id="{{item.id}}">删除</a>
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
	<script type="text/javascript" src="${base}/js/main/ad_list.js"></script>
</html>