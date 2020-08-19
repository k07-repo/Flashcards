package k07.flashcards.gui;

import org.apache.batik.swing.JSVGCanvas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class KanjiStrokesWindow extends JFrame {

    private List<String> strokeURLs = new ArrayList<String>();

    public KanjiStrokesWindow(List<String> strokeURLs) {
        this.setTitle("Kanji Stroke Order");
        this.setLayout(new GridLayout(1, 1));
        this.strokeURLs = strokeURLs;
        this.setupComponents();
        this.setSize(600, 600);
    }

    private void setupComponents() {
        JPanel panel = new JPanel(new GridLayout(strokeURLs.size(), 2));
        for(int k = 0; k < strokeURLs.size(); k++) {
            JSVGCanvas canvas = new JSVGCanvas();
            canvas.setURI(strokeURLs.get(k));
            panel.add(new JLabel("Stroke " + k));
            panel.add(canvas);
        }

        JScrollPane pane = new JScrollPane(panel,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(pane);
    }
}
