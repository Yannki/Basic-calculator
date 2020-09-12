package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {

    private Text textDisplay;
    private String prev = "";
    private double num;
    private String operation = "None";
    private boolean check = false;

    private static final String ERROR = "ERROR";

   /* @FXML // fx: id=textDisplay
    private Text textDisplay;
    private String prev = "";
    private double num;
    private String operation = "None";
    private boolean check = false;

    private static final String ERROR = "ERROR";*/
    public void buttonPressedNumber(Event event) {

    }

    public void buttonPressedFloat (Event event){

    }

    public void buttonPressedOperation(Event event) {

    }

    public void buttonPressedEqual(Event event) {

    }

    public void buttonPressedPercentage(Event event) {
        double num = Double.parseDouble(prev);
        num = Calculator.percentage(num);
        prev = Double.toString(num);

    }
/*
    public void buttonPressedNumber(Event event) {
        Button button = (Button) event.getSource();
        if (check) {
            num = Double.parseDouble(prev);
            prev = "";
            check = false;
        }

        if (prev.length() < 6) {
            this.textDisplay.setText(prev + button.getText());
            prev = prev + button.getText();
        }
    }

    public void buttonPressedFloat (Event event){
        Button button = (Button) event.getSource();
        if (prev.length() < 5 && !prev.contains(".") && prev.length() > 0) {
            this.textDisplay.setText(prev + button.getText());
            prev = prev + button.getText();
        }
    }

    public void buttonPressedOperation(Event event) {
        Button button = (Button) event.getSource();
        operation = button.getText();
        System.out.println(operation);
        check = true;
    }

    public void buttonPressedEqual(Event event) {
        double result = 0;
        double num2 = Double.parseDouble(prev);
        String text;

        switch (operation) {
            case "+":
                result = Calculator.sumNumbers(num, num2);
                text = String.format("%4.2f%n",result);
                this.textDisplay.setText(text);
                break;
            case "-":
                result = Calculator.subNumbers(num, num2);
                text = String.format("%4.2f%n",result);
                this.textDisplay.setText(text);
                break;
            case "x":
                result = Calculator.multiNumbers(num, num2);
                text = String.format("%4.2f%n",result);
                this.textDisplay.setText(text);
                break;
            case "/":
                if (num2 != 0) {
                    result = Calculator.divideNumbers(num, num2);
                    text = String.format("%4.2f%n",result);
                    this.textDisplay.setText(text);
                } else {
                    this.textDisplay.setText(ERROR);
                }
                break;
        }
        prev = "";
        num = 0;
    }

    public void buttonPressedPercentage(Event event) {
        double num = Double.parseDouble(prev);
        num = Calculator.percentage(num);
        prev = Double.toString(num);

    }*/
}
