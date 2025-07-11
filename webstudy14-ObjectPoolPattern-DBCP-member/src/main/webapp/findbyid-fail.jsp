<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>find fail</title>
</head>
<body>
 	<script type="text/javascript">
 	 alert("${param.id}회원이 아닙니다");
 	 location.href = "index.jsp"; 
 	</script>
</body>
</html>