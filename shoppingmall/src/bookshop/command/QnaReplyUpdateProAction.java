//845p -일현

package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.QnaDBBean;
import bookshop.bean.QnaDataBean;

public class QnaReplyUpdateProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			int qna_id = Integer.parseInt(request.getParameter("qna_id"));
			System.out.println("qna_id1= "+request.getParameter("qna_id"));
			System.out.println("qna_id2= "+qna_id);
			String qna_content = request.getParameter("qna_content");

			QnaDataBean qna = new QnaDataBean();
			qna.setQna_id(qna_id);
			qna.setQna_content(qna_content);

			QnaDBBean qnaProcess = QnaDBBean.getInstance();
			int check = qnaProcess.updateArticle(qna);

			request.setAttribute("check", new Integer(check));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/qna/qnaUpdatePro.jsp";
	}

}
