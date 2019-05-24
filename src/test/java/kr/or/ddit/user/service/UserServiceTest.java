package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceTest {
	
	// 사용자 전체리스트를 조회 하는 메소드
	// 1. 메소드 인자가 필요한가? 별다른 인자는 불필요
	// 2. 리턴 타입은 뭐가 될까? List<UserVo>
	// 3. 메소드 이름은 뭐가 적당하지? userList
	
//	@Test
//	public void userList(){
//		/***Given***/
//		// 내가 바라는 모습을 테스트 코드로 녹여내기
//		IuserService userService = new UserService();
//
//		/***When***/
//		List<UserVo> userList = userService.userList();
//		
//		/***Then***/
//		assertNotNull(userList);
//		assertEquals(5, userList.size());
//	}
//	
	
	
	
//------------------------------------------------------------------------
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceTest.class);
	
	IuserService userService;
	
	@Before
	public void setup(){
		userService = new UserService();
		logger.debug("setup");
	}
	
	@After
	public void teardown(){
		logger.debug("teardown");
	}
	
	/**
	 * 
	* Method : userListTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 사용자 전체 조회
	 */
	@Test
	public void userListTest() {
		//***Given***//
		
		
		
		//***When***//
		List<UserVo> userList = userService.userList();
		//***Then***//
		assertEquals(105, userList.size());
		
		logger.debug("userList :{}", userList);
	}	
	
	/**
	 * 
	* Method : getUserTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 사용자 정보 조회
	 */
	@Test
	public void getUserTest(){
		//***Given***//
		
		String userId = "brown";
		
		//***When***//
		
		UserVo userVo =  userService.getUser(userId);
		
		//***Then***//
		
		assertNotNull(userVo);
		logger.debug("getUser : {}", userVo  );
	}

}
