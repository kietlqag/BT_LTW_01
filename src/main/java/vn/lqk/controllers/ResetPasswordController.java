package vn.lqk.controllers;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.lqk.services.*;
import vn.lqk.services.implement.AccountServiceImplement;
import vn.lqk.utils.Constant;


@WebServlet(urlPatterns = {"/reset-password"})
public class ResetPasswordController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/forgetpassword.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String username = req.getParameter("username");
		String password = req.getParameter("password"); 
		String passwordVerify = req.getParameter("password-verify"); 

		IAccountService service = new AccountServiceImplement();
		String alertMsg = "";

		if (!service.checkExistUsername(username)) {
		    alertMsg = "Tài khoản không tồn tại!";
		    req.setAttribute("alert", alertMsg);
		    RequestDispatcher dispatcher = req.getRequestDispatcher(Constant.RESETPASS);
		    dispatcher.forward(req, resp);
		    return;
		}

		
		if (password != null && passwordVerify != null && password.equals(passwordVerify)) {
		    
		    boolean isSuccess = service.resetpass(username, password);

		    if (isSuccess) {
		        req.setAttribute("alert", alertMsg);
		        resp.sendRedirect("./login");
		    } else {
		        alertMsg = "Cập nhật không thành công!";
		        req.setAttribute("alert", alertMsg);
		        RequestDispatcher dispatcher = req.getRequestDispatcher(Constant.RESETPASS);
		        dispatcher.forward(req, resp);
		    }
		} else {
		    alertMsg = "Mật khẩu không khớp!";
		    req.setAttribute("alert", alertMsg);
		    RequestDispatcher dispatcher = req.getRequestDispatcher(Constant.RESETPASS);
		    dispatcher.forward(req, resp);
		}
	}
}
