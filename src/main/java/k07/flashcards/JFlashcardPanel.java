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
        canvas.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(kanjiLabel);
        this.add(canvas);
    }

    public void setKanji(CharacterTuple kanji) {
        this.kanji = kanji;
        this.kanjiLabel.setText(kanji.buildLabelHTML());
        this.setCanvasImage(kanji.imageURL);
    }

    public void setCanvasImage(String url) {
        this.canvas.setURI(url);
        canvas.repaint();
    }
}
