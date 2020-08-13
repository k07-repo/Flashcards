package k07.flashcards;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class RootWindow extends JFrame {

    private ArrayList<CharacterTuple> results;
    int currentPos = 0;

    public RootWindow() {
        JTextArea outputArea = new JTextArea();

        this.setLayout(new GridLayout(1, 1));
        outputArea.setText(InternetUtils.obtainMapForKanji("訪").toString());
        this.add(outputArea);
    }





}
