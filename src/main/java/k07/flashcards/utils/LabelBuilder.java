package k07.flashcards.utils;

import k07.flashcards.tuples.CharacterTuple;

public class LabelBuilder {

    public static String buildLabelHTML(CharacterTuple kanji) {
        String exampleString = "";
        for(int k = 0; k < kanji.exampleList.size(); k++) {
            exampleString += kanji.exampleList.get(k) + "<br>";
        }

        String result = "<html>Character: " + kanji.character + "<br><br>" +
                "Meaning: " + kanji.meaning + "<br>" +
                "Onyomi: " + kanji.onyomiRomaji + " | " + kanji.onyomiKatakana + "<br>" +
                "Kunyomi: " + kanji.kunyomiRomaji + " | " + kanji.kunyomiHiragana + "<br><br>" +
                "Examples: " + exampleString + "<br>" +
                "Grade: " + kanji.grade + "</html>";
        return result;
    }

    public static String buildHiddenLabelHTML(CharacterTuple kanji) {
        String result = "<html>Character: " + kanji.character + "<br><br>" +
                "Meaning: <br>" +
                "Onyomi: <br>" +
                "Kunyomi: <br><br>" +
                "Examples: <br><br>" +
                "Grade: </html>";
        return result;
    }
}
