package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "/main.jsp";
		
		
		// 기본 -> forward
		// return "/main.jsp";
		// redirect:/main.jsp -> redirect
		// return "redirect:/main.jsp";
		
	}

}
