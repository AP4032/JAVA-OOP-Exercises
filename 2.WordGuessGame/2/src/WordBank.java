import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class WordBank {
    private List<String> words;
    private DifficultyLevel difficulty;

    public WordBank(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
        initializeWords();
    }

    private void initializeWords() {
        words = new ArrayList<>();
        switch(difficulty) {
            case EASY:
                words.addAll(List.of("java", "code", "test", "loop", "data", "file", "line", "main"));
                break;
            case MEDIUM:
                words.addAll(List.of("python", "object", "class", "method", "string", "public", "static", "void"));
                break;
            case HARD:
                words.addAll(List.of("programming", "inheritance", "polymorphism", "encapsulation",
                        "constructor", "interface", "collection", "algorithm"));
                break;
        }
    }

    public String getRandomWord() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}