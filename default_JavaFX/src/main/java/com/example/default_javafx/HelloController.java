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

    private String currentNumber = "";

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

    public void calculationSetup(String calculationType){
        this.calculationType = calculationType;
        firstNumber = currentNumber;
        currentNumber = "";
        savedNumbers.setText(firstNumber + " " + calculationType);
    }

    @FXML
    void calculate() {
        int firstNumberInt = Integer.parseInt(firstNumber);
        int secondNumberInt = Integer.parseInt(currentNumber);

        switch (calculationType) {
            case "+" -> {
                int calculatedNumber = firstNumberInt + secondNumberInt;
                savedNumbers.setText(firstNumber + " + " + currentNumber + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);           // go on with calculated number
            }
            case "-" -> {
                int calculatedNumber = firstNumberInt - secondNumberInt;
                savedNumbers.setText(firstNumber + " - " + currentNumber + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);           // go on with calculated number
            }
            case "/" -> {
                double calculatedNumber = firstNumberInt / (double)secondNumberInt;
                savedNumbers.setText(firstNumber + " / " + currentNumber + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);           // go on with calculated number
            }
            case "*" -> {
                int calculatedNumber = firstNumberInt * secondNumberInt;
                savedNumbers.setText(firstNumber + " * " + currentNumber + " = " + calculatedNumber);
                textField.setText(String.valueOf(calculatedNumber));
                currentNumber = String.valueOf(calculatedNumber);           // go on with calculated number
            }
        }
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

    public void updateTextField(){
        textField.setText(currentNumber);
    }

    public void addNumber(String number){
        currentNumber += number;
        updateTextField();
    }

}
