package kr.or.ddit.db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.model.DbVo;
import kr.or.ddit.mybatis.MyBatisUtil;

public class DbDao implements IdbDao {
	/**
	 * 
	* Method : dbList
	* 작성자 : PC20
	* 변경이력 :
	* @return
	* Method 설명 : 전체 조회
	 */
	@Override
	public List<DbVo> dbList() {
		SqlSession session = MyBatisUtil.getSqlSession();
		List<DbVo> dbList = session.selectList("db.dbList");
		session.close();
		return dbList;
	}

	/**
	 * 
	* Method : getDb
	* 작성자 : PC20
	* 변경이력 :
	* @param uri
	* @return
	* Method 설명 : db 조회
	 */
	@Override
	public DbVo getDb(String uri) {
		SqlSession session = MyBatisUtil.getSqlSession();
		DbVo getDb = session.selectOne("db.getDb",uri);
		session.close();
		return getDb;
	}

}
