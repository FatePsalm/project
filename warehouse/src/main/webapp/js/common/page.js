$(function(){
	$('.pagination').on('click','.upperPage,.nextPage,.firstPage,.lastPage,.jump',jumpToPage);//类选择
})
//设置分页
function setPagination(pageObject){
 //绑定总页数
 $("#pagination").data("pageCount",pageObject.pageCount);
 //绑定当前页面
 $("#pagination").data("pageCurrent",pageObject.pageCurrent);
 /**填充页码和总条数*/
 $("#currentPage").html(pageObject.pageCurrent+"/"+pageObject.pageCount);
 $("#totalCount").html(pageObject.rowCount);
 $("#pageSelect").val(pageObject.pageCurrent);
 
}
//获得页面保证页面不越界
function getPageCurrent(){
  /**获取当前页*/
  var pageCurrent=$("#pagination").data("pageCurrent");
  /**获取总页数*/
  var pageCount=$("#pagination").data("pageCount");
  if(pageCurrent>pageCount){
	 $("#pagination").data("pageCurrent",1);
	 doGetObjects();
  }
  
}
function jumpToPage() {
	//获得点击对象上class属性对应的值
	var clazz=$(this).attr("class");
	//获得pagination对象上绑定的pageCurrent对应的值-当前页
	var pageCurrent=$('#pagination').data("pageCurrent");
	//获得pagination对象上绑定的pageCount对应的值-记录总条数
	var pageCount=$('#pagination').data("pageCount");
	//获得pagination对象上绑定的pageCount对应的值-文本当前页
	var jumpPageCount=$('#pageSelect').val();
	//判断点击的是否是上一页
	if(clazz=='upperPage'&&pageCurrent>1){
		pageCurrent--;
	}
	//判断点击的是否是下一页
	if(clazz=="nextPage"&&pageCurrent<pageCount){
		pageCurrent++;
	}
	//判断点击的是否是第一页
	if(clazz=="firstPage"){
		pageCurrent=1;
	}
	//判断点击的是否是最后页
	if(clazz=="lastPage"&&pageCurrent<pageCount){
		pageCurrent=pageCount;
	}
	//判断点击的是否是跳转
	if(clazz=="jump"&&jumpPageCount<=pageCount&&jumpPageCount>=1){
		/**获取总页数*/
		pageCurrent=jumpPageCount;
	}
	//重写绑定pageCurrent的值,
	$('#pagination').data("pageCurrent",pageCurrent);
	//重新执行查询操作
	doGetObjects();
}