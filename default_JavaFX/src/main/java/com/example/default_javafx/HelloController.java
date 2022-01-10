package com.example.default_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {

    @FXML
    private TextField textField;

    @FXML
    private Text savedNumbers;

    private String firstNumber = "";

    private String currentNumber = "0";

    private String calculationType;

    @FXML
    void addAction() {
        calculationSetup("+");
    }

    @FXML
    void minusAction() {
        calculationSetup("-");
    }

    @FXML
    void divideAction() {
        calculationSetup("/");
    }

    @FXML
    void multiplicationAction() {
        calculationSetup("*");
    }

    @FXML
    void squareAction() {
        calculationSetup("^2");
        calculateOnlyOneNumberNeeded();
    }

    @FXML
    void rootAction(){
        calculationSetup("^(1/2)");
        calculateOnlyOneNumberNeeded();
    }

    @FXML
    void inverseAction(){
        calculationSetup("^(-1)");
        calculateOnlyOneNumberNeeded();
    }

    @FXML
    void deleteAction(){
        if ((currentNumber != null) && (currentNumber.length() > 0)) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
            textField.setText(currentNumber);
        }
    }

    @FXML
    void percentAction(){
        double firstNumberDouble = Double.parseDouble(firstNumber);
        double currentNumberDouble = Double.parseDouble(currentNumber);
        currentNumberDouble *= firstNumberDouble / 100;
        currentNumber = String.valueOf(currentNumberDouble);
        textField.setText(currentNumber);
    }

    @FXML
    void decimalAction(){
        currentNumber = currentNumber.concat(".");
        textField.setText(currentNumber);
    }

    @FXML
    void negateAction(){
        calculationSetup("*(-1)");
        calculateOnlyOneNumberNeeded();
    }

    @FXML
    void cAction(){
        currentNumber = "";
        firstNumber = "";
        textField.setText(currentNumber);
        savedNumbers.setText("");
    }

    @FXML
    void ceAction(){
        currentNumber = "";
        textField.setText(currentNumber);
    }

    public void calculationSetup(String calculationType){
        this.calculationType = calculationType;
        firstNumber = currentNumber;
        currentNumber = "";
        savedNumbers.setText(firstNumber + " " + calculationType);
    }

    @FXML
    void calculate() {
        double firstNumberDouble = Double.parseDouble(firstNumber);
        double secondNumberDouble = Double.parseDouble(currentNumber);

        switch (calculationType) {
            case "+" -> {
                double calculatedNumber = firstNumberDouble + secondNumberDouble;
                savedNumbers.setText(firstNumber + " + " + currentNumber + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);           // go on with calculated number
            }
            case "-" -> {
                double calculatedNumber = firstNumberDouble - secondNumberDouble;
                savedNumbers.setText(firstNumber + " - " + currentNumber + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);           // go on with calculated number
            }
            case "/" -> {
                double calculatedNumber = firstNumberDouble / secondNumberDouble;
                savedNumbers.setText(firstNumber + " / " + currentNumber + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);           // go on with calculated number
            }
            case "*" -> {
                double calculatedNumber = firstNumberDouble * secondNumberDouble;
                savedNumbers.setText(firstNumber + " * " + currentNumber + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);           // go on with calculated number
            }
        }
    }

    @FXML
    void calculateOnlyOneNumberNeeded() {
        double firstNumberDouble = Double.parseDouble(firstNumber);

        switch (calculationType) {
            case "^2" -> {
                double calculatedNumber = firstNumberDouble * firstNumberDouble;
                savedNumbers.setText(firstNumber + " ^2 " + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);           // go on with calculated number
            }
            case "^(1/2)" -> {
                double calculatedNumber = Math.sqrt(firstNumberDouble);
                savedNumbers.setText(firstNumber + " ^(1/2) " + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);           // go on with calculated number
            }
            case "^(-1)" -> {
                double calculatedNumber = 1 / firstNumberDouble;
                savedNumbers.setText(firstNumber + " ^(-1) " + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);           // go on with calculated number
            }
            case "*(-1)" -> {
                double calculatedNumber = -firstNumberDouble;
                savedNumbers.setText(firstNumber + " *(-1) " + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);           // go on with calculated number
            }
        }


    }

    @FXML
    void clearTextField() {
        currentNumber = "";
        textField.setText("");
        savedNumbers.setText("");
    }

    @FXML
    void button0Clicked() {
        if(!currentNumber.equals("")){
            addNumber("0");
        }
    }

    @FXML
    void button1Clicked() {
        addNumber("1");
    }

    @FXML
    void button2Clicked() {
        addNumber("2");
    }

    @FXML
    void button3Clicked() {
        addNumber("3");
    }

    @FXML
    void button4Clicked() {
        addNumber("4");
    }

    @FXML
    void button5Clicked() {
        addNumber("5");
    }

    @FXML
    void button6Clicked() {
        addNumber("6");
    }

    @FXML
    void button7Clicked() {
        addNumber("7");
    }

    @FXML
    void button8Clicked() {
        addNumber("8");
    }

    @FXML
    void button9Clicked() {
        addNumber("9");
    }

    /* might not need it
    @FXML
    void buttonDeleteClicked() {
        int numberInt = Integer.parseInt(currentNumber);
        if (numberInt > 1){
            numberInt = numberInt / 10;     //hopefully cuts off the last digit
        } else if (numberInt == 1 || numberInt == 0) {
            numberInt = 0;
        }
        currentNumber = String.valueOf(numberInt);
        updateTextField();
    }
    */

    public void updateTextField(){
        textField.setText(currentNumber);
    }

    public void addNumber(String number){
        currentNumber += number;
        updateTextField();
    }

}
