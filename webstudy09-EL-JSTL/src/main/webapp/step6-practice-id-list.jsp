<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>step6-practice-id-list.jsp</title>
<style>
        table {
            width: 100%;
            border-collapse: collapse; /* 테두리 겹치게 설정*/
        }
        th{
            background-color: rgb(200,300,400);
        }
        th, td {
            border: 1px solid black; /* 테두리 설정 */
            padding: 8px; /* 셀 안쪽 여백 */
            text-align: center;
        }
    </style>
</head>
<body>
<h3>step6-practice-id-list.jsp</h3>
<h4>${param.id}인 회원명단</h4>
<table>
	<thead>
		<tr>
			<th>아이디</th>
			<th>이름</th>
		</tr>
	</thead>
	<tbody>
	
		<tr>
			<td>${param.id }</td>
			<td>${requestScope.member.name}</td>
		</tr>
	
	</tbody>

</table>



</body>
</html>