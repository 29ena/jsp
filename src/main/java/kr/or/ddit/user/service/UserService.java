package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

public class UserService implements IuserService {

	private IuserDao userDao;
	
	public UserService() {
		userDao = new UserDao();
	}
	
	
	@Override
	public List<UserVo> userList() {
		return userDao.userList();
	}

	@Override
	public UserVo getUser(String id) {
		return userDao.getUser(id);
	}


	@Override
	public Map<String, Object> userPagingList(PageVo pageVo) {
		// 1.<List<UserVo>, userCnt를 필드로 하는 vo
		
		// 2.List<Object> resultList = new ArrayList<Object>();
		//	 resultList.add(userList);
		//	 resultList.add(userCnt);
		
		// 3. Map<String, Object> resultMap = new HashMap<String, Object>();
		//	 resultMap.out("userList",userList);
		//	 resultMap.out("userCnt",userCnt);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userDao.userPagingList(pageVo));
		
		// usersCnt --> paginationSize 변경
		// resultMap.put("usersCnt", userDao.usersCnt());
		int usersCnt = userDao.usersCnt();
		// pageSize --> pageVo.getPageSize();
		int paginationSize = (int)Math.ceil((double)usersCnt / pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

	
	
	@Override
	public int insertUser(UserVo userVo) {
		return userDao.insertUser(userVo);
	}


	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}


	@Override
	public int updateUser(UserVo userVo) {
		return userDao.updateUser(userVo);
	}
	
	
	
}
