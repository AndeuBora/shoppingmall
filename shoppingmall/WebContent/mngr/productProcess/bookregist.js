$(function() {
	
	//[책등록]버튼클릭
	$("#upform1").ajaxForm({
		//이미지포함한 상품등록
		success:function(data,status){
			window.location.href="/shoppingmall/mg/bookList.do?book_kind=all";
		}
	})
	
	//[관리자 메인으로]버튼 클릭
	$("#bookMain").click(function(){
		window.location.href="/shoppingmall/mg/managerMain.do";
	})
	
	//[목록으로]버튼 클릭
	$("#bookList").click(function(){
		window.location.href="/shoppingmall/mg/bookList.do?book_kind=all";
	})
});