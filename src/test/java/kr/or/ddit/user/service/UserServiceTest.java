package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.annotations.ResultMap;
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
	
	/**
	 * 
	* Method : userPagingListTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void userPagingListTest(){
		
		/***Given***/
		PageVo pageVo = new PageVo(1, 10);

		/***When***/
		Map<String, Object> resultMap = userService.userPagingList(pageVo);
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		/***Then***/
		// pagingList assert
		assertNotNull(userList);
		assertEquals(10, userList.size());
		
		// usersCnt assert
		assertEquals(11, paginationSize);
	}
	
	@Test
	public void ceilTest(){
		/***Given***/
		int usersCnt = 105;
		int pageSize = 10;
		/***When***/
		double paginationSize =  Math.ceil((double)usersCnt/pageSize);
		logger.debug("paginationSize : {}", paginationSize);
		/***Then***/
		
	}
	
	@Test
	public void insertUserTest() throws ParseException{
		
		/***Given***/
		// 사용자정보를 담고 있는 vo객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = new UserVo("대덕인", "userTest", "중앙로", "1234", "대전광역시 중구 중앙로76", "영민빌딩 2층 204호", "34940", sdf.parse("2019-05-31") );
		

		/***When***/
		// userDao.insertUser() 실행
		int insertCnt = userService.insertUser(userVo);
		/***Then***/
		// insertCnt(1)인지 확인
		assertEquals(1, insertCnt);
		
		// data삭제
		userService.deleteUser(userVo.getUserId());
	}
	
	@Test
	public void updateUserTest() throws ParseException{
		
		/***Given***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVo userVo = new UserVo("호길스","userTest" ,"뽀길", "4321", "대전 광역시 중구", "중구청 옆 영민빌딩", "32402", sdf.parse("2019-05-28"));
		logger.debug("userVo : {}",userVo);
		/***When***/
		int updateCnt = userService.updateUser(userVo);
		logger.debug("updateCnt : {}",updateCnt);
		/***Then***/
		assertEquals(1, updateCnt);
	}
}
