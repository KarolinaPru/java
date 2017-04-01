<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:set var="langExt" value="es"/>
<c:if test="${param.lang!=null}">
<c:set var="langExt" value="${param.lang}"/>

</c:if>
<fmt:setLocale value="${langExt}"/>
<fmt:setBundle basename="internationalization.FirstBundle" var="lang" scope="session"/>	
	
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<title>Formularze, czytanie parametrów z sesji, bootstrap, ustawienia językowe</title>
</head>

<body>

	<jsp:useBean class="atj.Counter" id="counter" scope="session"/>
	
	<fieldset>
		<legend>Bootstrap i bundle językowe</legend>
		
		<form action="Second" method="POST">
		<div class="form-group">
			<label for="txt1"><fmt:message key="text.title" bundle="${lang}"/></label>
			<input class="form-control" id="txt1" name="txt1" value="${param.txt1}"/>
		</div>
		<div class="form-group">
			<label for="txt2"><fmt:message key="text.choose" bundle="${lang}"/></label>
			<input class="form-control" id="txt2" name="txt2" value="${param.txt1}"/>
		</div>
		<div class="form-group">
			<label for="counter">Counter:</label>
			<input class="form-control" id="counter" name="counter" value="${counter.value}"/>
		</div>
		<br>
		<div class="form-group">
		<input type="submit" class="btn btn-success" name="btn" value="Submit" />
		<input type="submit" class="btn btn-success" name="clr_btn" value="Clear" />
		</div>
		</form>

		
		<br>
		<h2>Architektura typu 2</h2>
		<form action="Second" method="POST">
			Text 1: <input name="txt1" value="${param.txt1}" />  
			Text 2: <input name="txt1" value="${initParam.hello} ${param.txt1}" />
			Counter: <input name="counter" value="${counter.value}"/>
			<input name="btn" type="submit" value="Submit" /> 
			<input name="clr_btn" type="submit" value="Clear" />
		</form>
	</fieldset>

</body>
</html>