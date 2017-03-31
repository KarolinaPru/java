package com.karolina;

public class CalculatorInterface {
    public String txtField = "";

    public String getTxtField(){
        return txtField;
    }

    public String getDecimalSeparatorEnabled() {
        return decimalSeparatorEnabled;
    }

    public String getTxtFieldEnabled() {
        return txtFieldEnabled;
    }

    public String getOneEnabled() {
        return oneEnabled;
    }

    public String getTwoEnabled() {
        return twoEnabled;
    }

    public String getThreeEnabled() {
        return threeEnabled;
    }

    public String getFourEnabled() {
        return fourEnabled;
    }

    public String getFiveEnabled() {
        return fiveEnabled;
    }

    public String getSixEnabled() {
        return sixEnabled;
    }

    public String getSevenEnabled() {
        return sevenEnabled;
    }

    public String getEightEnabled() {
        return eightEnabled;
    }

    public String getNineEnabled() {
        return nineEnabled;
    }

    public String getZeroEnabled() {
        return zeroEnabled;
    }

    public String getAdditionEnabled() {
        return additionEnabled;
    }

    public String getSubtractionEnabled() {
        return subtractionEnabled;
    }

    public String getMultiplicationEnabled() {
        return multiplicationEnabled;
    }

    public String getDivisionEnabled() {
        return divisionEnabled;
    }

    public String getSquareRootEnabled() {
        return squareRootEnabled;
    }

    public String getNegationEnabled() {
        return negationEnabled;
    }

    public String getPercentEnabled() {
        return percentEnabled;
    }

    public String getEqualsSignEnabled() {
        return equalsSignEnabled;
    }

    public String decimalSeparatorEnabled;
    public String txtFieldEnabled;
    public String oneEnabled;
    public String twoEnabled;
    public String threeEnabled;
    public String fourEnabled;
    public String fiveEnabled;
    public String sixEnabled;
    public String sevenEnabled;
    public String eightEnabled;
    public String nineEnabled;
    public String zeroEnabled;
    public String additionEnabled;
    public String subtractionEnabled;
    public String multiplicationEnabled;
    public String divisionEnabled;
    public String squareRootEnabled;
    public String negationEnabled;
    public String percentEnabled;
    public String equalsSignEnabled;

    public void disableDecimalSeparator()
    {
        decimalSeparatorEnabled = "disabled";
    }

    public void enableDecimalSeparator()
    {
        decimalSeparatorEnabled = "";
    }

    public void disableControls()
    {
        txtFieldEnabled = "disabled";
        oneEnabled = "disabled";
        twoEnabled = "disabled";
        threeEnabled = "disabled";
        fourEnabled = "disabled";
        fiveEnabled = "disabled";
        sixEnabled = "disabled";
        sevenEnabled = "disabled";
        eightEnabled = "disabled";
        nineEnabled = "disabled";
        zeroEnabled = "disabled";
        additionEnabled = "disabled";
        subtractionEnabled = "disabled";
        multiplicationEnabled = "disabled";
        divisionEnabled = "disabled";
        squareRootEnabled = "disabled";
        negationEnabled = "disabled";
        percentEnabled = "disabled";
        decimalSeparatorEnabled = "disabled";
        equalsSignEnabled = "disabled";
    }

    public void enableControls()
    {
        txtFieldEnabled = "";
        oneEnabled = "";
        twoEnabled = "";
        threeEnabled = "";
        fourEnabled = "";
        fiveEnabled = "";
        sixEnabled = "";
        sevenEnabled = "";
        eightEnabled = "";
        nineEnabled = "";
        zeroEnabled = "";
        additionEnabled = "";
        subtractionEnabled = "";
        multiplicationEnabled = "";
        divisionEnabled = "";
        squareRootEnabled = "";
        negationEnabled = "";
        percentEnabled = "";
        decimalSeparatorEnabled = "";
        equalsSignEnabled = "";
    }

    public void disableOperations()
    {
        additionEnabled = "disabled";
        subtractionEnabled = "disabled";
        multiplicationEnabled = "disabled";
        divisionEnabled = "disabled";
        squareRootEnabled = "disabled";
        percentEnabled = "disabled";
    }
}
