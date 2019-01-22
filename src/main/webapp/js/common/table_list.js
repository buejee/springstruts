/**
 * 
 */
var TableList = function(tplid,options){
	this.tplid = tplid;
	this.configs = $.extend({
		url:'',
		ele:'document'
	},options);
	this.pageSize = 10;
	this.currentPage = 1;
	this.pageCount = 1;
	this.searchBy = "";
	this.keyword = "";
	this.init();
};
TableList.prototype.init = function(){
	this.requestData(this.render);
	this.bindEvent();
};
TableList.prototype.requestData = function(callback){
	var params = {
		currentPage:this.currentPage,
		pageSize:this.pageSize
	};
	if(this.searchBy && this.keyword){
		params.searchBy = this.searchBy;
		params.keyword = this.keyword;
	}
	var self = this;
	$.ajax({
		url:self.configs.url,
		type:'GET',
		data:params,
		success:function(data){
			if(data&&data.totalCount>0){
				callback.call(self,data);
			}
		}
	});
};
TableList.prototype.render = function(data){
	if(data&&data.result){
		var innerHTML = template(this.tplid,{list:data.result});
		$("#"+this.configs.ele).html(innerHTML);
		/*currentPage:1
			keyword:null
			order:"asc"
			orderBy:null
			pageCount:3
			pageSize:10
			result:(10) [{…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}, {…}]
			searchBy:null
			totalCount:22*/
		//构建分页
		var pageCount = this.pageCount = data.pageCount,list=[],currentPage = data.currentPage;
		if(pageCount>1){
			//小于5页，最多展示5页
			if(pageCount<=5){
				for(i=1;i<=pageCount;i++){
					list.push(i);
				}
			}else{
				//currentPage所处的临界值
				if(pageCount-currentPage>5){
					for(i=currentPage;i<currentPage+5;i++){
						list.push(i);
					}
				}else{
					for(i=pageCount-5;i<=pageCount;i++){
						list.push(i);
					}
				}
			}
		}else{
			list = [1];
		}
		data.list = list;
		$("#pager-wrap").html(template("pager-template",data));	
		//设置分页数据信息 总共{{}}条记录，每页显示{{}}条
		var pageInfoHTML = template.compile("共{{totalCount}}条记录，每页显示{{pageSize}}条记录")(data);
		$("#page-info").html(pageInfoHTML);
		//控制分页是否可点击：
		$("#pager .icon").removeClass("icon-disabled");
		if(pageCount==1){
			$("#pager .icon").addClass("icon-disabled");		
		}else{
			if(currentPage==1){
				$("#pager .icon-pre").addClass("icon-disabled");
				$("#pager .icon-first").addClass("icon-disabled");
			}else if(currentPage==pageCount){
				$("#pager .icon-next").addClass("icon-disabled");
				$("#pager .icon-last").addClass("icon-disabled");			
			}
		}
	}	
};
TableList.prototype.bindEvent = function(){
	var self = this;
	//跳转页面
	$("#pager-wrap").on("click",".page-number",function(e){
		if($(this).hasClass("page-active"))return;
		self.currentPage = $(this).data("page");
		self.requestData(self.render);
	});
	//上一页，下一页，首页，尾页，刷新
	$("#pager-wrap").on("click",".icon",function(e){
		if($(this).hasClass("icon-disabled"))return;
		if($(this).hasClass("icon-first")){
			self.currentPage = 1;	
		}
		if($(this).hasClass("icon-pre")){
			self.currentPage -= 1;		
		}
		if($(this).hasClass("icon-next")){
			self.currentPage += 1;
		}
		if($(this).hasClass("icon-last")){
			self.currentPage = self.pageCount;
		}
		self.requestData(self.render);
	});
}
TableList.prototype.reload = function(){
	self.requestData(self.render);
}