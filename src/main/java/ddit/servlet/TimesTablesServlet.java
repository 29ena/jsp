package ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimesTablesServlet extends HttpServlet {
	
	// 
	private Logger logger = LoggerFactory.getLogger(TimesTablesServlet.class);
	// 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		
		// http://localhost/jsp/timesTablesServlet?param=6
		String param = req.getParameter("i");
		// trace / debug / info / warn / error
		logger.debug("param : {}", param);
		
		String param2 = req.getParameter("j");
		logger.debug("param2 {} ", param2);
		
		int b = Integer.parseInt(param);
		int f = Integer.parseInt(param2);
		
		
		pw.write("<html>");
		pw.write( "<head>" );
		pw.write( "<style>" );
		pw.write( "td{" );
		pw.write( "padding : 5px;" );
		pw.write( "</style>" );
		pw.write( "</head>" );
		pw.write( "<body>");
		pw.write( "<table border='1'>" );
		for(int i =1; i <= b; i++){
			pw.write( "<tr>" );
			for(int j = 2; j <= f; j ++){
				
				pw.write("<td>" + j + " * " + i +" = " + j*i+ "</td>" );
			}
//			pw.write("<td>" + num + " * " + i + " = " + num * i + "</td>");
			pw.write( "</tr>" );
		}
		pw.write( "</table>" );
		pw.write( "</body>");
		pw.write( "</html>");
	}

}
