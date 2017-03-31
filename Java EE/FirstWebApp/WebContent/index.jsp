<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	// Dzięki temu w 1 sesji counter nie będzie się zerował
	
		int counter = session.getAttribute("counter") == null ? 0 : (Integer)session.getAttribute("counter");
		counter++;
		
		// zapisuję w sesji wartość wyciągniętego countera
		// wartość licznika jest przechowywana na serwerze, nie w przeglądarce!
		session.setAttribute("counter", counter);
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");


		if (firstName == null) {
			firstName = "";
		}
		if (lastName == null) {
			lastName = "";
		}
	%>

	<h1>Nowa strona</h1>
	<br>
	<form>

		Imię: <br> <input name="firstName" value="<%=firstName%>" /> <br>
		Nazwisko: <br> <input name="lastName" value="<%=lastName%>" /> <br>
		Counter: <%=counter%><br>

		<input type="submit" name="btn" value="OK" /> 
		<input type="submit" name="btn" value="Cancel" />

	</form>
	<br>
	<form>
		City: <input name="city" value=""> <input type="submit"
			name="btn" value="OK"> <input type="submit" name="btn"
			value="Cancel">
	</form>
</body>
</html>