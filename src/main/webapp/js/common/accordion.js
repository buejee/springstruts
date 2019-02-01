/**
 * 
 */
$(function(){
	$("#accordion").delegate(".item-title","click",function(e){
		$(this).siblings("ul").toggle();//hide show
		var fold = $(this).find(".icon").hasClass("icon-menu-fold");
		if(fold){
			$(this).find(".icon").removeClass("icon-menu-fold");
			$(this).find(".icon").addClass("icon-menu-open");
		}else{
			$(this).find(".icon").removeClass("icon-menu-open");
			$(this).find(".icon").addClass("icon-menu-fold");
		}
	});
});