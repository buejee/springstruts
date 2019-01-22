/**
 * 日期转换工具方法
 */
var DateHelper = {
    formatDate:function(time,format){
    	var date = new Date(time);
        var map ={
            'M' : date.getMonth()+1,//month
            'd' : date.getDate(),//date
            'h' : date.getHours(),//hours
            'm' : date.getMinutes(),//minutes
            's' : date.getSeconds() //seconds
        };
        format = format.replace(/([yMdhms])+/g,function(all,t){
            var v = map[t];
            if(v!=undefined){
                 if(all.length>1){
                    v = '0'+v;
                    v = v.substr(v.length-2);
                 }
                 return v;
            }else if(t=='y'){
                return (date.getFullYear()+'').substr(4-all.length);
            }
            return all;
        });
       return format;
    }
};
/**
 * 对话框
 */
var Dialog = {
	open:function(type,message,callback){
		$("body").append(template("dialog-template",{type:type,message:message}));
		$("body").on("click",".dialog-buttons>.btn",function(e){
			$(".dialog,.mask").remove();
			if("confirm"==type&&callback&&$(this).hasClass("btn-primary")){
				callback.call(window);
			}
		});
	},
	toast:function(message){
		var tpl = "<div class='toast'>{{message}}</div>";
		$("body").append(template.compile(tpl)({message:message}));
		$(".toast").fadeOut(2000)
		setTimeout(function(){
			$(".toast").remove();
		},2200);
	},
	showADInfo:function(id){
		var self = this;
		var tpl = "<div class='dialog-large'><div class='dialog-title'>{{task_name}}</div>"+
		          "<div class='dialog-content'>"+
		          "<form name='adinfo-form'>" +
		          "<input type='hidden' name='id' value='{{id}}'/>"+
		          "<textarea name='sysmessagebody' cols='5'>{{sysmessagebody}}</textarea>"+
		          "</form>"+
		          "</div>"+
		          "<div class='dialog-buttons'>" +
		          "<input type='button' class='btn btn-primary' value='提交'/>" +
		          "<input type='button' class='btn btn-default' value='取消'/></div>"+
		          "</div><div class='mask'></div>";
		$.ajax({
			url:config.url+"/ad/"+id,
			type:'GET',
			success:function(data){
				if(data){
					$("body").append(template.compile(tpl)(data));
				}
			}
		});
		$("body").on("click",".dialog-buttons>.btn",function(e){
			if($(this).hasClass("btn-primary")){
				var params = $(document.forms['adinfo-form']).serialize();
				//保存，退出。
				$.ajax({
					url:config.url+"/ad/savesysmessagebody",
					type:'POST',
					data:params,
					success:function(data){
						if(data){
							self.toast("提交成功.")
							$(".dialog-large,.mask").remove();							
						}else{
							self.toast("提交失败.");
						}
					}
				});
			}
			if($(this).hasClass("btn-default")){
				$(".dialog-large,.mask").remove();
			}
		});
		
	},
	showUpload:function(){
		$("body").append(template("dialog-upload-template",{}));
		$("body").on("click",".dialog-buttons>.btn-default",function(e){
			$(".dialog,.mask").remove();
		});
		$("body").on("click",".dialog-buttons>.btn-primary",function(e){
			$.ajaxFileUpload({
				url:config.url+'/ad/upload',
				secureuri:true,
				fileElementId:'uploadfile',
				dataType:'json',
				success:function(data,status){
					if (typeof (data.error) != 'undefined') {
                        if (data.error != '') {
                            alert(data.error);
                        } else {
                            alert(data.msg);
                        }
                    }
				},
				error:function(data,status,error){
					Dialog.toast(error);
				}
			});
		});
	},
	move:function (){
		$(document).onmousedown(function(event){
			
		});
	}
}

template.helper("xx",DateHelper.formatDate);
template.helper("typeFilter",function(status){
	var res = "";
	switch(status){
		case "success":
			res="温馨";
			break;
		case "confirm":
			res="确认";
			break;
		case "error":
			res="错误";
			break;
		case "upload":
			res="上传";
		default:
			res="温馨";
			break;
	}	
	return res;
});

template.helper("taskStatusFilter",function(status){
	var res = "";
	switch(status){
		case "01":
			res="准备";
			break;
		case "02":
			res="投放";
			break;
		case "03":
			res="完成";
			break;
		case "06":
			res="暂停";
			break;
		default:
			res="准备";
			break;
	}
	return res;
});
//promise的使用
//特效的使用