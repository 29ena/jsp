# JSP & Servlet Learn
# :monocle: JSP 개념
JSP (JavaServer Pages ) 란 무엇인가?
<br>
<pre>
자바로 서버 페이지를 작성하기 위한 언어이다.
HTML과 JSP태그(스크립트릿)로 구성되어 화면을 작성하는 데 유리한 웹 프로그래밍 기술이다.
서버페이지는 __웹 서버에서 실행되는 페이지__ 를 말하며, 요청에 필요한 페이지를 위한 로직이나
데이터베이스와의 연동을 위해 필요한 것들을 포함한다.
서버 페이지에서 실행되는 로직을 구현하기 위해서는 프로그래밍 언어가 필요한데,
JSP에서는 자바를 사용하고 있다. 즉 , JSP에서는 자바언어로 로직(프로그램)을 구현한다.
</pre>

# :monocle: Servlet 개념
<pre>
웹프로그래밍에서 클라이언트의 요청을 처리하고 그 결과를 다시 클라이언트에게 
전송하는 Servlet 클래스의 구현 규칙을 지킨 자바 프로그래밍 기술
<br>
클라이언트의 요청에 대해 동적으로 작동하는 웹 어플리케이션 컴포넌트
html을 사용하여 요청에 응답한다.
Java Thread를 이용하여 동작한다.
MVC 패턴에서 Controller로 이용된다.
HTTP 프로토콜 서비스를 지원하는 javax.servlet.http.HttpServlet 클래스를 상속받는다. UDP보다 속도가 느리다.
HTML 변경 시 Servlet을 재컴파일해야 하는 단점이 있다.
</pre>
## :grin: 2019.05.20
<pre>
* BasicServlet 클래스 생성, servlet mapping 등록(web.xml)
* "BasicServlet 클래스 생성, servlet mapping 등록(web.xml)
* NowDateServlet 클래스 생성 , servlet mapping 등록(web.xml)(학생 실습)
* response content-type"
* "servlet life cycle
* timesServlet"
* "request parameter
* timesServlet request Parameter 적용(학생실습)
</pre>

## :grin: 2019.05.21
<pre>
*  "maven 프로젝트, 기본 서블릿 생성 실습(학생실습)git"
* "git 설치git 명령어 (git init, git status, git add, git commit, git remote, git push)"
* git 충돌시나리오 (gitTest, gitOther)
* git eclipse plugin 사용 방법
* "git eclipse clone
* logback 설정, 사용방법"
* "logback 설정, 사용방법
* jsp 기본 개념 (page 지시어, 스크립틀릿, 표현식, 주석)
* jsp timesTables 실습(학생실습)"
* "jsp timesTables 실습(학생실습)
* jsp factorial 실습(학생실습)"
* jsp 내장객체 (HttpServletRequest)
</pre>

## :grin: 2019.05.22
<pre>
* "전시간 복습 - helloWord servlet, helloWorld jsp
* timesTables.jsp 파라미터 적용(학생실습)"
* "timesTables.jsp 파라미터 적용 코드 리뷰
* request paramter 메소드 확인
* login.jsp, loginProcess.jsp
* bootstrap login 화면 적용"
* bootstrap login 화면 적용
* "redirect (response.sendRedirect)
* dispatch (requestDispatcher.forward(request, response)"
* login 프로세스 (redirect, dispatch 적용)
* "login 프로세스 (redirect, dispatch 적용)
* main.jsp bootstrap 적용"
* "jsp 실행원리 (서블릿 변환과정)
* url mapping 처리
* out, application
* application 객체를 통한 어플리케이션 내 자원 접근하기 실습"
* "application 객체를 통한 어플리케이션 내 자원 접근하기 실습
* 약간의 쉬는시간"
</pre>

## :grin: 2019.05.23
<pre>
"로그인 프로세스 복습(학생 실습)
 ( scope-세션 개념 포함)"
"로그인 프로세스 복습(학생 실습)
 ( scope-세션 개념 포함)

mybatis 설정"
"mybatis 설정(maven respository)
userDao userList 개발"
"userDao userList 수정 개발
exerd 설치, users테이블 설계"
"userDao getUser 코드, 테스트 코드 개발
junit 필요성, 설정
UserService userList, getUser 코드, 테스트 코드 작성(학생 실습)"
"UserService userList, getUser 코드, 테스트 코드 작성(학생 실습)
테스트 코드의 중요성"
"UserService userList, getUser 코드, 테스트 코드 작성(학생 실습)
"
"user 데이터 대량 생성하기
userService, userDao getUser 코드 작성
userService, userDao getUser 테스트 코드 작성
사용자 페이지 리스트 조회 쿼리 작성"
</pre>

## :grin: 2019.05.27
<pre>
사용자 리스트 조회 mvc 복습(학생 실습)
"사용자 리스트 조회 mvc 복습(학생 실습)

사용자 리스트 조회 mvc 반복"
"사용자 페이지 리스트 조회 쿼리 작성
사용자 페이지 리스트 조회 로직, 테스트 코드 작성(service, dao)"
"사용자 페이지 리스트 컨트롤러 로직 작성(테스트 코드 X)
page, pageSize 파라미터가 없을경우 default value 처리 (page = 1, pageSize = 10)"
"page, pageSize 파라미터가 없을경우 default value 처리 (page = 1, pageSize = 10)
pagination  처리 (usersCnt -> paginationSize 계산)
pagination  처리 로직에 따른 userService 로직 개선"
pagination  처리 (usersCnt -> paginationSize 계산)
pagination  처리 (pagination 화면 출력, li active class 추가)
pagination  처리 (pagination 화면 출력, li active class 추가, 이전 페이지, 다음 페이지 가기 버튼)
</pre>

## :grin: 2019.05.28
<pre>
"github 연동 설정 (학생실습)
웹 프로그래밍 흐름 파악(학생실습-주석달기)
에러 페이지 작성(404.html)"
"에러 페이지 작성(404.html->404.jsp)
상태유지 - 쿠키 테스트 코드 작성(학생실습)"
상태유지 - 쿠키 테스트 코드 작성(학생실습)
"상태유지 - 쿠키 테스트 코드 작성(교사 주도)
이클립스 디버깅 사용법"
"쿠키 코드 마이그레이션(자바->자바스크립트)
remember me cookie 적용(client side)"
remember me cookie 적용(client side)
remember me cookie 적용(server side)
jdbc 컨넥션, dbcp 컨넥션
</pre>

## :grin: 2019.05.29
<pre>
쿠키를 사용한 자동 로그인 기능 개발(학생실습)
"쿠키를 사용한 자동 로그인 기능 개발(학생실습)
dbcp connection pool 개선"
"dbcp connection pool 개선
jdni connection pool 개발"
"el
기존페이지 el 적용 (${pageContext.request.contextPath})"
"기존페이지 el 적용 (${pageContext.request.contextPath})
userList 사용자 데이터 el, jstl 적용"
"userPagingList 사용자 데이터 el, jstl 적용
테스트 주도 개발 예시(문자열 계산기)"
"테스트 주도 개발 예시(문자열 계산기)
jstl core set, if"
jstl core if, forEach
</pre>

## :grin: 2019.05.30
<pre>
"사용자 로그인 프로세스 개선(mock 데이터 -> db 데이터) 학생실습

jstl c:chose
header.jsp 사용자 아이디 표시 스크립틀릿, 표현식-> jstl, el"
"header.jsp 사용자 아이디 표시 스크립틀릿, 표현식 -> jstl, el
userPagingList.jsp 페이지네이션 스크립틀릿, 표현식 -> jstl, el"
"c:forEach  인덱스 반복문
maven cycle"
maven cycle
"maven 배포
사용자 생일 컬럼 추가
사용자 상세 페이지"
사용자 상세 페이지 화면 개발
"사용자 상세 페이지 로직 개발
사용자 페이징 리스트-> 상세페이지 이동 확인"
"사용자 페이징 리스트-> 상세페이지 이동 확인
사용자 사진 조회 servlet 개발"
</pre>

## :grin: 2019.05.31
<pre>
timeTables.jsp jstl, el 전환 -> timesTablesJstl.jsp (학생실습)
"날짜 사이 간격 평균 구하기 쿼리(학생실습)
주소 검색 api(다음주소)"
주소 검색 api(다음주소)
"사용자 등록 컨트롤러 개발(userFormController)
사용자 등록 쿼리, dao 개발(userDao.insertUser)"
사용자 등록 개발(dao, service, controller)
"사용자 등록 개발(dao, service, controller)
사용자 수정 개발(dao, service, controller)(학생실습)"
사용자 수정 개발(dao, service, controller)(학생실습)
사용자 수정 개발(dao, service, controller)(학생실습)
</pre>

## :grin: 2019.06.03
<pre>
"웹 프로그래밍 개념 정리 하기(학생  정리 - 중요개념 7가지 뽑아보기)
암호화
  사용자 업데이트 프로세스 해쉬 암호 적용"
"블록 암호화 알고리즘 테스트(kisa aria)
사용자 비밀번호 일괄수정(트랜잭션 개념 적용)"
"사용자 비밀번호 일괄수정(트랜잭션 개념 적용)
데이터 모델링 이론
게시판과제 설명"
"게시판과제 설명
데이터 모델링 예시 "
"데이터 모델링 예시 
smart editor 사용방법 진행"
"smart editor 사용방법 진행
게시판 실습 시작"
게시판 실습
</pre>

## :grin: 2019.06.04 ~ 2019.06.11
<pre>
게시판 실습
</pre>

## :grin: 2019.06.12
<pre>
게시판 실습
"게시판 과제 리뷰(박영춘 작성 소스코드)
vm 오라클 설치"
"vm 오라클 설치
jstl 국제화"
</pre>

## :grin: 2019.06.13
<pre>
jstl 국제화(fmt) - bundle, setBundle, message, param
"jstl 국제화(number) - formatNumber, parseNumber
jstl 국제화(date) - formatDatae, parseDate
jstl 국제화(timezone) - timezone, setTimezone"
"jstl 국제화(timezone) - timezone, setTimezone
jstl 국제화(select box 변경을 통한 locale 설정) - 학생실습"
"jstl 국제화(select box 변경을 통한 locale 설정) - 학생실습
jstl 국제화(select box 변경을 통한 locale 설정) - 교사실습"
"jstl 국제화(select box 변경을 통한 locale 설정) - 학생실습
커스텀 태그 만들기 - logging tag
커스텀 태그 만들기 - loopLogging tag"
"커스텀 태그 만들기 - colorLogging tag
커스텀 태그 만들기 - rangers.tag
커스텀 태그 만들기 - code.tag"
"커스텀 태그 만들기 - code.tag
Filter - 개념"
"Filter - logging filter
Filter - requestCount filter"
selectLocale - 학생실습
"Filter - requestCount filter
Filter - loginCheck filter"
"Filter - loginCheck filter
request wrapper - DefaultParamWrapper, DefaultParamFilter"
request wrapper - DefaultParamWrapper, DefaultParamFilter
Listener (session life cycle, session attribute)
"Listener (session attribute, application life cycle, session Binding)
 - pageContext.request.contextPath -> cp
mvc 패턴"
mvc 패턴 - front controller
</pre>

## :grin: 2019.06.17
<pre>
mvc 패턴 - front controller, RequetMapping, ViewResolver
mvc 패턴 - RequetMapping - db 연동(DbDao)
mvc 패턴 - RequetMapping - db 연동(DbDao)
git branch (orphan)
"git branch (orphan)
db index
db 아키텍처, sql 실행원리"
db 아키텍처, sql 실행원리
</pre>
