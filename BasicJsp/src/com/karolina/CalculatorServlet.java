package com.karolina;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/calculatorServlet")
public class CalculatorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private HttpSession session;
    private CalculatorInterface gui;
    private CalculatorLogic logic;
    private ArrayList<String> numbers;
    private Operation operation;
    private String enteredText;

    private void loadFromSession() {
        gui = (CalculatorInterface) session.getAttribute("gui");
        if (gui == null) {
            gui = new CalculatorInterface();
        }

        logic = (CalculatorLogic) session.getAttribute("logic");
        if (logic == null) {
            logic = new CalculatorLogic();
        }

        numbers = (ArrayList<String>) session.getAttribute("numbers");
        if (numbers == null) {
            numbers = new ArrayList<String>();
        }

        operation = (Operation) session.getAttribute("operation");
        if (operation == null) {
            operation = Operation.MULTIPLY;
        }

        enteredText = (String) session.getAttribute("enteredText");
        if (enteredText == null) {
            enteredText = new String();
        }
    }

    private void saveInSession() {
        session.setAttribute("gui", gui);
        session.setAttribute("logic", logic);
        session.setAttribute("numbers", numbers);
        session.setAttribute("operation", operation);
        session.setAttribute("enteredText", enteredText);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        loadFromSession();

        enteredText = gui.txtField;

        String btn = request.getParameter("btn");
        if (btn.equals("1"))
        {
            if (logic.validateIfIsNumberAndSaveAsLastValidInput("1"))
                gui.txtField = (enteredText + "1");
        }

        if (btn.equals("2"))
        {
            if (logic.validateIfIsNumberAndSaveAsLastValidInput("2"))
                gui.txtField = (enteredText + "2");
        }

        if (btn.equals("3"))
        {
            if (logic.validateIfIsNumberAndSaveAsLastValidInput("3"))
                gui.txtField = (enteredText + "3");
        }

        if (btn.equals("4"))
        {
            if (logic.validateIfIsNumberAndSaveAsLastValidInput("4"))
                gui.txtField = (enteredText + "4");
        }

        if (btn.equals("5"))
        {
            if (logic.validateIfIsNumberAndSaveAsLastValidInput("5"))
                gui.txtField = (enteredText + "5");
        }

        if (btn.equals("6"))
        {
            if (logic.validateIfIsNumberAndSaveAsLastValidInput("6"))
                gui.txtField = (enteredText + "6");
        }

        if (btn.equals("7"))
        {
            if (logic.validateIfIsNumberAndSaveAsLastValidInput("7"))
                gui.txtField = (enteredText + "7");
        }

        if (btn.equals("8"))
        {
            if (logic.validateIfIsNumberAndSaveAsLastValidInput("8"))
                gui.txtField = (enteredText + "8");
        }

        if (btn.equals("9"))
        {
            if (logic.validateIfIsNumberAndSaveAsLastValidInput("9"))
                gui.txtField = (enteredText + "9");
        }
        if (btn.equals("0"))
        {
            if (logic.validateIfIsNumberAndSaveAsLastValidInput("0"))
                gui.txtField = (enteredText + "0");
        }

        if (btn.equals("."))
        {
            if (logic.validateIfIsNumberAndSaveAsLastValidInput("."))
            {
                gui.txtField = (enteredText + ".");
                gui.disableDecimalSeparator();
            }
        }

        if (btn.equals("+/-"))
        {
            logic.negateLastValidInput();

            gui.txtField = (logic.lastValidInput);

            if (numbers.size() == 1)
            {
                gui.txtField = (numbers.get(0) + getOperationSign() + logic.lastValidInput);
            }
        }

        if (btn.equals("C"))
        {
            clearState();
        }

        if (btn.equals("+"))
        {
            handleOperationClick(Operation.ADD, "+");
        }
        if (btn.equals("-"))
        {
            handleOperationClick(Operation.SUBTRACT, "-");
        }

        if (btn.equals("*"))
        {
            handleOperationClick(Operation.MULTIPLY, "*");
        }

        if (btn.equals("/"))
        {
            handleOperationClick(Operation.DIVIDE, "/");
        }

        if (btn.equals("%"))
        {
            handleOperationClick(Operation.PERCENT, "%");
        }

        if (btn.equals("sqrt"))
        {
            if (logic.lastValidInput.isEmpty())
            {
                return;
            }

            double number = Double.parseDouble(logic.lastValidInput);
            String result = String.valueOf(Math.sqrt(number));

            gui.txtField = (result);
            numbers.clear();
            logic.lastValidInput = result;
        }

        if (btn.equals("="))
        {
            handleEquals();
        }

        saveInSession();
        request.getRequestDispatcher("/calculator.jsp").forward(request, response);
    }

    private String getOperationSign()
    {
        switch (operation)
        {
            case ADD:
                return "+";
            case SUBTRACT:
                return "-";
            case MULTIPLY:
                return "*";
            case DIVIDE:
                return "/";
            case PERCENT:
                return "%";
        }

        return "";
    }

    private void handleEquals()
    {
        if (logic.lastValidInput.isEmpty())
        {
            return;
        }

        addLastValidInputToNumbersList();

        if (numbers.size() < 2)
        {
            return;
        }

        double firstNumber = Double.parseDouble(numbers.get(0));
        double secondNumber = Double.parseDouble(numbers.get(1));
        String result = "";
        switch (operation)
        {
            case ADD:
                result = String.valueOf(firstNumber + secondNumber);
                gui.txtField = (result);
                break;
            case SUBTRACT:
                result = String.valueOf(firstNumber - secondNumber);
                gui.txtField = (result);
                break;
            case MULTIPLY:
                result = String.valueOf(firstNumber * secondNumber);
                gui.txtField = (result);
                break;
            case DIVIDE:
                result = String.valueOf(firstNumber / secondNumber);
                gui.txtField = (result);
                break;
            case PERCENT:
                result = String.valueOf(firstNumber / 100 * secondNumber);
                gui.txtField = (result);
                break;
        }

        numbers.clear();

        if (result.equals("NaN") || result.equals("Infinity"))
        {
            gui.txtField = ("Error");
            gui.disableControls();
            numbers.clear();
            logic.clear();
        } else
        {
            logic.lastValidInput = result;
            gui.enableControls();
        }
    }

    private void addLastValidInputToNumbersList()
    {
        numbers.add(logic.lastValidInput);
    }

    private void handleOperationClick(Operation operation, String symbol)
    {
        if (logic.lastValidInput.isEmpty())
        {
            return;
        }
        addLastValidInputToNumbersList();
        this.operation = operation;
        gui.txtField = (enteredText + symbol);
        logic.clear();
        gui.enableDecimalSeparator();
        gui.disableOperations();
    }

    private void clearState()
    {
        logic.clear();
        numbers.clear();
        gui.txtField = ("");
        gui.enableControls();
    }
}