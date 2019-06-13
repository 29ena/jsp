package kr.or.ddit.prod.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProdDaoTest {

	private static final Logger logger = LoggerFactory
			.getLogger(ProdDaoTest.class);
	
	private IProdDao prodDao;
	
	@Before
	public void setup(){
		prodDao = new ProdDao();
		
	}
	
	@Test
	public void prodListTest() {
		/***Given***/
		String prod_lgu = "P201";

		/***When***/
		List<ProdVo> prodList = prodDao.prodList(prod_lgu);
		/***Then***/
		assertNotNull(prodList);
		assertEquals(21, prodList.size());
	}

}
