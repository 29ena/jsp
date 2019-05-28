package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.paging.model.PageVo;


public class LprodService implements ILprodService {
	
	private ILprodDao lprodDao;
	
	public LprodService() {
		lprodDao = new LprodDao();
	}
	
	@Override
	public Map<String, Object> lprodPagingList(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lprodList", lprodDao.lprodPagingList(pageVo));
		
		int lprodsCnt = lprodDao.lprodsCnt();
		
		int paginationSize = (int)Math.ceil((double)lprodsCnt / pageVo.getPageSize());
		
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

	@Override
	public int lprodsCnt() {
		
		return lprodDao.lprodsCnt();
	}

	
	
	
	
}
