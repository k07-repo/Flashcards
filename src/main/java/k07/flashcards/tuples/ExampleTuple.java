package k07.flashcards.tuples;

public class ExampleTuple {
    public String japanese;
    public String meaning;

    public ExampleTuple(String japanese, String meaning) {
        this.japanese = japanese;
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return this.japanese + " " + this.meaning;
    }
}
