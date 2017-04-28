package bookshop.command;

import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bookshop.bean.MngrDBBean;
import bookshop.bean.MngrDataBean;

public class BookRegisterProAction implements CommandAction {

	/* 보라 814 글등록 */
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");
		String filename = "";
		String realFolder = "";
		String saveFolder = "/bookImage";// 업로드파일경로
		String encType = "utf-8";
		int max_size = 1 * 1024 * 1024;

		MultipartRequest image_up = null;
		// 절대경로
		ServletContext context = request.getSession().getServletContext();
		realFolder = context.getRealPath(saveFolder);

		try {
			// 파일 업로드 수행하는 MultipartRequest객체
			image_up = new MultipartRequest(request, realFolder, max_size, encType, new DefaultFileRenamePolicy());

			Enumeration<?> files = image_up.getFileNames(); // name속성값

			while (files.hasMoreElements()) {
				String name = (String) files.nextElement();
				filename = image_up.getFilesystemName(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 폼으로 넘어온 정보중 파일이 아닌 정보 얻어냄
		MngrDataBean dto = new MngrDataBean();
		String book_kind = image_up.getParameter("book_kind");
		String book_title = image_up.getParameter("book_title");
		String book_price = image_up.getParameter("book_price");
		String book_count = image_up.getParameter("book_count");
		String author = image_up.getParameter("author");
		String publishing_com = image_up.getParameter("publishing_com");
		String book_content = image_up.getParameter("book_content");
		String discount_rate = image_up.getParameter("discount_rate");

		// 책 등록일
		String year = image_up.getParameter("publishing_year");
		// 월인데 길이가 1(즉 3,4...등)일 경우 앞에 03,04이렇게 붙이겠다는 3항연산자
		String month = (image_up.getParameter("publishing_month").length() == 1)
				? "0" + image_up.getParameter("publishing_month") : image_up.getParameter("publishing_month");
		String day = (image_up.getParameter("publishing_day").length() == 1)
				? "0" + image_up.getParameter("publishing_day") : image_up.getParameter("publishing_day");

		dto.setBook_kind(book_kind);
		dto.setBook_title(book_title);
		dto.setBook_price(Integer.parseInt(book_price));
		dto.setBook_count(Integer.parseInt(book_count));
		dto.setAuthor(author);
		dto.setPublishing_com(publishing_com);
		dto.setPublishing_date(year+"-"+month+"-"+day);
		dto.setBook_image(filename);
		dto.setBook_content(book_content);
		dto.setDiscount_rate(Integer.parseInt(discount_rate));
		dto.setReg_date(new Timestamp(System.currentTimeMillis()));

		//db연동
		MngrDBBean dao = MngrDBBean.get_instance();
		dao.insert_book(dto);
		request.setAttribute("book_kind", book_kind);
		return "/mngr/productProcess/bookRegisterPro.jsp";
	}

}
