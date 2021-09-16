<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 다중 검색</title>
</head>
<body>
<div align = "center">
	<div><h1>게시글 다중 검색</h1></div>  <!-- 작성자와 제목을 동시에 검색할수 있게 만들기 -->
	<div>
		<form action="bMultiSearch.do" method="post">
			<label>검색선택: </label>
			<select style="width:200px" name="key" id="key">  <!-- (name)key의 값(value)= writer, title -->
    			<option value="writer">Writer</option>
    			<option value="title">Title</option> 			
  			</select>
  			<input type="text" id="keyValue" name="keyValue">
  			<input type="submit" value="Search"> 
		</form>
	</div>
</div>
</body>
</html>