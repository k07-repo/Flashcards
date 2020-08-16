package k07.flashcards.utils;

import javax.swing.*;

public class DialogUtils {
    public static void displayErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
