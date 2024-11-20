package controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.impl.UserServiceImpl_22110235;
import entity.User_22110235;
import utils.Constant_22110235;

@WebServlet(urlPatterns = { "/forgotpsw" })
public class ForgotPswController_22110235 extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/forgotpsw.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		User_22110235 user_22110235 = new User_22110235();
		user_22110235.setEmail(req.getParameter("email"));
		UserServiceImpl_22110235 service = new UserServiceImpl_22110235();
		String alertMsg = "";
		if ((service.findByEmail(user_22110235.getEmail())) != null) {
			User_22110235 u = service.findByEmail(user_22110235.getEmail());
			u.setPassword(req.getParameter("newpsw"));
			try {
				service.update(u);
				alertMsg = "Đổi thành công!";
				req.setAttribute("alert", alertMsg);
				resp.sendRedirect(req.getContextPath() + "/login");
			} catch (Exception e) {
				e.printStackTrace();
				alertMsg = "System error!";
				req.setAttribute("alert", alertMsg);
				req.getRequestDispatcher(Constant_22110235.Path.ForgotPsw).forward(req, resp);
			}
			
		}else {
			alertMsg = "Email không tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(Constant_22110235.Path.ForgotPsw).forward(req, resp);
			return;
		}
		
		
	}

}