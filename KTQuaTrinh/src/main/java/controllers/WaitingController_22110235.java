package controllers;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import entity.User_22110235;

@WebServlet(urlPatterns = {"/waiting"})
public class WaitingController_22110235 extends HttpServlet{

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession();
		if(session != null && session.getAttribute("account") != null) {
		User_22110235 u=(User_22110235 ) session.getAttribute("account");
		req.setAttribute("username", u.getUsername());
		if(u.getRoleid().getRoleid()==1) {
		resp.sendRedirect(req.getContextPath()+"/user/home");
		}else if(u.getRoleid().getRoleid()==2) {
		resp.sendRedirect(req.getContextPath()+"/admin/home");
		}else if(u.getRoleid().getRoleid()==3) {
		resp.sendRedirect(req.getContextPath()+"/manager/home");
		}else if(u.getRoleid().getRoleid()==4) {
		resp.sendRedirect(req.getContextPath()+"/seller/home");
		}else if(u.getRoleid().getRoleid()==5) {
		resp.sendRedirect(req.getContextPath()+"/shipper/home");
		}else {
		resp.sendRedirect(req.getContextPath()+"/home");
		}
		}else {
		resp.sendRedirect(req.getContextPath()+"/login");
		}}}
	