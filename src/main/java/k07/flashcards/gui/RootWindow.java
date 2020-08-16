package k07.flashcards.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import k07.flashcards.utils.DialogUtils;
import k07.flashcards.utils.SupportedCharacterList;
import k07.flashcards.tuples.CharacterTuple;
import k07.flashcards.utils.ComponentUtils;
import k07.flashcards.utils.InternetUtils;

public class RootWindow extends JFrame {

    private ArrayList<CharacterTuple> results;
    int currentPos = 0;

    JTextField characterField = new JTextField();
    JTextField apiKeyField = new JTextField();


    public RootWindow() {
        this.setTitle("Kanji Flashcards");
        this.setLayout(new GridLayout(2, 2));
        this.setupWindowComponents();
        this.addWindowListener(new CloseApplicationListener());
    }

    private void setupWindowComponents() {
        JFlashcardPanel panel = new JFlashcardPanel();
        this.add(panel);

        JPanel optionPanel = new JPanel();
        optionPanel.setLayout(new GridLayout(4, 1));
        optionPanel.setBorder(BorderFactory.createTitledBorder("Options"));
        optionPanel.add(ComponentUtils.componentWithLabel(characterField, "Character (leave blank to randomize)"));
        optionPanel.add(ComponentUtils.componentWithLabel(apiKeyField, "API Key"));

        String[] grades = {"0 (no grade defined)", "1", "2", "3", "4", "5", "6", "Any"};
        JComboBox gradeBox = new JComboBox(grades);
        optionPanel.add(ComponentUtils.componentWithLabel(gradeBox, "Grade"));
        JButton retrieveButton = new JButton();
        retrieveButton.addActionListener(e -> {
            char character;

            if(!characterField.getText().isEmpty()) {
                character = characterField.getText().charAt(0);
            }
            else {
                if(gradeBox.getSelectedItem().toString().equals("Any")) {
                    character = SupportedCharacterList.getRandomCharacter();
                }
                else {
                    character = SupportedCharacterList.getRandomCharacterByGrade(gradeBox.getSelectedIndex());
                }
            }

            String apiKey = apiKeyField.getText();
            if(apiKey.length() <= 0) {
                DialogUtils.displayErrorMessage("You must enter your RapidAPI key!");
                return;
            }
            CharacterTuple kanji = InternetUtils.obtainMapForKanji(character, apiKeyField.getText());
            panel.setKanji(kanji);
        });
        retrieveButton.setText("Lookup");
        optionPanel.add(retrieveButton);
        this.add(optionPanel);
    }

    private class CloseApplicationListener implements WindowListener {
        public void windowOpened(WindowEvent e){}
        public void windowClosing(WindowEvent e){System.exit(0);}
        public void windowClosed(WindowEvent e){}
        public void windowIconified(WindowEvent e){}
        public void windowDeiconified(WindowEvent e){}
        public void windowActivated(WindowEvent e){}
        public void windowDeactivated(WindowEvent e){}
    }





}
