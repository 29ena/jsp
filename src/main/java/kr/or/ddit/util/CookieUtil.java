package kr.or.ddit.util;

import org.apache.ibatis.reflection.ArrayUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CookieUtil.class);
	
	public static String cookieString;	// 분석할 쿠키 문자열
	
	/**
	 * 
	* Method : setCookieString
	* 작성자 : PC20
	* 변경이력 :
	* @param cookieString
	* Method 설명 : 분석할 쿠키 문자열을 받는다.
	 */
	public static void setCookieString(String cookieString) {
		CookieUtil.cookieString = cookieString;
	}
	
	/**
	 * 
	* Method : getCookie
	* 작성자 : PC20
	* 변경이력 :
	* @param cookie
	* @return
	* Method 설명 : 쿠키 문자열에서 특정 쿠키 값을 가져온다
	 */
	public static String getCookie(String cookie) {
		//"userId=brown; remeberme=true; test=testValue";
		// cookie = "userId"
		
		String[] cookieArray = CookieUtil.cookieString.split("; ");
		// cookieName = cookieValue
		// cookieArray[0] = "userId=brown"
		// cookieArray[1] = "remeberme=true"
		// cookieArray[2] = "test=testValue"
		String cookieValue = "";	// 반환값을 저장할 변수
		for(String str : cookieArray){
			logger.debug("str : {}",str);
//			if(str.substring(0, str.indexOf("=")).equals(cookie)){	// =기준으로 cookie값이 일치해야 하는 조건
			if(str.startsWith(cookie + "=")){	// cookie이름뒤에 "="까지 붙어있어야 하는 조건
				String[] cookieStr = str.split("=");
				cookieValue = cookieStr[1];
				// cookieStr[0] = "userId"
				// cookieStr[1] = "true"
				break;
				}
		}	
		return cookieValue;

		// 쿠키값을 담을 문자형 변수
		
		/*
		String cookieValue = "";	// 반환값을 저장할 변수
		// cookieString에 담긴 문자들을 split을 이용하여 배열로 만든다.
		String[] cookieArray = cookieString.split("; ");
		// cookie="userId"일 때 value값을 가져온다. 반복문을 통하여 설정한다.
		for(int i =0; i <cookieArray.length; i++){
			// {"userId=brown", "remeberme=true", "test=testValue"} =를 기준으로 substring하여 tmp에 담는다.
			String tmp = cookieArray[i].substring(0,cookieArray[i].indexOf("="));
			// cookie값이 tmp값과 같을 시 해당하는 문자 배열의 값을 (=)+1기준으로 출력한다.
			if(tmp.equals(cookie)){
				cookieValue = cookieArray[i].substring(cookieArray[i].indexOf("=")+1);
			}
		}
		logger.debug(cookieValue);
		
		return cookieValue;
		*/
	}

}
