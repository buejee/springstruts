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
		                <div class="box">
		                	<form>
		                	      <div class="box-item">
		                	          <label>选择文件</label>
		                	          <input type="file" name="upload" id="upload"/>
		                	      </div>
		                	      <div class="box-item">
		                	      	  <input type="button" class="btn btn-primary" value="保存"/>
		                	      </div>
		                	</form>
		                </div>
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
	<script type="text/javascript">
	     $(function(){
	    	$(".btn-primary").click(function(e){
	    	    var path = "/";
	    		$.ajaxFileUpload({
	    			url:config.url+"/upload/upload!save.action",
	    			secureuri:true,
	    			fileElementId:"upload",
	    			dataType:"json",
	    			success:function(data,status){
	    				console.log("upload ok:"+data);
	    			},
	    			error:function(data,status,error){
	    				console.log("upload error:"+error);
	    			}
	    		})
	    		return false;
	    	});
	     });
	</script>
</html>