package com.example.default_javafx;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class HelloController {

    private String currentNumber = "";

    @FXML
    void button1Clicked() {
        addNumber("1");
    }

    public void addNumber(String number){
        currentNumber += number;
    }
}
