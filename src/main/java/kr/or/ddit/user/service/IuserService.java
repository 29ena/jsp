package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

/**
* IuserService.java
*
* @author PC20
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC20 최초 생성
*
* </pre>
*/
public interface IuserService {
	/**
	 *
	* Method : userList
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	 */
	List<UserVo> userList();
}
