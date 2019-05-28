package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.paging.model.PageVo;

/**
 * Servlet implementation class LprodPagingController
 */
@WebServlet("/lprodPagingList")
public class LprodPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ILprodService lprodService;
	
	@Override
	public void init() throws ServletException {
		lprodService = new LprodService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lprodString = request.getParameter("page");
		String lprodSizeString = request.getParameter("pageSize");
		
		int page = lprodString == null ? 1 : Integer.parseInt(lprodString);
		int pageSize = lprodSizeString == null ? 5 : Integer.parseInt(lprodSizeString);
		
		PageVo pageVo = new PageVo(page, pageSize);		
		Map<String, Object> resultMap = lprodService.lprodPagingList(pageVo);		
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("lprodList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		request.setAttribute("lprodList", lprodList);
		
		request.setAttribute("paginationSize", paginationSize);
		
		request.setAttribute("pageVo", pageVo);
		
		request.getRequestDispatcher("lprod/lprodPagingList.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
