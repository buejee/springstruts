$(function(){
	$("#upload").on("change",function(e){
		var path = "/test";
		$.ajaxFileUpload({
			url:config.url+"/upload/upload!save.action",
			secureuri:true,
			fileElementId:"upload",
			dataType:"json",
			data:{path:path},
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