package kr.or.ddit.lprod.dao;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;

public interface ILprodDao {
	
	/**
	 * 
	* Method : lprodPagingList
	* 작성자 : PC20
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	List<LprodVo> lprodPagingList(PageVo pageVo);
	
	/**
	 * 
	* Method : lprodsCnt
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체수 조회
	 */
	int lprodsCnt();
}
