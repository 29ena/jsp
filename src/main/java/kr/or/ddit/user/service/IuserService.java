package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IuserService {
	
	/**
	 * 
	* Method : userList
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 리스트 조회
	 */
	List<UserVo> userList();
	
	/**
	 * 
	* Method : getUser
	* 작성자 : PC20
	* 변경이력 :
	* @param id
	* @return
	* Method 설명 : 사용자 정보 조회
	 */
	UserVo getUser(String id);

	/**
	 * 
	* Method : userPagingList
	* 작성자 : PC20
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	Map<String, Object> userPagingList(PageVo pageVo);
	
	/**
	 * 
	* Method : insertUser
	* 작성자 : PC20
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 정보 등록
	 */
	int insertUser(UserVo userVo);

	/**
	 * 
	* Method : deleteUser
	* 작성자 : PC20
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 삭제
	 */
	int deleteUser(String userId);
	
	/**
	 * 
	* Method : updateUser
	* 작성자 : PC20
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 정보 수정
	 */
	int updateUser(UserVo userVo);
	
	/**
	 * 
	* Method : encryptPassAllUser
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 일괄 적용 배치
	 */
	int encryptPassAllUser();
}
