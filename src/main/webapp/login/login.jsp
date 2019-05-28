<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%=request.getContextPath() %>/css/signin.css" rel="stylesheet">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	
	<script>
		$(document).ready(function(){
			// 문서 로딩이 완료되고 나서 실행되는 부분			
			// rememberme checkbox
			// 1. rememberme cookie가 있는지?, 있으면 값이 true인지?
			// 1-1. rememberme가 true이면 input id="rememeberme" 체크박스를 체크
			
			var rememberme = getCookie("rememberme");
			if(rememberme == "true"){
				$("#rememberme").prop("checked",true);
				$("#userId").val(getCookie("userId"));
				$("#password").focus();
			}	
				$("#signinBtn").on("click",function(){
					// 만약에 rememberme 체크박스가 체크되어 있는 경우
					// 사용자 아이디 값을 userId 쿠키로 저장
					// true 값을 rememberme cookie 값으로 저장
					if($("#rememberme").is(":checked")){
						setCookie("userId",$("#userId").val(), 30);
						setCookie("rememberme", "true", 30);
					}
					// 만약에 rememberme 체크박스가 해제되어 잇는 경우
					// userId, rememeberme cookie 값을 삭제
					else{
						deleteCookie("userId");
						deleteCookie("rememberme");
						
					}
					
					// 로그인 요청을 서버로 전송 (frm은 form태그의 id)
					$("#frm").submit();
					
				});
			
		});
		
		// 쿠키를 저장
		// expires : 현재날짜로 부터 몇일동안 유효한지 일자 (정수)
		function setCookie(cookieName, cookieValue, expires){
			var dt = new Date();
			dt.setDate(dt.getDate() + parseInt(expires));
			
			document.cookie = cookieName + "=" + cookieValue + "; path=/; expires" +
				dt.toGMTString();
		}
		
		// 쿠키를 삭제
		function deleteCookie(cookieName, cookieValue, expires){
			setCookie(cookieName, "",-5);
		}
		
		// 쿠키 이름에 해당하는 쿠키 값을 조회
		function getCookie(cookieName){
 			//String[] cookieArray = CookieUtil.cookieString.split("; ");
			var cookieArray = document.cookie.split("; ");
			// String cookieValue = "";
			var cookieValue = "";
			//for(String str : cookieArray){
			for(var i = 0; i < cookieArray.length; i++){
				//if(str.startsWith(cookie + "=")){	
				var str = cookieArray[i];
				if(str.startsWith(cookieName+"=")){
					//String[] cookieStr = str.split("=");
					var cookieStr = str.split("=");
					
					//cookieValue = cookieStr[1];
					cookieValue = cookieStr[1];
					break;
				}
			}	
			return cookieValue;
		}
	</script>
  </head>

  <body>

    <div class="container">

      <form id="frm" class="form-signin" action="<%=request.getContextPath() %>/login" method="post">
      
        <h2 class="form-signin-heading">Please sign in</h2>
        
        <label for="userId"  class="sr-only">userId</label>
        <input type="text" name="userId" id="userId" class="form-control" placeholder="userId" required >
        
        <label for="inputPassword"  class="sr-only">Password</label>
        <input type="password" name="password" id="password" value="brown1234" class="form-control" placeholder="Password" required>
        
        <div class="checkbox">
          <label>
            <input id="rememberme" type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button id="signinBtn" class="btn btn-lg btn-primary btn-block" type="button">Sign in</button>
      </form>

    </div> <!-- /container -->


  </body>
</html>
