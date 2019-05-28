package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.paging.model.PageVo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LprodServiceTest {
	private static final Logger logger = LoggerFactory
			.getLogger(LprodServiceTest.class);
	
	ILprodService lprodService;
	
	@Before
	public void setup(){
		lprodService = new LprodService();
		logger.debug("setup");
	}
	
	@After
	public void teardown(){
		logger.debug("teardown");
	}
	@Test
	public void lprodPagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1, 5);

		/***When***/
		Map<String, Object> resultMap = lprodService.lprodPagingList(pageVo);
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("lprodList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		/***Then***/
		assertNotNull(lprodList);
		assertEquals(5, lprodList.size());
		logger.debug("lprodListSize : {}",lprodList.size());
	}
	
	@Test
	public void lprodsCntTest(){
		/***Given***/
		

		/***When***/
		int lprodsCnt = lprodService.lprodsCnt();
		/***Then***/
		assertNotNull(lprodsCnt);
		assertEquals(9, lprodsCnt);
		logger.debug("lprodsCnt : {}", lprodsCnt);
	}
}
