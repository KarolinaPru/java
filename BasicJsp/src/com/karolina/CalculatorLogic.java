package com.karolina;

public class CalculatorLogic
{
    public String lastValidInput = "";

    public static void main(String[] args)
    {
        CalculatorLogic cl = new CalculatorLogic();
        cl.unitTest(".", false);
        cl.unitTest(".34", false);
        cl.unitTest("2.3.3", false);
        cl.unitTest("1,2", false);
        cl.unitTest("0", true);
        cl.unitTest("7", true);
        cl.unitTest("2..2", false);
        cl.unitTest("2.2", true);
        cl.unitTest("00", false);
        cl.unitTest("00.asdfa", false);
        cl.unitTest("12345", true);
        cl.unitTest("12345asdf", false);
        cl.unitTest("asdf12345", false);
        cl.unitTest("+2", false);
        cl.unitTest("-2", true);
        cl.unitTest("--2", false);
    }

    public boolean validateIfIsNumberAndSaveAsLastValidInput(char newInput){
        return validateIfIsNumberAndSaveAsLastValidInput(String.valueOf(newInput));
    }

    public boolean validateIfIsNumberAndSaveAsLastValidInput(String newInput)
    {
        String inputCandidate = lastValidInput + newInput;

        if(!inputCandidate.matches("^\\-?\\d*\\.?\\d*$"))
            return false;

        if(inputCandidate.matches("^0{2,}"))
            return false;

        if(inputCandidate.matches("^\\."))
            return false;

        lastValidInput = inputCandidate;
        return true;
    }

    public boolean isLastValidNumberPositive()
    {
        if(this.lastValidInput.startsWith("-")){
            return false;
        }
        return true;
    }

    public void negateLastValidInput(){
        if (!this.isLastValidNumberPositive())
        {
            StringBuilder numberNegation = new StringBuilder();
            numberNegation.append(this.lastValidInput);
            numberNegation.replace(0, 1, "");
            this.lastValidInput = numberNegation.toString();
        } else
        {
            this.lastValidInput = "-" + this.lastValidInput;
        }
    }

    public void clear()
    {
        lastValidInput = "";
    }

    public void unitTest(String input, boolean expectedResult)
    {
        boolean wasNotValidOnceOrMore = false;
        for (int i = 0; i < input.length(); i++)
        {
            if (!this.validateIfIsNumberAndSaveAsLastValidInput(input.charAt(i)))
            {
                wasNotValidOnceOrMore = true;
            }
        }

        boolean testPassed = (expectedResult != wasNotValidOnceOrMore);

        if (testPassed)
        {
            System.out.println(input + " " + expectedResult + " TEST PASSED");
        } else
        {
            System.out.println(input + " " + expectedResult + " TEST FAILED");
        }
        this.clear();
    }
}

