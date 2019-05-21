package ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowDateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		
//		// 현재시간 long타입으로 변환
//		long time = System.currentTimeMillis(); 
//		
//		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//		
//		String str = dayTime.format(new Date(time));
//		
		PrintWriter dt = resp.getWriter();
		dt.write(new Date().toString());
		dt.close();
	}
	
}
