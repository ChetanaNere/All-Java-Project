<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 align="center">EDIT DATA</h1>
</head>
<body>
<form action="update">
<table border="1">
<tr>
<td>AccNo:-</td>
<td><input type="hidden" name="accno" value="${data.accno} "></td>
</tr>
<tr>
<td>Name:-</td>
<td><input type="text" name="name" value="${data.name}"></td>
</tr>
<tr>
<td>MobNo:-</td>
<td><input type="number" name="mobno" value="${data.mobno}"></td>
</tr>
<tr>
<td>AdharNo:-</td>
<td><input type="number" name="adharno" value="${data.adharno}"></td>
</tr>
<tr>
<td>Gender:-</td>
<td><input type="text" name="gender" value="${data.gender}"></td>
</tr>
<tr>
<td>Age:-</td>
<td><input type="text" name="adharno" value="${data.adharno}"></td>
</tr>
<tr>
<td>Balence:-</td>
<td><input type="number" name="balence" value="${data.balence}"></td>
</tr>

<tr>
<td><input type="submit" value="UPDATE"></td>

</tr>
</table>
</form>
</body>
</html>