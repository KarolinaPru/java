<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Powtórzenie</title>
</head>
<body>
<fieldset>
<legend>Powtórzenie</legend>
<form>
Text 1: <input name="txt1" value="${param.txt1}" /></br>
Text 2: <input name="txt1" value="${initParam.hello} ${param.txt1}" /></br>
<input name="btn" type="submit" value="Submit" />
</form>
</fieldset>

</body>
</html>