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
	margin-top: 50px;
	color: rgb(12, 12, 12);
	border: solid;
	color: (black green blue);
	width: 10%; 
    height: 130px;
    border-spacing: 10px;
    border-collapse: collapse;
}
td{
 text-align: center; 
}

</style>
</head>
<body>
<form action="log">
<table>
<tr>
<th>NAME</th>
<th><input type="text" name="name"></th>
</tr>
<tr>

<th>ACCNO</th>
<th><input type="number" name="accno"></th>
</tr>

<tr>
				
<td ><input type="submit" value="LOGIN"></td>
<td><a href="opensignup">SIGNUP</a></td>
	</tr>

</table>
</form>
</body>
</html>