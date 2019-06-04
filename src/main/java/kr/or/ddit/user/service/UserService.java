package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

public class UserService implements IuserService {

	private static final Logger logger = LoggerFactory
			.getLogger(UserService.class);
	
	private IuserDao userDao;
	
	public UserService() {
		userDao = new UserDao();
	}
	
	
	@Override
	public List<UserVo> userList() {
		return userDao.userList();
	}

	@Override
	public UserVo getUser(String id) {
		return userDao.getUser(id);
	}


	@Override
	public Map<String, Object> userPagingList(PageVo pageVo) {
		// 1.<List<UserVo>, userCnt를 필드로 하는 vo
		
		// 2.List<Object> resultList = new ArrayList<Object>();
		//	 resultList.add(userList);
		//	 resultList.add(userCnt);
		
		// 3. Map<String, Object> resultMap = new HashMap<String, Object>();
		//	 resultMap.out("userList",userList);
		//	 resultMap.out("userCnt",userCnt);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userDao.userPagingList(pageVo));
		
		// usersCnt --> paginationSize 변경
		// resultMap.put("usersCnt", userDao.usersCnt());
		int usersCnt = userDao.usersCnt();
		// pageSize --> pageVo.getPageSize();
		int paginationSize = (int)Math.ceil((double)usersCnt / pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

	
	
	@Override
	public int insertUser(UserVo userVo) {
		return userDao.insertUser(userVo);
	}


	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}


	@Override
	public int updateUser(UserVo userVo) {
		return userDao.updateUser(userVo);
	}

	/*
	*//**
	 * 
	* Method : encryptPassAllUser
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 일괄 적용 배치
	* 			 : 재적용 하질 말것 !!!!
	 *//*
	@Override
	public int encryptPassAllUser() {
		// 사용하지 마세요!!! 이미 암호화 적용 되었습니다
		if(1 ==1)	return 0;
		// 0. sql 실행에 필요한 sqlSession 객체를 생성
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// 1. 모든 사용자 정보를 조회 (, 단 기존 암호화 적용 사용자 제외, brown, userTest)
		List<UserVo> userList = userDao.userListForPassEncrypt(sqlSession);
		// 2. 조회된 사용자의 비밀번호를 암호화적용 후 사용자 업데이트
		int updateCntSum = 0;
		for(UserVo userVo : userList){
			String encryptPass = KISA_SHA256.encrypt(userVo.getPass());
			userVo.setPass(encryptPass);
			
			int updateCnt = userDao.updateUserEncryptPass(sqlSession, userVo);
			updateCntSum += updateCnt;
			// 비정상
			if(updateCnt != 1){
				sqlSession.rollback();
				break;
			}
		}
		sqlSession.commit();
		sqlSession.close();
		// 3. sqlSession 객체를 commit, close
		return updateCntSum;
	}
	
	public static void main(String[] args) {
		IuserService userService = new UserService();
		int updateCnt = userService.encryptPassAllUser();
		logger.debug("updataCnt : {}", updateCnt);
	}
	
	
	*/
}
