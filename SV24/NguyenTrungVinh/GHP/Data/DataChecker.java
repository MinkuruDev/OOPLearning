package SV24.NguyenTrungVinh.GHP.Data;

import javax.swing.*;
import java.awt.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class DataChecker {
    public static boolean isPartialMatch(JTextField sub, String value){
        return value.toLowerCase().contains(sub.getText().toLowerCase());
    }

    public static boolean isPerfectMatch(JTextField text, int value){
        if(text.getText().equals(""))
            return true;
        return Integer.parseInt(text.getText()) == value;
    }

    public static boolean isInBounds(int value, JTextField lowerBounds, JTextField upperBounds){
        int low = lowerBounds.getText().equals("") ? Integer.MIN_VALUE : Integer.parseInt(lowerBounds.getText());
        int high = upperBounds.getText().equals("") ? Integer.MAX_VALUE : Integer.parseInt(upperBounds.getText());

        return low <= value && value <= high;
    }

    public static boolean isInBounds(long value, JTextField lowerBounds, JTextField upperBounds){
        long low = lowerBounds.getText().equals("") ? Long.MIN_VALUE : Long.parseLong(lowerBounds.getText());
        long high = upperBounds.getText().equals("") ? Long.MAX_VALUE : Long.parseLong(upperBounds.getText());

        return low <= value && value <= high;
    }

    public static boolean isInBounds(LocalDate value, JTextField lowerBounds, JTextField upperBounds){
        LocalDate low = lowerBounds.getText().equals("") ? LocalDate.MIN :
                LocalDate.parse(lowerBounds.getText());
        LocalDate high = upperBounds.getText().equals("") ? LocalDate.MAX :
                LocalDate.parse(upperBounds.getText());

        return (value.isAfter(low) || value.isEqual(low)) &&
                (value.isBefore(high) || value.isEqual(high));
    }

    public static void clearTextInside(JTextField... textFields){
        for (JTextField textField : textFields){
            textField.setText("");
        }
    }

    public static void clearTextInside(JTextField textField){
        textField.setText("");
    }

    public static void showAlertDialog(String msg){
        JOptionPane.showMessageDialog(null, msg, "Invalid data", JOptionPane.ERROR_MESSAGE);
    }

    public static boolean isValidDate(JTextField dateField, boolean alert){
        try {
            LocalDate.parse(dateField.getText());
            return true;
        }catch (DateTimeParseException e){
            if(alert)
                showAlertDialog(
                        String.format(
                                "\"%s\" is not valid date\nA valid date have format: yyyy-MM-dd",
                                dateField.getText()
                        ));
            clearTextInside(dateField);
        }
        return false;
    }

    public static boolean isValidTime(JTextField timeField, boolean alert){
        try {
            LocalTime.parse(timeField.getText());
            return true;
        }catch (DateTimeParseException e){
            if(alert)
                showAlertDialog(
                        String.format(
                                "\"%s\" is not valid time\nA valid time have format: hh:mm",
                                timeField.getText()
                        ));
            clearTextInside(timeField);
        }
        return false;
    }

    public static boolean isValidInt(JTextField intField, boolean alert){
        try {
            Integer.parseInt(intField.getText());
            return true;
        }catch (NumberFormatException e){
            if(alert)
                showAlertDialog(
                        String.format("\"%s\" is not valid number", intField.getText())
                );
            clearTextInside(intField);
        }

        return false;
    }

    public static boolean isNotEmpty(JTextField textField, String fieldName){
        if(textField.getText().equals("")){
            showAlertDialog(
                    fieldName + " Cannot be empty"
            );
            return false;
        }

        return true;
    }

    public static boolean isListNumber(JTextArea textArea, String fieldName){
        String text = textArea.getText().trim();
        if(text.equals("")) return true;

        if(! text.matches("(\\d+\\s+)*(\\d+)")){
            showAlertDialog("Invalid input at " + fieldName);
            return false;
        }
        return true;
    }
}
