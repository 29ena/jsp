package kr.or.ddit.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtil {

	private static final Logger logger = LoggerFactory
			.getLogger(PartUtil.class);
	
	/**
	 * 
	* Method : getFileName
	* 작성자 : PC20
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : contentDisposition에서 파일명을 반환한다.
	 */
	public static String getFileName(String contentDisposition) {
		// form-data; name= "profile"; filename="sally.png"
		// 구분자를 이용하여 ;로 나눠주고 
		String[] spl = contentDisposition.split("; ");
		for(String split : spl){
			if(split.startsWith("filename=")){
				int start = split.indexOf("\"")+1;
				int end = split.lastIndexOf("\"");
				return split.substring(start, end);
			}
		}
		return "";
	}
	
	/**
	 * 
	* Method : getExt
	* 작성자 : PC20
	* 변경이력 :
	* @param fileName
	* @return
	* Method 설명 : 파일명으로부터 파일 확장자를 반환
	 */
	public static String getExt(String fileName) {
		
		String[] splited = fileName.split("\\.");
		if(splited.length ==1){
			return "";
		}else{
			return splited[splited.length-1];
			
		}
		
//		int lastIndex = fileName.lastIndexOf(".");
//		logger.debug("lastIndex : {}", lastIndex);
//		if(lastIndex == -1){
//			return "";
//			
//		}
//		String ext = fileName.substring(lastIndex+1);
//		return ext;
	}
	
	
}
