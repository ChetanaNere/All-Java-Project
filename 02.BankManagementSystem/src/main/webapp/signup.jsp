<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
	margin-left: auto;
	margin-right: auto;
	color: rgb(12, 12, 12);
	border: solid;
	color: (black green blue);
	width: 10%; 
    height: 130px;
    border-spacing: 10px;
 
    	margin-top: 50px;
}
.button{
 text-align: center;
}
</style>
</head>
<body>
<center>
<form action=save>
<pre>
<table>
<tr>
<td>ACCNO</td>
<td><input type="number" name="accno"></td>
</tr>

<tr>
<td>Name</td>
<td><input type="text" name="name"></td>
</tr>

<tr>
<td>MobNo</td>
<td><input type="number" name="mobno"></td>
</tr>

<tr>
<td>Aadharno</td>
<td><input type="number" name="adharno"></td>
</tr>

<tr>
<td>GENDER</td>
<td><input type="text" name="gender"></td>
</tr>

<tr>
<td>AGE</td>
<td><input type="number" name="age"></td>
</tr>

<tr>
<td>BALENCE</td>
<td><input type="number" name="balence"></td>
</tr>
<tr class="button">
<td><input type="submit" value="SIGNUP"></td>
</tr>
</table>
</pre>

</form>
</center>
</body>
</html>