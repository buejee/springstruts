<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>admin</title>
		<link rel="stylesheet" type="text/css" href="${base}/css/base.css"/>
		<link rel="stylesheet" type="text/css" href="${base}/css/public.css"/>
		<link rel="stylesheet" type="text/css" href="${base}/css/font/iconfont.css"/>
	</head>
	<body>
	   <div id="container">
		      <#include "../common/header.html">
		      <div class="content">
		            <#include "../common/menu.html"/>
		            <section class="grid-right">
		                <article class="table-list clearfix">
		                    <div class="list-head">
								<div class="anticon searchbox clearfix">
								       <form name="search-form">
									       <div class="search-wrap fr">
										   		<input type="text" name="keyword" class="" id="search"/>
										   </div>
									   </form>
									   <div class="disk-tool fl">
									       <form id="upload-form" method="post" enctype="multipart/form-data">
										       <div class="upload-wrap">
										       		<input id="upload" class="file-ele" type="file" name="upload" />
										       		<div class="btn-upload"><em class="icon icon-upload"></em>&nbsp;上传</div>									       		
										       </div>
										       <div class="btn-create-folder"><em class="icon icon-addfolder"></em>&nbsp;新建文件夹</div>
									       </form>	       
									   </div>
								</div>
							</div>
		                    <div class="list-body">
		                           <div id="page-info" class="page-info"></div>
		                           <ul class="table-head">
		                                <li class="list-item">
		                                   <span class="head-column col-small"><input type="checkbox" id="checkall"/>全选</span>
		                                   <span  class="head-column col-xx-large">名称</span>
		                                   <span  class="head-column col-normal">大小</span>
		                                   <span  class="head-column col-large">创建时间</span>
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
             <span class="head-column col-xx-large">{{item.name}}</span>
             <span class="head-column col-normal">{{item.size}}</span>     
             <span class="head-column col-large">{{item.create_date | xx:'yyyy-MM-dd hh:mm:ss'}}</span>
             <span class="head-column col-x-large">
                   <a class="item-edit" href="${base}/ad/edit?id={{item.id}}">重命名</a>
                   <a class="item-download" data-id="{{item.id}}">下载</a>
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
	<script type="text/javascript" src="${base}/js/common/accordion.js"></script>
	<script type="text/javascript" src="${base}/js/main/admin.js"></script>
</html>