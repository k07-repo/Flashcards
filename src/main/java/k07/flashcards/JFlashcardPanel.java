package k07.flashcards;

import org.apache.batik.swing.JSVGCanvas;

import javax.swing.*;
import java.awt.*;

public class JFlashcardPanel extends JPanel {

    public JSVGCanvas canvas = new JSVGCanvas();
    public JLabel kanjiLabel = new JLabel();
    public CharacterTuple kanji = null;

    public JFlashcardPanel() {
        this.setBorder(BorderFactory.createTitledBorder("Information"));
        this.setLayout(new GridLayout(1, 2));
        this.setupComponents();
    }

    private void setupComponents() {
        JPanel labelPanel = new JPanel(new BorderLayout());
        labelPanel.add(kanjiLabel, BorderLayout.CENTER);

        JButton revealButton = new JButton("Reveal info");
        revealButton.addActionListener(e -> {
            this.revealInfo();
        });
        labelPanel.add(revealButton, BorderLayout.SOUTH);
        this.add(labelPanel);

        canvas.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(canvas);
    }

    public void setKanji(CharacterTuple kanji) {
        this.kanji = kanji;
        this.kanjiLabel.setText(LabelBuilder.buildHiddenLabelHTML(kanji));
        this.setCanvasImage(kanji.imageURL);
    }

    public void revealInfo() {
        this.kanjiLabel.setText(LabelBuilder.buildLabelHTML(this.kanji));
    }


    public void setCanvasImage(String url) {
        this.canvas.setURI(url);
        canvas.repaint();
    }
}
