package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256.SHA256_INFO;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.PartUtil;

/**
 * Servlet implementation class UserModifyController
 */
@WebServlet("/userModify")
@MultipartConfig(maxFileSize= 1024 * 1024 * 3, maxRequestSize = 1024 * 1024 * 15)
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
		
		// 사용자 보낸 파라미터를 사용해서 UserVo 인스턴스를 만들어서
		String userId = request.getParameter("userId");
		String name  = request.getParameter("name");
		String alias = request.getParameter("alias");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");
		String birth = request.getParameter("birth");
		
		// 사용자 보낸 평문 비밀번호 데이터 
		String pass  = request.getParameter("pass");
		pass = KISA_SHA256.encrypt(pass);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo=null;
		try {
			userVo = new UserVo(name, userId, alias, pass, addr1, addr2, zipcd, sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Part profile = request.getPart("profile");
		if(profile.getSize() > 0){
			// 사용자가 파일을 업로드 한 경우
			// 실제파일명
			String contentDisposition = profile.getHeader("content-disposition");
			String filename = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(filename);
			// 업로드할 폴더 확인

			// 업로드 폴더가 존재하는지 확인 후 생성
			String uploadPath = PartUtil.getUploadPath();
			File uploadFolder = new File(uploadPath);
			if (uploadFolder.exists()) {
				// 파일 디스크에 쓰기
				String filePath = uploadPath + File.separator+ UUID.randomUUID().toString() + "." + ext;
				userVo.setPath(filePath);
				userVo.setFilename(filename);

				profile.write(filePath);
				profile.delete(); // 디스크 임시 공간에 저장된 파일이 있다면 삭제한다.
			}
		}else{
			 userVo.setPath(userService.getUser(userId).getPath());
			 userVo.setFilename(userService.getUser(userId).getFilename());
			
		}
		int updateCnt = userService.updateUser(userVo);
		if(updateCnt ==1){
			request.getSession().setAttribute("userVo", userVo);
			request.getRequestDispatcher("/user/user.jsp").forward(request, response);
		}
		
		
	}

}
