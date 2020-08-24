package k07.flashcards.gui;

import k07.flashcards.tuples.CharacterTuple;
import k07.flashcards.utils.DialogUtils;
import k07.flashcards.utils.InternetUtils;
import k07.flashcards.utils.LabelBuilder;
import k07.flashcards.utils.SupportedCharacterList;
import org.apache.batik.swing.JSVGCanvas;

import javax.swing.*;

public class MainForm {
    private static final String[] grades = {"0 (no grade defined)", "1", "2", "3", "4", "5", "6", "Any"};
    private JTextField characterField;
    private JTextField apiKeyField;
    private JComboBox gradeBox;
    private JButton strokesButton;
    private JButton examplesButton;
    private JButton revealButton;
    private JButton retrieveButton;
    private JLabel kanjiLabel;
    private JSVGCanvas kanjiCanvas;
    private JPanel mainPanel;

    private CharacterTuple kanji = null;

    public MainForm() {
        this.setupComponents();
    }

    public void createMainForm() {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setupComponents() {
        //Kanji label
        this.kanjiLabel.setFont(this.kanjiLabel.getFont().deriveFont(14.0F));

        //Reveal button
        revealButton.addActionListener(e -> {
            if(this.kanji == null) {
                DialogUtils.displayErrorMessage("Look up a kanji first!");
                return;
            }
            this.revealInfo();
        });

        //Stroke order button
        strokesButton.addActionListener(e -> {
            if(this.kanji == null) {
                DialogUtils.displayErrorMessage("Look up a kanji first!");
                return;
            }
            this.openStrokeOrderWindow();
        });

        //Grade box
        for(String grade: grades) {
            gradeBox.addItem(grade);
        }
        
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
            this.setKanji(kanji);
        });
    }

    public void setKanji(CharacterTuple kanji) {
        this.kanji = kanji;
        this.kanjiLabel.setText(LabelBuilder.buildHiddenLabelHTML(kanji));
        this.setCanvasImage(kanji.imageURL);
    }

    public void setCanvasImage(String url) {
        this.kanjiCanvas.setURI(url);
        kanjiCanvas.repaint();
    }

    private void revealInfo() {
        this.kanjiLabel.setText(LabelBuilder.buildLabelHTML(this.kanji));
    }

    private void openStrokeOrderWindow() {
        KanjiStrokesWindow window = new KanjiStrokesWindow(this.kanji.strokeURLs);
        window.setVisible(true);
    }

}
