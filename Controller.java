package sample;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {
    //TODO: Showing scientific notation
    //      Error handling

    @FXML // fx: id=textDisplay
    private Text textDisplay;
    private String numMemory = "";
    private double number;
    private String operation = "None";

    private static final String ERROR = "REPETITION ERROR";

    public void buttonPressedNumber(Event event) {
        Button button = (Button) event.getSource();

        if (numMemory.length() < 7) {
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

    public void buttonPressedFloat(Event event) {
        Button button = (Button) event.getSource();
        if (numMemory.indexOf(".") == -1) {
            numMemory += button.getText();
            this.textDisplay.setText(numMemory);
        }
    }

    public void buttonPressedPercentage(Event event){
        double number = Double.parseDouble(numMemory);
        number = Calculator.percentage(number);
        numMemory = Double.toString(number);
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

    public void buttonPressedRestart(Event event){
        numMemory = "";
        number = 0;
        operation = "None";
    }

    private String formatTextNumber(double number) {
        String text;
        if (number > 999999){
            text = "NaN";
        } else {
            text = Double.toString(number);
        }

        if (text.lastIndexOf(".0") > text.length() - 3) {
            return text.substring(0, text.indexOf("."));
        } else if (text.length() > 7) {
            return text.substring(0, 7);
        } else {
            return text;
        }
    }
}
