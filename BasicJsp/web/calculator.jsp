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

<form action="calculatorServlet" method="POST">
    <table>
        <tr>
            <td colspan="4"><input type="text" name="txtField" disabled value="${sessionScope.gui.txtField == null ? "" : sessionScope.gui.txtField }" /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="C" /></td>
        </tr>
        <tr>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="7"${sessionScope.gui.sevenEnabled}/></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="8" ${sessionScope.gui.eightEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="9" ${sessionScope.gui.nineEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="/" ${sessionScope.gui.divisionEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="sqrt"  ${sessionScope.gui.squareRootEnabled}/></td>
        </tr>
        <tr>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="4" ${sessionScope.gui.fourEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="5" ${sessionScope.gui.fiveEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="6" ${sessionScope.gui.sixEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="*" ${sessionScope.gui.multiplicationEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="%" ${sessionScope.gui.percentEnabled} /></td>
        </tr>
        <tr>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="1" ${sessionScope.gui.oneEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="2" ${sessionScope.gui.twoEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="3" ${sessionScope.gui.threeEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="-" ${sessionScope.gui.subtractionEnabled} /></td>
            <td rowspan="2"><input name="btn" id="equals" type="submit" class="btn btn-danger btn-lg outline" value="=" ${sessionScope.gui.equalsSignEnabled} /></td>
        </tr>
        <tr>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="0" ${sessionScope.gui.zeroEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="." ${sessionScope.gui.decimalSeparatorEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="+/-" ${sessionScope.gui.negationEnabled} /></td>
            <td><input name="btn" type="submit" class="btn btn-danger btn-lg outline" value="+" ${sessionScope.gui.additionEnabled} /></td>
        </tr>
    </table>
</form>
</body>
</html>