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
            <td colspan="4"><input type="text" name="txtField" disabled value="${sessionScope.gui.txtField == null ? "" : sessionScope.gui.txtField }" /></td>
            <td><input name="btn" class="button" type="submit" value="C" /></td>
        </tr>
        <tr>
            <td><input name="btn" class="button" type="submit" value="7" ${sessionScope.gui.sevenEnabled} /></td>
            <td><input name="btn" class="button" type="submit" value="8" ${sessionScope.gui.eightEnabled} /></td>
            <td><input name="btn" class="button" type="submit" value="9" ${sessionScope.gui.nineEnabled} /></td>
            <td><input name="btn" class="button" type="submit" value="/" ${sessionScope.gui.divisionEnabled} /></td>
            <td><input name="btn" class="button" type="submit" value="sqrt"  ${sessionScope.gui.squareRootEnabled}/></td>
        </tr>
        <tr>
            <td><input name="btn" class="button" type="submit" value="4" ${sessionScope.gui.fourEnabled} /></td>
            <td><input name="btn" class="button" type="submit" value="5" ${sessionScope.gui.fiveEnabled} /></td>
            <td><input name="btn" class="button" type="submit" value="6" ${sessionScope.gui.sixEnabled} /></td>
            <td><input name="btn" class="button" type="submit" value="*" ${sessionScope.gui.multiplicationEnabled} /></td>
            <td><input name="btn" class="button" type="submit" value="%" ${sessionScope.gui.percentEnabled} /></td>
        </tr>
        <tr>
            <td><input name="btn" class="button" type="submit" value="1" ${sessionScope.gui.oneEnabled} /></td>
            <td><input name="btn" class="button" type="submit" value="2" ${sessionScope.gui.twoEnabled} /></td>
            <td><input name="btn" class="button" type="submit" value="3" ${sessionScope.gui.threeEnabled} /></td>
            <td><input name="btn" class="button" type="submit" value="-" ${sessionScope.gui.subtractionEnabled} /></td>
            <td rowspan="2"><input name="btn" class="button" id="equals" type="submit" value="=" ${sessionScope.gui.equalsSignEnabled} /></td>
        </tr>
        <tr>
            <td><input name="btn" class="button" type="submit" value="0" ${sessionScope.gui.zeroEnabled} /></td>
            <td><input name="btn" class="button" type="submit" value="." ${sessionScope.gui.decimalSeparatorEnabled} /></td>
            <td><input name="btn" class="button" type="submit" value="+/-" ${sessionScope.gui.negationEnabled} /></td>
            <td><input name="btn" class="button" type="submit" value="+" ${sessionScope.gui.additionEnabled} /></td>
        </tr>
    </table>
</form>
</body>
</html>