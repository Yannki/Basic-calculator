package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {
    //TODO: Fix scientific notation to general form
    //      Error handling

    @FXML // fx: id=textDisplay
    private Text textDisplay;
    private String numMemory = "";
    private double number;
    private String operation = "None";

    private static final String ERROR = "ERROR";

    /* @FXML // fx: id=textDisplay
     private Text textDisplay;
     private String prev = "";
     private double num;
     private String operation = "None";
     private boolean check = false;

     private static final String ERROR = "ERROR";*/
    public void buttonPressedNumber(Event event) {
        Button button = (Button) event.getSource();

        if (numMemory.length() < 7) {
            numMemory += button.getText();
            this.textDisplay.setText(numMemory);
        }
    }

    public void buttonPressedFloat(Event event) {
        Button button = (Button) event.getSource();
        if (numMemory.indexOf(".") == -1) {
            numMemory += button.getText();
            this.textDisplay.setText(numMemory);
        }
    }

    public void buttonPressedOperation(Event event) {
        Button button = (Button) event.getSource();

        operation = button.getText();
        number = Double.parseDouble(numMemory);
        System.out.println(number);
        numMemory = "";
    }

    public void buttonPressedEqual(Event event) {
        switch (operation) {
            case "+":
                number = Calculator.sumNumbers(number, Double.parseDouble(numMemory));
                this.textDisplay.setText(formatTextNumber(number));
                break;
            case "-":
                number = Calculator.subNumbers(number, Double.parseDouble(numMemory));
                this.textDisplay.setText(formatTextNumber(number));
                break;
            case "x":
                number = Calculator.multiNumbers(number, Double.parseDouble(numMemory));
                System.out.println(number);
                this.textDisplay.setText(formatTextNumber(number));
                break;
            case "/":
                number = Calculator.divideNumbers(number, Double.parseDouble(numMemory));
                this.textDisplay.setText(formatTextNumber(number));
                break;
            default:
                this.textDisplay.setText(numMemory);
                break;
        }
        numMemory = "";
    }

    private String formatTextNumber(double number) {
        String text = Double.toString(number);

        if (text.lastIndexOf(".0") > text.length() - 3) {
            return text.substring(0, text.indexOf("."));
        } else if (text.length() > 7) {
            return text.substring(0, 6);
        } else {
            return text;
        }
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
