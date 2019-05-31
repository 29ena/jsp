package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoTest.class);
	
	
	// JUnit 실행순서
	// @BeforeClass가 적용된 메소드가 최초 1회 실행
	
	// 다음 구간은 @Test가 적용된 모든 메소드에 대한 반복 적용
	// @Before가 적용된 메소드 실행
	// @Test가 적용된 메소드가 실행
	// @After가 적용된 메소드가 실행
	
	// @AfterClass가 적용된 메소드가 1회 실행
	
	// BeforeClass, AfterClass 잘 쓰이지 않음
	
	@BeforeClass
	public static void beforeClass(){	// static 필수
		logger.debug("beforeClass");
	}
		
	@Before
	public void setup(){	// static 필수 X
		userDao  = new UserDao();
		logger.debug("setup");
	}
	
	private IuserDao userDao;
	
	@After
	public void teardown(){
		
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass(){
		logger.debug("afterClass");
	}
	
	
	
	/**
	 * 
	* Method : userListTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 사용자 전체 조회 테스트
	 */
	@Test
	public void userListTest() {
		/***Given***/
		

		/***When***/
		List<UserVo> userList = userDao.userList();
		
		/***Then***/
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(106, userList.size());
		logger.debug("userList :{}", userList);
		
	}
	
	/**
	 * 
	* Method : getUserTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 특정 사용자 조회  테스트
	 */
	@Test
	public void getUserTest(){
		
		/***Given***/
		String userId = "brown";
		/***When***/
		UserVo userVo = userDao.getUser(userId);
		
		/***Then***/
		assertEquals("브라운", userVo.getName());
		logger.debug("userVo : {}",userVo);
	}
	
	// 사용자 페이징 리스트 조회
	// 고려사항
	// 몇번째 페이지 조회인지?, 페이징 몇건씩 데이터를 보여줄건지 : 쿼리 실행 파라미터
	// 정렬순서 ? : 로직 --> 파라미터화 시킬수 있다.
	// --> 사용자 아이디 순으로 정렬

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
		List<UserVo> userList = userDao.userPagingList(pageVo);
		
		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());
		logger.debug("userList :{}", userList.size());
		
	}
	
	/**
	 * 
	* Method : usersCntTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 사용자 전체수 조회 테스트
	 */
	@Test
	public void usersCntTest(){
		/***Given***/
		

		/***When***/
		int usersCnt = userDao.usersCnt();
		/***Then***/
		assertEquals(106, usersCnt);
		logger.debug("usersCnt : {}",usersCnt);
	}
	
	/**
	 * 
	* Method : insertUserTest
	* 작성자 : PC20
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	 * @throws ParseException 
	 */
	@Test
	public void insertUserTest() throws ParseException{
		
		/***Given***/
		// 사용자정보를 담고 있는 vo객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = new UserVo("대덕인", "userTest", "중앙로", "1234", "대전광역시 중구 중앙로76", "영민빌딩 2층 204호", "34940", sdf.parse("2019-05-31") );
		

		/***When***/
		// userDao.insertUser() 실행
		int insertCnt = userDao.insertUser(userVo);
		/***Then***/
		// insertCnt(1)인지 확인
		assertEquals(1, insertCnt);
		
		// data삭제
		userDao.deleteUser(userVo.getUserId());
	}
	
	@Test
	public void updateUserTest() throws ParseException{
		
		/***Given***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVo userVo = new UserVo("호길스","userTest" ,"뽀길", "4321", "대전 광역시 중구", "중구청 옆 영민빌딩", "32402", sdf.parse("2019-05-28"));
		logger.debug("userVo : {}",userVo);
		/***When***/
		int updateCnt = userDao.updateUser(userVo);
		logger.debug("updateCnt : {}",updateCnt);
		/***Then***/
		assertEquals(1, updateCnt);
	}
	
}
