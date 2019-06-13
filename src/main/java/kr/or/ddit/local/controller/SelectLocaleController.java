package kr.or.ddit.local.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class SelectLocaleController
 */
@WebServlet("/selectLocale")
public class SelectLocaleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory
			.getLogger(SelectLocaleController.class);
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doGet");
		
		String locale = request.getParameter("locale");
		logger.debug("locale : {}",locale);
		
		if(locale == null)
			locale = "ko";
//		locale = locale == null ? "ko" : locale;
		
		
		request.setAttribute("locale", locale);
		request.getRequestDispatcher("/jstl/selectLocale.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("doPost");
		
		String locale = request.getParameter("locale");
		logger.debug("locale : {}",locale);
		
		request.setAttribute("locale", locale);
		response.sendRedirect(request.getContextPath()+"/selectLocale?locale=" + locale);
	}

}
