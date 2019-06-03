package kr.or.ddit.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.util.PartUtil;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize = 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(FileUploadServlet.class);

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// userId, profile 파라미터를 확인
		String userId = request.getParameter("userId");
		String profile = request.getParameter("profile");
		logger.debug("userId : {}", userId);
		logger.debug("profile : {}", profile);

		Part part = request.getPart("profile");
		logger.debug("part.getSize() : {}", part.getSize());
		logger.debug("part.getContentType() : {}", part.getContentType());
		logger.debug("part.getName() : {}", part.getName());

		Collection<String> headerNames = part.getHeaderNames();
		for (String header : headerNames) {
			logger.debug("{} : {}", header, part.getHeader(header));
		}

		// 파일이 존재할 때만 파일을 정해진 위치에 기록한다.
		if (part.getSize() > 0) {

			String contentDisposition = part.getHeader("content-disposition");
			String fileName = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(fileName);
			ext = ext.equals("") ? "" : "." + ext;

			// 년도에 해당하는 폴더가 있는지, 년도안에 월에 해당하는 폴더가 있는지

			Date dt = new Date();

			// 년도, 월을 formatting 한다.
			SimpleDateFormat yyyMMSdf = new SimpleDateFormat("yyyyMM");

			String yyyyMM = yyyMMSdf.format(dt);
			String yyyy = yyyyMM.substring(0,4);
			String mm = yyyyMM.substring(4,6);

			
			// 신규년도로 넘어갔을 때 해당 년도의 폴더를 생성한다.
			File yyyyFolder = new File("d:\\upload\\" + yyyy);
			if (!yyyyFolder.exists()) {
				yyyyFolder.mkdir();
			}
			
			// 월에 해당하는 폴더가 있는지 확인
			File mmFolder = new File("d:\\upload\\"+ yyyy + File.separator + mm);
			if (!mmFolder.exists()) {
				mmFolder.mkdir();
			}
			
			// 업로드 폴더가 존재하는지 확인 후 생성
			String uploadPath = "d:\\upload\\" + yyyy + "\\" + mm ; 
			File uploadFolder = new File(uploadPath);
			if (uploadFolder.exists()) {
				// 파일 디스크에 쓰기
				part.write(uploadPath + "\\" + UUID.randomUUID().toString() + ext);
				part.delete(); // 디스크 임시 공간에 저장된 파일이 있다면 삭제한다.
			}
		}
	}

}
