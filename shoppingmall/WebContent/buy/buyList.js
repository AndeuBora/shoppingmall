/*971 보라*/
$(function(){
	//[쇼핑계속]클릭 시
	$("#conShopping").click(function(){
		window.location.href="/shoppingmall/list.do?book_kind=all";
	})
	//[메인으로]클릭 시
	$("#shopMain").click(function(){
		window.location.href="/shoppingmall/index.do";
	})
})