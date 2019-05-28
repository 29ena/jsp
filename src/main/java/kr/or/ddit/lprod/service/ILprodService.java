package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;

public interface ILprodService {

	/**
	 * 
	* Method : lprodPagingList
	* 작성자 : PC20
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	Map<String, Object> lprodPagingList(PageVo pageVo);

	int lprodsCnt();
	
	
}
