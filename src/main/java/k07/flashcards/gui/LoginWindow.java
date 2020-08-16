package k07.flashcards.gui;

import k07.flashcards.utils.ComponentUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public final class LoginWindow extends JFrame {
    public LoginWindow() {
        this.setTitle("Login");

        JTextField urlField = new JTextField();
        JTextField userField = new JTextField();
        JTextField passField = new JPasswordField();

        //local database only
        urlField.setText("jdbc:mysql://127.0.0.1:3306/flashcards");
        urlField.setEditable(false);

        this.setLayout(new GridLayout(4, 1));
        this.add(ComponentUtils.componentWithLabel(urlField, "Database URL"));
        this.add(ComponentUtils.componentWithLabel(userField, "Username"));
        this.add(ComponentUtils.componentWithLabel(passField, "Password"));

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            boolean loginSuccessful = false; //DatabaseUtils.login(urlField.getText(), userField.getText(), passField.getText());
            if(loginSuccessful) {
                RootWindow rootWindow = new RootWindow();
                rootWindow.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Login failed!", "Error", JOptionPane.ERROR_MESSAGE);
            }

            //close this window
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });
        this.add(loginButton);
    }
}
