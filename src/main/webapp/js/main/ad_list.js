/**
 * 
 */
$(function(){
	var table = new TableList("list-item-template",{ele:'ad-list-wrap',url:config.url+'/ad/pager'});
	//处理搜索
	$("#searchBtn").on("click",function(e){
		var data = document.forms['search-form'];
		if(data.searchBy.value && data.keyword.value){
			table.searchBy = data.searchBy.value;
			table.keyword = data.keyword.value;
			table.requestData(table.render);
			return;
		}
	});
	//处理批量导入
	$("#batchImportBtn").on("click",function(e){
		Dialog.showUpload();
	});
	//处理查看报文
	$(".table-body").on("click",".item-open",function(e){
		var id = $(this).data("id");
		Dialog.showADInfo(id);
	});
	//删除前需要确认
	$(".table-body").on("click",".item-delete",function(e){
		var id = $(this).data("id");
		Dialog.open("confirm","确认删除吗?",function(){
			console.log("delete id -> "+id);
		});
	});
	$(".table-body").on("click",".item-dostream",function(e){
		var id = $(this).data("id");
		Dialog.open("confirm","确认投放吗?",function(){
			$.ajax({
				url:config.url+'/ad/dostream/'+id,
				type:'post',
				success:function(data){
					if(data.code==200){
						Dialog.toast("任务投放成功");
					}
				},
				error:function(error){
					Dialog.open("error","任务投放失败");
				}
			});
		});
	});
	//暂停任务
	$(".table-body").on("click",".item-pause",function(e){
		var id = $(this).data("id");
		Dialog.open("confirm","确认暂停吗?",function(){
			$.ajax({
				url:config.url+'/ad/pause/'+id,
				type:'post',
				success:function(data){
					if(data.code==200){
						Dialog.toast("任务暂停成功");
					}
				},
				error:function(error){
					Dialog.open("error","任务暂停失败");
				}
			});
		});
	});
	//任务完成
	$(".table-body").on("click",".item-done",function(e){
		var id = $(this).data("id");
		Dialog.open("confirm","确认完成吗?",function(){
			$.ajax({
				url:config.url+'/ad/done/'+id,
				type:'post',
				success:function(data){
					if(data.code==200){
						Dialog.toast("任务完成成功");
					}
				},
				error:function(error){
					Dialog.open("error","任务完成失败");
				}
			});
		});
	});
	//全选
	$("#checkall").on("click",function(e){
		var status = $(this).prop("checked");
		$("#ad-list-wrap").find("input[type='checkbox']").prop("checked",status);
	});
	//批量删除
	$("#deleteByIdsBtn").on("click",function(e){
		var ids = $("#ad-list-wrap").find("input[type='checkbox']").filter(function(index,item){
			var checked = $(item).prop("checked");
			return checked;
		}).map(function(index,item){
			return item.id;
		});
		//jquery 类数组-> javascript 数组
		//ids = [].slice.call(ids);
		//ids = Array.from(ids);
		ids = $.makeArray(ids);
		//如何传递数组对象到后台
		$.ajax({
			url:config.url+'/ad/deleteByIdsArray',
			data:{ids:ids},
			type:'post',
			traditional:true,
			success:function(data){
				if(data.code==200){
					Dialog.toast("任务删除成功");
				}
			},
			error:function(error){
				Dialog.open("error","任务删除失败");
			}
		});
	});
});