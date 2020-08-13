package k07.flashcards;

public class CharacterTuple {
    public String character;
    public String meaning;
    public String onyomiRomaji;
    public String onyomiKatakana;
    public String kunyomiRomaji;
    public String kunyomiHiragana;

    public CharacterTuple(String character, String meaning, String onyomiRomaji, String onyomiKatakana, String kunyomiRomaji, String kunyomiHiragana) {
        this.character = character;
        this.meaning = meaning;
        this.onyomiRomaji = onyomiRomaji;
        this.onyomiKatakana = onyomiKatakana;
        this.kunyomiRomaji = kunyomiRomaji;
        this.kunyomiHiragana = kunyomiHiragana;
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
