package kr.or.ddit.db.service;

import java.util.List;

import kr.or.ddit.db.dao.DbDao;
import kr.or.ddit.db.dao.IdbDao;
import kr.or.ddit.db.model.DbVo;

public class DbService implements IdbService {

	IdbDao dao;
	
	public DbService() {
		dao = new DbDao();
	}

	@Override
	public List<DbVo> dbList() {
		return dao.dbList();
	}

	@Override
	public DbVo getDb(String uri) {
		return dao.getDb(uri);
	}

}
