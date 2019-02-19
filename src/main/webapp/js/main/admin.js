$(function(){
	$("#upload").on("change",function(e){
		var path = "/test";
		var data = new FormData(document.getElementById("upload-form"));
		console.log(data);
		$.ajax({
			url:config.url+"/upload/upload!save.action",
			type:"post",
			data:data,
			contentType:false,
			processData:false,
			beforeSend:function(){
				console.log("before send");
			},
			xhr:function(){
				var xhr = $.ajaxSettings.xhr();
				if(xhr&&xhr.upload){
					xhr.upload.onprogress = function(e){
						var percent = e.loaded/e.total;
						console.log(percent);
					}
				}
				return xhr;
			},
			success:function(data,status){
				console.log("upload ok:"+data);
			},
			error:function(data,status,error){
				console.log("upload error:"+error);
			}
		});
		return false;
	});
});