package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LprodDaoTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(LprodDaoTest.class);
	
	@BeforeClass
	public static void beforeClass(){
		logger.debug("beforeClass");
	}
	@Before
	public void setup(){
		lprodDao = new LprodDao();
		logger.debug("setup");
	}
	
	private ILprodDao lprodDao;
	
	@After
	public void teardown(){
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass(){
		logger.debug("afterClass");
	}
	
	@Test
	public void lprodPagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1, 5);

		/***When***/
		List<LprodVo> lprodList = lprodDao.lprodPagingList(pageVo);
		/***Then***/
		assertNotNull(lprodList);
		assertEquals(5, lprodList.size());
		logger.debug("lprodListSize : {}",lprodList.size());
	}
	
	@Test
	public void lprodsCntTest(){
		/***Given***/
		

		/***When***/
		int lprodsCnt = lprodDao.lprodsCnt();
		/***Then***/
		assertNotNull(lprodsCnt);
		assertEquals(9, lprodsCnt);
		logger.debug("lprodsCnt : {}", lprodsCnt);
	}
	
	
}
