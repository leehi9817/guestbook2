<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/guestbook2/gbc" method="post">
		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
				<td><button type="submit">확인</button>
			</tr>
			<tr>
				<td><a href="/guestbook2/gbc?action=addList">메인으로 돌아가기</a></td>
			</tr>
		</table>
		<input type="text" name="action" value="delete">
		<input type="text" name="no" value="${param.no}">
	</form>
	
</body>
</html>