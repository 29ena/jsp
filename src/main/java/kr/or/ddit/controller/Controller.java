package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	// throws 생성시 생겨나는 오류는 Controller 인터페이스 추가하면 없어진다.
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
