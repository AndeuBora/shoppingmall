package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BookRegisterFormAction implements CommandAction {

	/*보라 810*/
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("type", new Integer(0));
		return "/mngr/productProcess/bookRegisterForm.jsp";
	}

}
