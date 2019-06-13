package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;

public interface IProdDao {
	
	/**
	 * 
	* Method : prodList
	* 작성자 : PC20
	* 변경이력 :
	* @param prod_lgu
	* @return
	* Method 설명 : 전체 조회
	 */
	List<ProdVo> prodList(String prod_lgu);
}
