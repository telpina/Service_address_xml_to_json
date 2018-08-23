<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Demo rest web service</title>
</head>
<body>


<form action="DemoController" method="get" >
<table>
<tr>
<td>Input adress, please:</td>
<td> <input type = "text" name="adress"></td>
</tr>
<tr>
<td>For example </td><td> </td>
</tr>
<tr>
<td>prague+zelivecka+14</td><td></td>
</tr>
<tr>
<td>moscow+lenina+15</td><td></td>
</tr>

<tr>
<td align="right" colspan="2"><input type = "submit" value="Send"></td>
<td></td>
</tr>
</table>
</form>
</body>
</html>