<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 검색 폼</title>
</head>
<body>
	<div align="center">
		<div><h1>멤버검색</h1></div>
		<div>
			<form id="frm" action="mSearch.do" method="post">
				<label>검색할 사용자 ID 입력: </label>
				<input type="text" id="userid" name="userid">
				<button type="submit">검색</button>
			</form>
		</div>
	</div>
</body>
</html>