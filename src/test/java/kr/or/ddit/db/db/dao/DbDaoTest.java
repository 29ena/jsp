package kr.or.ddit.db.db.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.dao.DbDao;
import kr.or.ddit.db.dao.IdbDao;
import kr.or.ddit.db.model.DbVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DbDaoTest {
	private static final Logger logger = LoggerFactory
			.getLogger(DbDaoTest.class);
	
	private IdbDao dao;
	@Before
	public void setup(){
		dao = new DbDao();
	}
	
	@Test
	public void dbListTest() {
		/***Given***/
		
	
		/***When***/
		List<DbVo> dbList = dao.dbList();
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
		DbVo getDb = dao.getDb(uri);
		/***Then***/
		logger.debug("getUri : {}", getDb.getUri());
		assertEquals("/main.do", getDb.getUri());
	}
}
