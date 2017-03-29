<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

    <title>Calculator</title>
</head>
<body>
<jsp:useBean class="com.karolina.CalculatorInterface" id="gui" scope="session"/>
<form action="calculatorServlet" method="POST">
    <table>
        <tr>
            <td colspan="4"><input type="text" name="txtField" disabled value="${gui.txtField == null ? "" : gui.txtField }" /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="C" /></td>
        </tr>
        <tr>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="7"${gui.sevenEnabled}/></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="8" ${gui.eightEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="9" ${gui.nineEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="/" ${gui.divisionEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="sqrt"  ${gui.squareRootEnabled}/></td>
        </tr>
        <tr>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="4" ${gui.fourEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="5" ${gui.fiveEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="6" ${gui.sixEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="*" ${gui.multiplicationEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="%" ${gui.percentEnabled} /></td>
        </tr>
        <tr>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="1" ${gui.oneEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="2" ${gui.twoEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="3" ${gui.threeEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="-" ${gui.subtractionEnabled} /></td>
            <td rowspan="2"><input name="btn" id="equals" type="submit" class="btn btn-danger btn-lg outline" value="=" ${gui.equalsSignEnabled} /></td>
        </tr>
        <tr>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="0" ${gui.zeroEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="." ${gui.decimalSeparatorEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="+/-" ${gui.negationEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="+" ${gui.additionEnabled} /></td>
        </tr>
    </table>
</form>
</body>
</html>