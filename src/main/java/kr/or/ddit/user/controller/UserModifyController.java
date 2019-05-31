package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class UserModifyController
 */
@WebServlet("/userModify")
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserModifyController.class);
	
	private IuserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		request.getSession().getAttribute("userVo");
		
		UserVo userVo = (UserVo) request.getSession().getAttribute("userVo");
		String birth = sdf.format(userVo.getBirth());
		
		logger.debug("birth : {}",birth);
		
		request.setAttribute("birth", birth);
		
		logger.debug("userVo : {}",request.getSession().getAttribute("userVo"));
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 설정하지 않으면 한글깨짐
		
		// 사용자 보낸 파라미터를 사용해서 UserVo 인스턴스를 만들어서
		String userId = request.getParameter("userId");
		logger.debug("userId : {}",userId);
		
		String name  = request.getParameter("name");
		logger.debug("name : {}",name);
		
		String alias = request.getParameter("alias");
		logger.debug("alias : {}",alias);
		
		String addr1 = request.getParameter("addr1");
		logger.debug("addr1 : {}",addr1);
		
		String addr2 = request.getParameter("addr2");
		logger.debug("addr2 : {}",addr2);
		
		String zipcd = request.getParameter("zipcd");
		logger.debug("zipcd : {}",zipcd);
		
		String birth = request.getParameter("birth");
		logger.debug("birth : {}",birth);
		
		String pass  = request.getParameter("pass");
		logger.debug("pass : {}",pass);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo=null;
		try {
			userVo = new UserVo(name, userId, alias, pass, addr1, addr2, zipcd, sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		logger.debug("userVoget : {}",userVo);
		int updateCnt = userService.updateUser(userVo);
		logger.debug("updateCnt : {}", updateCnt);
		if(updateCnt ==1){
			response.sendRedirect(request.getContextPath()+"/userPagingList");
		}
		
		
	}

}
