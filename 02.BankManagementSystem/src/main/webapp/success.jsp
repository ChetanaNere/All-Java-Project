<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

	function deleteUser() {
		document.fn.action = "delete";
		document.fn.submit();
	}
	
	function editUser()
	{
		document.fn.action="edit";
		document.fn.submit();
	}
	
	function addUser()
	{
		document.fn.action="opensignup";
		document.fn.submit();
	}
	
	function addmoney()
	{
		document.fn.action="deposite";
		document.fn.submit();
	}
	
	function withdraw()
	{
		document.fn.action="withdraw";
		document.fn.submit();
	}
</script>

</head>
<body>
<form name="fn">
<table border="1" solid
 style="border-collapse:collapse" align="center">
<tr>
<th>ACCNO</th>
<th>NAME</th>
<th>MOBILENO</th>
<th>AADHARNO</th>
<th>GENDER</th>
<th>AGE</th>
<th>BALENCE</th>
</tr>
<c:forEach items="${data}" var="a">

<tr>
	<td><input type="radio" name="accno" value="${a.accno}"></td>
	<td>${a.name}</td>
	<td>${a.mobno}</td>
	<td>${a.adharno}</td>
	<td>${a.gender}</td>
	<td>${a.age}</td>
	<td>${a.balence}</td>
	<!--  <a href="deposit?accno=${a.accno}">Deposit</a>--><td>
	<!--||<a href="withdraw?accno=${a.accno}">Withdraw</a>  -->				
	<!-- ||<a href="delete?accno=${a.accno}">DELETE</a> -->				
	<!--	||<a href="reg?accno=${a.accno}">Add New Account</a></td>  -->			
</tr>
</c:forEach>
</table>

<table border="2" align="center">
<tr>

<td><input type="button" value="DELETE" onclick="deleteUser()"></td>

<td><input type="button" value="DEPOSITE" onclick="addmoney()"></td>
<td><input type="button" value=" Withdraw" onclick=" withdraw()"></td>
<td><input type="button" value="ADDUSER" onclick=" addUser()"></td>

</tr>
</form>
</table>
</body>
</html>