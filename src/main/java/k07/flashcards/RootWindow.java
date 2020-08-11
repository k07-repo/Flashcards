package k07.flashcards;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RootWindow extends JFrame {

    private ArrayList<CharacterTuple> results;
    int currentPos = 0;

    public RootWindow() {
        JTextField characterField = new JTextField();
        JTextField meaningField = new JTextField();
        JTextField pronunciationField = new JTextField();

        this.setLayout(new GridLayout(5, 1));
        this.add(ComponentUtils.componentWithLabel(characterField, "Character"));
        this.add(ComponentUtils.componentWithLabel(meaningField, "Meaning"));
        this.add(ComponentUtils.componentWithLabel(pronunciationField, "test"));

        JButton retrieveButton = new JButton();
        retrieveButton.addActionListener(e -> {
           this.results = DatabaseUtils.getInfoFromTable("");
        });
        retrieveButton.setText("Retrieve list from database");
        this.add(retrieveButton);

        JButton goThroughButton = new JButton();
        goThroughButton.addActionListener(e -> {
           if(results == null || results.size() <= 0) {
               return;
           }
           else {
               currentPos++;
               if(currentPos >= results.size()) {
                   currentPos = 0;
               }
               CharacterTuple tuple = results.get(currentPos);
               characterField.setText(tuple.character);
               meaningField.setText(tuple.meaning);
           }
        });
        goThroughButton.setText("Retrieve next character");
        this.add(goThroughButton);
    }





}
