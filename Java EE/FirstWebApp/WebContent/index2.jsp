

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="simple" scope="session" class="atj.Simple"/>
<jsp:setProperty property="*" name="simple"/>		

<%// poszukaj we właściwościach strony wartość dla takiej nazwy %>

	<%
		simple.setCounter(simple.getCounter() + 1);
	%>

	<h1>Nowa strona</h1>
	<br>
	<form action="index2.jsp" method="get">
		<h3>Metoda get</h3>
		Imię: <br> <input name="firstName" value="<%=simple.getFirstName()%>" /> <br>
		Nazwisko: <br> <input name="lastName" value="<%=simple.getLastName()%>" /> <br>
		Counter: <%=simple.getCounter()%><br>

		<input type="submit" name="btn" value="OK" /> 
		<input type="submit" name="btn" value="Cancel" />
	</form>
	<br>
	<form action="index2.jsp" method="post">
		<h3>Metoda post</h3>
		Imię: <br> <input name="firstName" value="<%=simple.getFirstName()%>" /> <br>
		Nazwisko: <br> <input name="lastName" value="<%=simple.getLastName()%>" /> <br>
		Counter: <%=simple.getCounter()%><br>

		<input type="submit" name="btn" value="OK" /> 
		<input type="submit" name="btn" value="Cancel" />
	</form>
	
	
</body>
</html>