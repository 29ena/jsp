package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;

public class SessionAttributeListener implements HttpSessionAttributeListener{
	private static final Logger logger = LoggerFactory
			.getLogger(SessionAttributeListener.class);
	
	private Map<String, UserVo> sessionUserMap = new HashMap<String, UserVo>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {	//속성 추가시 이벤트
		event.getSession().getServletContext().setAttribute("sessionUserMap", sessionUserMap);	// application에 넣어준다.
		//속성명
		if("USER_INFO".equals(event.getName()));
			sessionUserMap.put(event.getSession().getId(), (UserVo)event.getValue());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) { // 속성 제거시 이벤트
		if("USER_INFO".equals(event.getName()));
		sessionUserMap.remove(event.getSession().getId(), (UserVo)event.getValue());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}


}
