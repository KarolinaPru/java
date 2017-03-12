<%--
  Created by IntelliJ IDEA.
  User: Karolina
  Date: 12-Mar-17
  Time: 07:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="calc_style.css">
    <meta charset="UTF-8">
    <title>Calculator</title>
</head>
<body>

<%
    Map map = request.getParameterMap();
    Object[] keys = map.keySet().toArray();

    StringBuilder display = new StringBuilder();
    String displayedValue = "0";
    boolean isOperation;
    String operation = "(\\+|\\-|\\*|\\/|\\%|\\.|\\sqrt){1}";
    String currentParam;


    for (int k = 0; k < keys.length; k++) {
        String[] pars = request.getParameterValues((String) keys[k]);

        for (int j = 0; j < pars.length; j++) {
            currentParam = pars[j];
            isOperation = currentParam.matches(operation);

            if (currentParam.equals("C")) {
                display = new StringBuilder();
                display.append('0');

            } else {
                display.append(pars[j]);
            }
        }
    }

    displayedValue = display.toString();
%>



<form action="" method="POST">
    <table>
        <tr>
            <td colspan="4"><input name="display" type="text" value="<%= displayedValue %>"/></td>
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