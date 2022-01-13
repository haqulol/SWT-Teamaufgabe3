package com.example.default_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.lang.Math;

public class HelloController {

    @FXML
    private TextField textField;    // Displays result

    @FXML
    private Text savedNumbers;      // Displays last calculation

    private String firstNumber = "";

    private String currentNumber = "";

    private String calculationType;     // calculation operator

    private boolean firstNumberOnDisplay = false;

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
    void rootAction() {
        calculationSetup("^(1/2)");
        calculateOnlyOneNumberNeeded();
    }

    @FXML
    void inverseAction() {
        calculationSetup("^(-1)");
        calculateOnlyOneNumberNeeded();
    }

    @FXML
    void deleteAction() {
        if (firstNumberOnDisplay) {
            if ((firstNumber != null) && (firstNumber.length() > 0)) {
                firstNumber = firstNumber.substring(0, firstNumber.length() - 1);
                textField.setText(firstNumber);
            }
        } else {
            if ((currentNumber != null) && (currentNumber.length() > 0)) {
                currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
                textField.setText(currentNumber);
            }
        }
    }

    @FXML
    void percentAction() {
        double firstNumberDouble = Double.parseDouble(firstNumber);
        double currentNumberDouble = Double.parseDouble(currentNumber);
        currentNumberDouble *= firstNumberDouble / 100;
        currentNumber = String.valueOf(currentNumberDouble);
        textField.setText(currentNumber);
    }

    @FXML
    void decimalAction() {
        if (firstNumberOnDisplay) {
            if (!(firstNumber.contains("."))) {
                firstNumber = firstNumber.concat(".");
                textField.setText(firstNumber);
            }
        } else {
            if (!(currentNumber.contains("."))) {
                currentNumber = currentNumber.concat(".");
                textField.setText(currentNumber);
            }
        }
    }

    @FXML
    void negateAction() {
        if (firstNumberOnDisplay) {
            switch (firstNumber) {
                case "" -> firstNumber = "-";
                case "-" -> firstNumber = "";
                case "." -> firstNumber = "-.";

                default -> {
                    double firstNumberDouble = Double.parseDouble(firstNumber);
                    double calculatedNumber = -firstNumberDouble;
                    firstNumber = String.valueOf(calculatedNumber);           // go on with calculated number
                }
            }
            textField.setText(firstNumber);
        } else {
            switch (currentNumber) {
                case "" -> currentNumber = "-";
                case "-" -> currentNumber = "";
                case "." -> currentNumber = "-.";

                default -> {
                    double currentNumberDouble = Double.parseDouble(currentNumber);
                    double calculatedNumber = -currentNumberDouble;
                    currentNumber = String.valueOf(calculatedNumber);           // go on with calculated number
                }
            }
            textField.setText(currentNumber);
        }
    }

    @FXML
    void cAction() {
        currentNumber = "";
        firstNumber = "";
        textField.setText(currentNumber);
        savedNumbers.setText("");
        firstNumberOnDisplay = true;
    }

    @FXML
    void ceAction() {
        currentNumber = "";
        textField.setText(currentNumber);
    }

    public void calculationSetup(String calculationType) {
        this.calculationType = calculationType;
        if ((firstNumber.equals("") && (!currentNumber.equals("-")))){
            firstNumber = currentNumber;
        }
        currentNumber = "";
        savedNumbers.setText(firstNumber + " " + calculationType);
        firstNumberOnDisplay = false;
    }

    @FXML
    void calculate() {
        if ((!firstNumber.equals("")) && (!currentNumber.equals(""))){
            double firstNumberDouble = Double.parseDouble(firstNumber);
            double secondNumberDouble = Double.parseDouble(currentNumber);

            switch (calculationType) {
                case "+" -> {
                    double calculatedNumber = firstNumberDouble + secondNumberDouble;
                    savedNumbers.setText(firstNumber + " + " + currentNumber + " = " + calculatedNumber);
                    textField.setText(String.valueOf(calculatedNumber));
                    firstNumber = String.valueOf(calculatedNumber);           // go on with calculated number
                }
                case "-" -> {
                    double calculatedNumber = firstNumberDouble - secondNumberDouble;
                    savedNumbers.setText(firstNumber + " - " + currentNumber + " = " + calculatedNumber);
                    textField.setText(String.valueOf(calculatedNumber));
                    firstNumber = String.valueOf(calculatedNumber);           // go on with calculated number
                }
                case "/" -> {
                    if (secondNumberDouble != 0) {
                        double calculatedNumber = firstNumberDouble / secondNumberDouble;
                        savedNumbers.setText(firstNumber + " / " + currentNumber + " = " + calculatedNumber);
                        textField.setText(String.valueOf(calculatedNumber));
                        firstNumber = String.valueOf(calculatedNumber);           // go on with calculated number
                    }
                }
                case "*" -> {
                    double calculatedNumber = firstNumberDouble * secondNumberDouble;
                    savedNumbers.setText(firstNumber + " * " + currentNumber + " = " + calculatedNumber);
                    textField.setText(String.valueOf(calculatedNumber));
                    firstNumber = String.valueOf(calculatedNumber);           // go on with calculated number
                }
            }
            firstNumberOnDisplay = true;
        }

    }

    @FXML
    void calculateOnlyOneNumberNeeded() {
        if (!(firstNumber.equals("")) && !(firstNumber.equals("-"))){
            double firstNumberDouble = Double.parseDouble(firstNumber);

            switch (calculationType) {
                case "^2" -> {
                    double calculatedNumber = firstNumberDouble * firstNumberDouble;
                    savedNumbers.setText(firstNumber + " ^2 " + " = " + calculatedNumber);
                    textField.setText(String.valueOf(calculatedNumber));
                    firstNumber = String.valueOf(calculatedNumber);           // go on with calculated number
                }
                case "^(1/2)" -> {
                    double calculatedNumber = Math.sqrt(firstNumberDouble);
                    savedNumbers.setText(firstNumber + " ^(1/2) " + " = " + calculatedNumber);
                    textField.setText(String.valueOf(calculatedNumber));
                    firstNumber = String.valueOf(calculatedNumber);           // go on with calculated number
                }
                case "^(-1)" -> {
                    double calculatedNumber = 1 / firstNumberDouble;
                    savedNumbers.setText(firstNumber + " ^(-1) " + " = " + calculatedNumber);
                    textField.setText(String.valueOf(calculatedNumber));
                    firstNumber = String.valueOf(calculatedNumber);           // go on with calculated number
                }
            }
            firstNumberOnDisplay = true;
        }
    }

    @FXML
    void button0Clicked() {
        addNumber("0");
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

    public void addNumber(String number) {
        if (firstNumberOnDisplay) {
            firstNumber += number;
            textField.setText(firstNumber);
        } else {
            currentNumber += number;
            textField.setText(currentNumber);
        }
    }

}
