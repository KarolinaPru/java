package atj;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

@ManagedBean(name="calculator", eager=true)
@SessionScoped
public class Calculator {

    private ArrayList<Operation> operations = new ArrayList<>();
    private Operation operation;
    private String arg1;
    private String arg2;
    private String result = "";
    private String symbol;

    public Calculator() {
        operations.add(new Operation("+"));
        operations.add(new Operation("-"));
        operations.add(new Operation("*"));
        operations.add(new Operation("/"));
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }

    public void setOperations(ArrayList<Operation> operations) {
        this.operations = operations;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getArg1() {
        return(arg1);
    }
    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2 ;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getResult() {
        return result;
    }

    public String getResult(String arg1, String arg2, String symbol) {
        int x = Integer.parseInt(arg1);
        int y = Integer.parseInt(arg2);
        int z = 0;
        this.symbol = symbol;
        symbol = operation.getSymbol();


        switch (symbol) {
            case "+":
                z = x + y;
                break;
            case "-":
                z = x -y;
                break;
            case "*":
                z = x * y;
                break;
            case "/":
                z = x / y;

        }

        return String.valueOf(z);
    }


    public void setResult(String result) {
    }


    public String redirectToResultPage() {
        return "result.xhtml";
    }
    public String enterArgumentsActionControllerMethod() {
        return "calculator";  // Czyli idziemy do strony index.xhtml
    }
}
