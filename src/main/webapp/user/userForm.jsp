<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



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

<title>사용자 등록</title>

<!-- css, js -->
<%@include file="/common/basicLib.jsp" %>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
   var msg = '${msg}';
   	if(msg != ''){
   		alert(msg);
   	}
   $(document).ready(function(){
	   // 주소찾기 버튼 클릭 이벤트 핸들러
	   $("#addrSearchBtn").on("click",function(){
			new daum.Postcode({
		    oncomplete: function(data) {
		            // 주소 input value에 설정 data.roadAddress
		            // 우편번호 input value에 설정 data.zonecode
		            
		            $("#addr1").val(data.roadAddress);
		            $("#zipcd").val(data.zonecode);
		        }
		    }).open();
	   });
	   
	   // 사용자 등록 버튼 클릭 이벤트 핸들러
	   $("#userRegBtn").on("click", function(){
			// 유효성 체크
			
			// 여기까지 도달하면 유효성 검사 완료(submit)
			$("#frm").submit();
	   })
	   
	   // 개발용 데이터 초기화 함수 ** 추후 지울것
	  // dataInit();
	   
   });
   

</script>
</head>

<body>
   
   <!-- header.jsp -->
   <%@include file="/common/header.jsp" %>
   
   <div class="container-fluid">
      <div class="row">

         <!-- left -->
         <%@include file="/common/left.jsp" %>
         
         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="row">
               <div class="col-sm-8 blog-main">
                  <h2 class="sub-header">사용자등록</h2>
                  
                  <form id= "frm" class="form-horizontal" role="form"
                  		action="${cp }/userForm"
                  		method="post"
                  		enctype="multipart/form-data">
      				 <div class="form-group">
                           <label for="file" class="col-sm-2 control-label">사용자 사진</label>
                        <div class="col-sm-10">
                        	<input type="file" id="profile" name="profile" />
                        </div>
                     </div>
                     <div class="form-group">
                        <label for="userId" class="col-sm-2 control-label">사용자 아이디</label>
                        <div class="col-sm-10">
                               <input type="text" class="form-control" id="userId" name="userId"
                                placeholder="사용자 아이디" value="${param.userId }">
                        </div>
                     </div>
                     
                     <div class="form-group">
                        <label for="pass" class="col-sm-2 control-label">비밀번호</label>
                        <div class="col-sm-10">
                        <input type="password" class="form-control" id="pass" name="pass"
                                placeholder="비밀번호" value="${param.pass }">
                        </div>
                     </div>
      
                     <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">사용자 이름</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="name" name="name"
                                placeholder="사용자 이름"value="${param.name }">
                        </div>
                     </div>
                     
                     <div class="form-group">
                        <label for="alias" class="col-sm-2 control-label">별명</label>
                        <div class="col-sm-10">
                           <input type="text" class="form-control" id="alias" name="alias"
                                placeholder="별명" value="${param.alias }">
                        </div>
                     </div>
                     
                     <div class="form-group">
                        <label for="addr1" class="col-sm-2 control-label">주소</label>
                        <div class="col-sm-8" >
                            <input type="text" class="form-control" id="addr1" name="addr1"
                                placeholder="주소" readonly value="${param.addr1}">
                        </div>
                        <div class="col-sm-2" align="right">
                            <button type="button" id="addrSearchBtn" class="btn btn-default">주소검색</button>
                        </div>
                     </div>
                     
                     <div class="form-group">
                        <label for="addr2" class="col-sm-2 control-label">상세주소</label>
                        <div class="col-sm-10">
                          <input type="text" class="form-control" id="addr2" name="addr2"
                                placeholder="상세주소" value="${param.addr2}">
                        </div>
                     </div>
                     
                     <div class="form-group">
                        <label for="zipcd" class="col-sm-2 control-label">우편번호</label>
                        <div class="col-sm-10">
                           <input type="text" class="form-control" id="zipcd" name="zipcd"
                                placeholder="우편번호" readonly value="${param.zipcd}">
                        </div>
                     </div>
                     
                     <div class="form-group">
                        <label for="birth" class="col-sm-2 control-label">생일</label>
                        <div class="col-sm-10">
                        <input type="date" class="form-control" id="birth" name="birth"
                                placeholder="생일" value="${param.birth}">
                        </div>
                     </div>
                     
                     
                     
                     <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                          
                           <button  id="userRegBtn" type="button" class="btn btn-default">사용자 등록</button>
                        </div>
                     </div>
                     
                     
                    
                     
                  </form>
               </div>
            </div>
         </div>
      </div>
   </div>
</body>
</html>