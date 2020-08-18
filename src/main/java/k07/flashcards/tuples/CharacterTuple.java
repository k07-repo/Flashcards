package k07.flashcards.tuples;

import java.util.List;

public class CharacterTuple {
    public String character;
    public String meaning;
    public String onyomiRomaji;
    public String onyomiKatakana;
    public String kunyomiRomaji;
    public String kunyomiHiragana;
    public List<String> strokeURLs;
    public String imageURL;
    public List<ExampleTuple> exampleList;
    public int grade;

    public CharacterTuple(String character, String meaning, String onyomiRomaji, String onyomiKatakana, String kunyomiRomaji, String kunyomiHiragana,  List<String> strokeURLs, String imageURL, List<ExampleTuple> exampleList, int grade) {
        this.character = character;
        this.meaning = meaning;
        this.onyomiRomaji = onyomiRomaji;
        this.onyomiKatakana = onyomiKatakana;
        this.kunyomiRomaji = kunyomiRomaji;
        this.kunyomiHiragana = kunyomiHiragana;
        this.strokeURLs = strokeURLs;
        this.imageURL = imageURL;
        this.exampleList = exampleList;
        this.grade = grade;
    }

    @Override
    public String toString() {
        String result = "Character: " + this.character + "\n" +
                "Meaning: " + this.meaning + "\n" +
                "Onyomi: " + this.onyomiRomaji + " | " + this.onyomiKatakana + "\n" +
                "Kunyomi: " + this.kunyomiRomaji + " | " + this.kunyomiHiragana + "\n";
        return result;
    }


}
