package com.example.default_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {

    private String currentNumber = "";

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

    public void addNumber(String number){
        currentNumber += number;
    }
}