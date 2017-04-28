/*보라 967*/
package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.BuyDBBean;
import bookshop.bean.CartDBBean;
import bookshop.bean.CartDataBean;

public class BuyProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		// 구매처리 필요한 정보 파라미터
		String account = request.getParameter("account");
		String deliveryName = request.getParameter("deliveryName");
		String deliveryTel = request.getParameter("deliveryTel");
		String deliveryAddress = request.getParameter("deliveryAddress");
		String buyer = request.getParameter("buyer");
		int count = 0;

		// 구매처리 장바구니목록
		CartDBBean dao = CartDBBean.getInstance();
		count = dao.getListCount(buyer);
		List<CartDataBean> list = dao.getCart(buyer, count);

		// buy처리
		BuyDBBean buy_dao = BuyDBBean.getInstance();
		buy_dao.insertBuy(list, buyer, account, deliveryName, deliveryTel, deliveryAddress);

		request.setAttribute("orderStus", "주문완료");
		request.setAttribute("type", new Integer(1));
		return "/buy/buyPro.jsp";
	}

}
