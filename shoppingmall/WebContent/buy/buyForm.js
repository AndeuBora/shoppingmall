//965 보라
$(function() {
	// [취소]버튼 클릭 시
	$("#cancle").click(function() {
		window.location.href = "/shoppingmall/index.do";
	});
	$("#buyForm").submit(function() {
		if ($("#deliveryAddress").val() == "") {
			$("#deliveryAddress").val("");
			$("#deliveryAddress").focus();
		}
	});
})