package kr.or.ddit.core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// localhost/userList.do --> init -> service()
@WebServlet("*.do")	// .do로 끝나는 요청에 대해 프론트 컨트롤러가 응답을 처리한다.
public class FrontController extends HttpServlet{
	private static final Logger logger = LoggerFactory
			.getLogger(FrontController.class);
	

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.debug("service : {}", req.getRequestURI());
		String uri = req.getRequestURI();
		
		// controller
		Controller controller = RequestMapping.getController(uri);
		String viewName = controller.execute(req,resp);
		
		ViewResolver.viewResoleve(viewName, req, resp);
		
		
	}	
	
}
