package kr.or.ddit.mulCalculation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.login.controller.LoginController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* MulCalculation.java
*
* @author PC20
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC20 최초 생성
*
* </pre>
*/
@WebServlet("/mulCalculation")
public class MulCalculation extends HttpServlet {
	
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		
		int res = 0;
		
			res = start * end ;
		logger.debug("총곱 : " + res);
		
		HttpSession session = request.getSession();
		session.setAttribute("mulResult", res);
		
		request.getRequestDispatcher("/jsp/mulResult.jsp").forward(request, response);
		
		
	}

}
