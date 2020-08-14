package k07.flashcards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EventListener;

import org.apache.batik.swing.JSVGCanvas;

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
        optionPanel.setLayout(new GridLayout(3, 1));
        optionPanel.setBorder(BorderFactory.createTitledBorder("Options"));
        optionPanel.add(ComponentUtils.componentWithLabel(characterField, "Character (leave blank to randomize)"));
        optionPanel.add(ComponentUtils.componentWithLabel(apiKeyField, "API Key"));

        JButton retrieveButton = new JButton();
        retrieveButton.addActionListener(e -> {
            String charString = characterField.getText();
            if(charString.isEmpty()) {
                charString = SupportedCharacterList.getRandomCharacter();
            }
            CharacterTuple kanji = InternetUtils.obtainMapForKanji(charString, apiKeyField.getText());
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
