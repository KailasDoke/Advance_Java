<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><form action="regForm" method="post">
	Name : <input type="text" name="name" placeholder="Enter your Name"><br/><br/>
	Email : <input type="text" name="email" placeholder="Enter your Email"><br/><br/>
	Password : <input type="password" name="pass" placeholder="Create your Password"><br/><br/>
	Gender : <input type="radio" name="gender" value="Male"> Male <input type="radio" name="gender" value="Female"> Female <br/><br/>
	City : <select name="city">
	        <option>Select City</option>
			<option>Mumbai</option>
			<option>Pune</option>
			<option>Delhi</option>
			<option>Jalna</option>
			</select><br/><br/>
	
	<input type="submit" value="Register"/>
	</form>
	</body>
</html>