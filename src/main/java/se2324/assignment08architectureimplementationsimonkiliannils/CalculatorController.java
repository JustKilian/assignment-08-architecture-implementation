package se2324.assignment08architectureimplementationsimonkiliannils;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculatorController {
    public Button calculate;
    @FXML
    private TextField input;

    @FXML
    private Label output;

    @FXML
    protected void onButtonClick() {
        String input = this.input.getText();
        if (input.isEmpty()) {
            output.setText("0");
        } else {
            output.setText(calculate(input));
        }
    }

    private String calculate(String input) {
        if (input.contains("+")) {
            return add(input);
        } else if (input.contains("-")) {
            return subtract(input);
        } else if (input.contains("*") || input.contains("x")) {
            return multiply(input);
        } else if (input.contains("/") || input.contains(":") || input.contains("÷")) {
            return divide(input);
        } else {
            return input;
        }
    }

    private String divide(String input) {
        ArrayList<String> inputList = new ArrayList<>(Arrays.asList(input.split("/")));
        if (inputList.size() == 1) {
            inputList = new ArrayList<>(Arrays.asList(input.split(":")));
            if (inputList.size() == 1) {
                inputList = new ArrayList<>(Arrays.asList(input.split("÷")));
                if (inputList.size() == 1) {
                    return input;
                }
            }
        }
        double result = Double.parseDouble(inputList.getFirst());
        for (String s : inputList.subList(1, inputList.size())) {
            result /= Double.parseDouble(s);
        }
        return String.valueOf(result);
    }

    private String multiply(String input) {
        ArrayList<String> inputList = new ArrayList<>(Arrays.asList(input.split("\\*")));
        if (inputList.size() == 1) {
            inputList = new ArrayList<>(Arrays.asList(input.split("x")));
            if (inputList.size() == 1) {
                return input;
            }
        }
        double result = Double.parseDouble(inputList.getFirst());
        for (String s : inputList.subList(1, inputList.size())) {
            result *= Double.parseDouble(s);
        }
        return String.valueOf(result);
    }

    private String subtract(String input) {
        ArrayList<String> inputList = new ArrayList<>(Arrays.asList(input.split("-")));
        double result = Double.parseDouble(inputList.getFirst());
        for (String s : inputList.subList(1, inputList.size())) {
            result -= Double.parseDouble(s);
        }
        return String.valueOf(result);
    }

    private String add(String input) {
        ArrayList<String> inputList = new ArrayList<>(Arrays.asList(input.split("\\+")));
        double result = Double.parseDouble(inputList.getFirst());
        for (String s : inputList.subList(1, inputList.size())) {
            result += Double.parseDouble(s);
        }
        return String.valueOf(result);
    }
}