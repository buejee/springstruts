$(function(){
	$.ajax({
		url:config.url+"/ad/plan!getList.action",
		type:"GET",
		success:function(data){
			if(data){
				var arr = data.data;
				arr = arr.map(function(item,index){
					return {name:item,id:index+1};
				});
				var res = template("list-item-template",{list:arr});
				$("#ad-list-wrap").html(res);
			}
		},
		error:function(data,status,error){
			console.log(error);
		}
	});
	
	$("#ad-list-wrap").on("click",".item-delete",function(e){
		//window.open("http://127.0.0.1:8080/springstruts/uploads/icon.png");
		/*
		var form = document.createElement("form");
		form.method = "get";
		form.action="http://127.0.0.1:8080/springstruts/uploads/icon.png";
		document.body.appendChild(form);
		form.submit();*/
		
		/*
		var iframe = document.createElement("iframe")
	    iframe.style.display = "none";
	    iframe.src = "http://127.0.0.1:8080/springstruts/uploads/icon.png";
	    document.body.appendChild(iframe);*/
	    
		var src = "http://127.0.0.1:8080/springstruts/uploads/icon.png";
	    var eleLink = document.createElement('a');
	    eleLink.download = src;
	    eleLink.style.display = 'none';
	    // // 字符内容转变成blob地址
	    eleLink.href = src;
	    // // 触发点击
	    document.body.appendChild(eleLink);
	    eleLink.click();
	    // // 然后移除
	    document.body.removeChild(eleLink);
	});
});