<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles.css">

    <meta charset="UTF-8">
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>Ustawienia</title>
</head>

<form action="/calculatorServlet" method="post">
<div class="heading">
    <h2>Wybierz styl</h2>
</div>
    <br>
    <div class="btns-group">
        <div class="link"><a href="/Calculator/calculator.jsp" class="btn btn-danger outline" value="styles-red" role="button">1</a></div>
        <div class="link"><a href="/Calculator/calculator.jsp" class="btn btn-success outline" value="styles-green" role="button">2</a></div>
        <div class="link"><a href="/Calculator/calculator.jsp" class="btn btn-info outline" value="styles-blue" role="button">3</a></div>
        <div class="link"><a href="/Calculator/calculator.jsp" class="btn btn-warning outline" value="styles-yellow" role="button">4</a></div>
    </div>
</form>
</body>
</html>
