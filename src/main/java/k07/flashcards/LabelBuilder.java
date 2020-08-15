package k07.flashcards;

public class LabelBuilder {
    public static String buildLabelHTML(CharacterTuple kanji) {
        String result = "<html>Character: " + kanji.character + "<br><br>" +
                "Meaning: " + kanji.meaning + "<br>" +
                "Onyomi: " + kanji.onyomiRomaji + " | " + kanji.onyomiKatakana + "<br>" +
                "Kunyomi: " + kanji.kunyomiRomaji + " | " + kanji.kunyomiHiragana + "<br><br>" +
                "Grade: " + kanji.grade + "</html>";
        return result;
    }

    public static String buildHiddenLabelHTML(CharacterTuple kanji) {
        String result = "<html>Character: " + kanji.character + "<br><br>" +
                "Meaning: <br>" +
                "Onyomi: <br>" +
                "Kunyomi: <br><br>" +
                "Grade: </html>";
        return result;
    }
}
