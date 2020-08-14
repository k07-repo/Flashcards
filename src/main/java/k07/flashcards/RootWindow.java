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
        this.setLayout(new GridLayout(4, 2));
        this.setupWindowComponents();
        this.addWindowListener(new CloseApplicationListener());
    }

    private void setupWindowComponents() {
        JFlashcardPanel panel = new JFlashcardPanel();
        this.add(panel);

        JButton retrieveButton = new JButton();
        retrieveButton.addActionListener(e -> {
            CharacterTuple kanji = InternetUtils.obtainMapForKanji(characterField.getText(), apiKeyField.getText());
            panel.setKanji(kanji);
        });
        retrieveButton.setText("Lookup");
        this.add(retrieveButton);

        this.add(ComponentUtils.componentWithLabel(characterField, "Character"));
        this.add(ComponentUtils.componentWithLabel(apiKeyField, "API Key"));
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
