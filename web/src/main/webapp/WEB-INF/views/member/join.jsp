<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="joinRequest" method="post">
		<table border="1">
			<tr>
				<th>성명</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="number" name="age"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<label><input type="radio" name="gender" value="male" checked="checked">남자</label>
					<label><input type="radio" name="gender" value="female">여자</label>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="submit" value="HttpServletRequest">
					<input type="submit" value="@RequestParam" onclick="action='joinRequestParam'">
					<input type="submit" value="데이터 객체" onclick="action='joinDataObject'">
					<input type="submit" value="@PathVariable" onclick="go_submit(this.form)">
				</td>
			</tr>
		</table>
	</form>
	
	<script type="text/javascript">
		function go_submit(f){
			f.action = 'joinPath/' + f.name.value + '/' + f.gender.value + '/' +  
						f.email.value + '/' + f.age.value;
		}
	</script>
	
</body>
</html>