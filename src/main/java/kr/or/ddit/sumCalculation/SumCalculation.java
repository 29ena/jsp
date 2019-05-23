package kr.or.ddit.sumCalculation;

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
* SumCalculation.java
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
@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet {
	
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
logger.debug("LoginController doGet()");
		
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		
		int res= 0;
		for(int i =start; i<=end; i++){
			res += i;
		}
		logger.debug("총합 : " + res);
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", res);
		
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
		
	}

}
