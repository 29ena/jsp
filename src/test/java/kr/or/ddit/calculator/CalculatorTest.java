package kr.or.ddit.calculator;

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class CalculatorTest {
	
	// 2. 구분자는 두가지가 가능 : ",", ":"		"1,5:10,20" ==> 36
	@Test
	public void defaultSeparatorTest(){
		/***Given***/
		Calculator cal = new Calculator();
		String text = "1,5:10,20";
		/***When***/
		int result = cal.calculate(text);
		/***Then***/
		assertEquals(36, result);
	}
	
	// 3. 문자열이 공백이거나, null 이면은 0을 리턴 : "", null ==> 0
	@Test
	public void empty_test() {
		/***Given***/
		Calculator cal = new Calculator();
		String text = "";
		
		/***When***/
		int reulst = cal.calculate(text);
		/***Then***/
		assertEquals(0, reulst);
		
	}
	
	@Test
	public void null_test() {
		/***Given***/
		Calculator cal = new Calculator();
		String text = null;
		
		/***When***/
		int reulst = cal.calculate(text);
		/***Then***/
		assertEquals(0, reulst);
		
	}
	
	// 4. 문자열 시작이 "//"과 "\n" 통해 커스텀 구분자를 지정할 수 있다.
	@Test
	public void customSeparatorTest(){
		/***Given***/
		Calculator cal = new Calculator();
		String text = "//;\n1;5;10;20";

		/***When***/
		int result = cal.calculate(text);
		/***Then***/
		assertEquals(36, result);
	}
	
	@Test
	public void regexpCaptureTest(){
		/***Given***/
		String text = "//;\n1;5;10;20";

		/***When***/
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		m.find();
		String customSeparator = m.group(1);
		String textNumbers = m.group(2);
		
		/***Then***/
		assertEquals(";", customSeparator);
		assertEquals("1;5;10;20", textNumbers);
		
	}
	
	// 5. 숫자 구분자는 커스텀 구분자와, 기본 구분자 두가지를 섞어 사용할 수 있다.
	@Test
	public void custom_default_separatorTest(){
		/***Given***/
		Calculator cal = new Calculator();
		String text = "//;\n1;5;10:20";
		
		/***When***/
		int result = cal.calculate(text);
		
		/***Then***/
		assertEquals(36, result);
	}
	

}
