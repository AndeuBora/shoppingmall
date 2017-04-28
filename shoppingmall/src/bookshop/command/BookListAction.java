/*보라 817 */
package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.MngrDBBean;
import bookshop.bean.MngrDataBean;

public class BookListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		List<MngrDataBean> list = null;
		String book_kind = request.getParameter("book_kind");
		int count = 0;

		// DB연동 전체상품수얻음
		MngrDBBean dao = MngrDBBean.get_instance();
		count = dao.getBook_count();

		if (count > 0) {
			// 상품있으면 수행
			list = dao.getBooks(book_kind);
			request.setAttribute("bookList", list);
		}

		// 뷰 사용속성
		request.setAttribute("count", new Integer(count));
		request.setAttribute("book_kind", book_kind);
		request.setAttribute("type", new Integer(0));
		return "/mngr/productProcess/bookList.jsp";
	}

}
