package k07.flashcards.gui;

import k07.flashcards.tuples.CharacterTuple;
import k07.flashcards.utils.DialogUtils;
import k07.flashcards.utils.LabelBuilder;
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
        this.kanjiLabel.setFont(this.kanjiLabel.getFont().deriveFont(14.0F));
        JPanel labelPanel = new JPanel(new BorderLayout());
        labelPanel.add(kanjiLabel, BorderLayout.CENTER);

        JButton revealButton = new JButton("Reveal info");
        revealButton.addActionListener(e -> {
            if(this.kanji == null) {
                DialogUtils.displayErrorMessage("Look up a kanji first!");
                return;
            }
            this.revealInfo();
        });
        labelPanel.add(revealButton, BorderLayout.SOUTH);

        JButton strokeButton = new JButton("Stroke order (WIP)");
        strokeButton.addActionListener(e -> {
            if(this.kanji == null) {
                DialogUtils.displayErrorMessage("Look up a kanji first!");
                return;
            }
            this.openStrokeOrderWindow();
        });
        labelPanel.add(strokeButton, BorderLayout.NORTH);
        this.add(labelPanel);

        canvas.setBorder(BorderFactory.createLineBorder(Color.black));
        this.add(canvas);
    }

    public void setKanji(CharacterTuple kanji) {
        this.kanji = kanji;
        this.kanjiLabel.setText(LabelBuilder.buildHiddenLabelHTML(kanji));
        this.setCanvasImage(kanji.imageURL);
    }

    private void revealInfo() {
        this.kanjiLabel.setText(LabelBuilder.buildLabelHTML(this.kanji));
    }

    private void openStrokeOrderWindow() {
        KanjiStrokesWindow window = new KanjiStrokesWindow(this.kanji.strokeURLs);
        window.setVisible(true);
    }

    public void setCanvasImage(String url) {
        this.canvas.setURI(url);
        canvas.repaint();
    }
}
