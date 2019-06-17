package kr.or.ddit.db.db.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.model.DbVo;
import kr.or.ddit.db.service.DbService;
import kr.or.ddit.db.service.IdbService;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbServiceTest {
	private static final Logger logger = LoggerFactory
			.getLogger(DbServiceTest.class);
	
	IdbService service;
	
	@Before
	public void setup(){
		service = new DbService();
	}
	
	@Test
	public void dbListTest() {
		/***Given***/
		
	
		/***When***/
		List<DbVo> dbList = service.dbList();
		/***Then***/
		assertNotNull(dbList);
		logger.debug("getUri : {}", dbList.get(0).getUri());
		assertEquals(2, dbList.size());
		assertEquals("/main.do", dbList.get(0).getUri());
	}
	
	@Test
	public void getDbTest(){
		/***Given***/
		String uri = "/main.do";

		/***When***/
		DbVo getDb = service.getDb(uri);
		/***Then***/
		logger.debug("getUri : {}", getDb.getUri());
		assertEquals("/main.do", getDb.getUri());
	}

}
