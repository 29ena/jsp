package kr.or.ddit.db.dao;

import java.util.List;

import kr.or.ddit.db.model.DbVo;

public interface IdbDao {
	
	/**
	 * 
	* Method : dbList
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 전체 조회
	 */
	List<DbVo> dbList();
	
	/**
	 * 
	* Method : getDb
	* 작성자 : PC20
	* 변경이력 :
	* @param uri
	* @return
	* Method 설명 : db 조회
	 */
	DbVo getDb(String uri);
	
}
