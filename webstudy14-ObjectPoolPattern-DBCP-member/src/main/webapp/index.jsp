<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Object Pool Pattern : DBCP</title>
</head>
<body>
<h3>Object Pool Pattern : DBCP</h3>
<%--
	querystring : 처리할 서버프로그램 url?name=value
 --%>
<a href="front?command=Test">web test</a>
<br><br><br>
<h3>회원관리</h3>
<%--
	index -- Front --HandlerMapping -- Controller
										  |
									   GetTotalMemberCountController<-->MemberDao<-->DataSourceManager(DBCP)
									    	  |
									    	  |forward
									   member-count.jsp
--%>

<a href="front?command=GetTotalMemberCount">총 회원수 보기</a>
<br><br><br>

<form action="front" method="get">
  <input type = "hidden" name="command" value="FindMemberById">
<input type="text" name="memberId" required="required" placeholder="회원아이디">
<button type="submit">회원검색</button>
</form>
<br><br><br>

<form action="front" method="get">
  <input type = "hidden" name="command" value="FindMemberListByAddress">
<input type="text" name="memberAddress" required="required" placeholder="주소">
<button type="submit">회원검색</button>
</form>
<br><br><br>

<img src="front-all.png" width="70%">
</body>
</html>