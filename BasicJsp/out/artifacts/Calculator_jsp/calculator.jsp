<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="styles.css">
    <meta charset="UTF-8">
    <title>Calculator</title>
</head>
<body>

<form action="calculatorServlet" method="POST">
    <table>
        <tr>
            <td colspan="4"><input type="text" name="txtField" value="${sessionScope.txtFieldText}" /></td>
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