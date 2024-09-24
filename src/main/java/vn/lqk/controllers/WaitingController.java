package vn.lqk.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.lqk.models.AccountModel;

@WebServlet(urlPatterns = { "/waiting" })
public class WaitingController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			AccountModel u = (AccountModel) session.getAttribute("account");
			req.setAttribute("username", u.getUsername());
			if (u.getRoleid() == 1) {
				resp.sendRedirect(req.getContextPath() + "/views/manager/home.jsp");
			} else {
				resp.sendRedirect(req.getContextPath() + "/views/user/home.jsp");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}

	}

}
