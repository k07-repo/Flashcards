package k07.flashcards;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class RootWindow extends JFrame {

    private ArrayList<CharacterTuple> results;
    int currentPos = 0;

    public RootWindow() {
        JTextField characterField = new JTextField();
        JTextField meaningField = new JTextField();
        JTextField readingField = new JTextField();

        this.setLayout(new GridLayout(6, 1));
        this.add(ComponentUtils.componentWithLabel(characterField, "Character"));
        this.add(ComponentUtils.componentWithLabel(meaningField, "Meaning"));
        this.add(ComponentUtils.componentWithLabel(readingField, "test"));

        JButton retrieveButton = new JButton();
        retrieveButton.addActionListener(e -> {
           this.results = DatabaseUtils.getInfoFromTable("");
        });
        retrieveButton.setText("Retrieve list from database");
        this.add(retrieveButton);

        JButton goThroughButton = new JButton();
        goThroughButton.addActionListener(e -> {
           if(results == null) {
               characterField.setText("Error: database is null!");
           }
           else if(results.size() <= 0) {
               characterField.setText("Error: database is empty!");
           }
           else {
               currentPos++;
               if(currentPos >= results.size()) {
                   currentPos = 0;
               }
               CharacterTuple tuple = results.get(currentPos);
               characterField.setText(tuple.character);
               meaningField.setText(tuple.meaning);
               readingField.setText(tuple.reading);
           }
        });
        goThroughButton.setText("Retrieve next character");
        this.add(goThroughButton);

        JButton shuffleButton = new JButton();
        shuffleButton.addActionListener(e -> {
           Collections.shuffle(results);
           currentPos = 0;
        });
        shuffleButton.setText("Shuffle list");
        this.add(shuffleButton);
    }





}
