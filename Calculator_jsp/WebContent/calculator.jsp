<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="calc_style.css">
<meta charset="UTF-8">
<title>Calculator</title>
</head>
<body>
<jsp:useBean class="atj.Calculator" id="calculator" scope="session"/>

<% 
	int value = Integer.parseInt(request.getParameter("value"));

%>


	<form action="" method="POST">
		<table>
			<tr>
				<td colspan="4"><jsp:getProperty property="value"
						name="calculator" /></td>
				<td><input name="btn" class="button" type="submit" value="C" /></td>
			</tr>
			<tr>
				<td><input name="btn" class="button" type="submit" value="7" /></td>
				<td><input name="btn" class="button" type="submit" value="8" /></td>
				<td><input name="btn" class="button" type="submit" value="9" /></td>
				<td><input name="btn" class="button" type="submit" value="/" /></td>
				<td><input name="btn" class="button" type="submit" value="sqrt" /></td>
			</tr>
			<tr>
				<td><input name="btn" class="button" type="submit" value="4" /></td>
				<td><input name="btn" class="button" type="submit" value="5" /></td>
				<td><input name="btn" class="button" type="submit" value="6" /></td>
				<td><input name="btn" class="button" type="submit" value="*" /></td>
				<td><input name="btn" class="button" type="submit" value="%" /></td>
			</tr>
			<tr>
				<td><input name="btn" class="button" type="submit" value="1" /></td>
				<td><input name="btn" class="button" type="submit" value="2" /></td>
				<td><input name="btn" class="button" type="submit" value="3" /></td>
				<td><input name="btn" class="button" type="submit" value="-" /></td>
				<td rowspan="2"><input name="btn" class="button" id="equals" type="submit" value="=" /></td>
			</tr>
			<tr>
				<td><input name="btn" class="button" type="submit" value="0" /></td>
				<td><input name="btn" class="button" type="submit" value="." /></td>
				<td><input name="btn" class="button" type="submit" value="+/-" /></td>
				<td><input name="btn" class="button" type="submit" value="+" /></td>
			</tr>
		</table>
	</form>

</body>
</html>