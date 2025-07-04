<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp로 테이블 만들기</title>
<style>
table {
	width: 100%;
	border-collapse: collapse; /* 테두리 겹치게 설정*/
}

th {
	background-color: rgb(200, 300, 400);
}

th, td {
	border: 1px solid black; /* 테두리 설정 */
	padding: 8px; /* 셀 안쪽 여백 */
	text-align: center;
}
</style>
</head>
<body>
	<%
	ArrayList<String> list = new ArrayList<String>();
	list.add("마라탕");
	list.add("콜라");
	list.add("치킨");
	list.add("갈비");
	list.add("곱창");
	%>
	<table>
		<thead>
			<tr>
				<th>순번</th>
				<th>메뉴</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < list.size(); i++) {
			%>

			<tr>
				<td><%=i + 1%></td>
				<td><%=list.get(i)%></td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>
</body>
</html>










