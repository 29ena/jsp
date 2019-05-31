package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class UserPagingController
 */
@WebServlet("/userPagingList")
public class UserPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IuserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// page, pageSize 파라미터 받기
		// page, pageSize 파라미터가 없을 경우 page=1, pageSize=10 기본값 설정
		
//		int page = Integer.parseInt(request.getParameter("page"));
//		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
		
//		int page = 0;
//		int pageSize = 0;
//		
//		if(request.getParameter("page")!= null){
//			page = Integer.parseInt(request.getParameter("page"));
//		}else{
//			page =1;
//		}
//		
//		if(request.getParameter("pageSize")!= null){
//			pageSize = Integer.parseInt(request.getParameter("pageSize"));
//		}else{
//			pageSize =10;
//		}
		
		
		
		PageVo pageVo = new PageVo(page,pageSize);
		
		Map<String, Object> resultMap = userService.userPagingList(pageVo);
		
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		request.setAttribute("userList", userList);
		
		request.setAttribute("paginationSize", paginationSize);
		
		request.setAttribute("pageVo", pageVo);
		
		request.getRequestDispatcher("user/userPagingList.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
