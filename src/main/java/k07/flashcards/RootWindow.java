package k07.flashcards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class RootWindow extends JFrame {

    public RootWindow() {
        JTextField characterField = new JTextField();
        JTextField meaningField = new JTextField();
        JTextField pronunciationField = new JTextField();

        this.setLayout(new GridLayout(4, 1));
        this.add(ComponentUtils.componentWithLabel(characterField, "Character"));
        this.add(ComponentUtils.componentWithLabel(meaningField, "Meaning"));
        this.add(ComponentUtils.componentWithLabel(pronunciationField, "test"));

        JButton retrieveButton = new JButton();
        retrieveButton.addActionListener(e -> {
           CharacterTuple tuple = DatabaseUtils.getInfoFromTable("");
           characterField.setText(tuple.character);
           meaningField.setText(tuple.meaning);
        });
        this.add(retrieveButton);
    }



}
