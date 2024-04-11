<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="sub">
		<pre>
		Account Details are :
		Account No.: <input type="number" name="accno" value="${data.accno}">
		Name 	   : <input type="text" name="name" value="${data.name}">
		Mobile No  : <input type="number" name="mobno" value="${data.mobno}">
		Aadhaar No : <input type="number" name="adharno" value="${data.adharno}">
		Gender	   : <input type="text" name="gender" value="${data.gender}">
		Age        : <input type="number" name="age" value="${data.age}">

		The available balance is : <input type="number" name="balence" value="${data.balence}">
	
		Enter Amount you want to withdraw :<input type="number" name="wd">
		Updated Balance : 
		<input type="submit" value="UPDATE BALANCE">
		</pre>
	</form>
</body>
</html>