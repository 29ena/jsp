package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;

public class LprodDao implements ILprodDao {


	
	@Override
	public List<LprodVo> lprodPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVo> lprodList = sqlSession.selectList("lprod.lprodPagingList", pageVo);
		sqlSession.close();
		return lprodList;
	}

	@Override
	public int lprodsCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int lprodsCnt = (Integer) sqlSession.selectOne("lprod.lprodsCnt");
		sqlSession.close();
		return lprodsCnt;
	}
	
	
}
