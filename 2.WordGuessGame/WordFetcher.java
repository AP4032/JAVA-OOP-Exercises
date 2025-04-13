import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordFetcher {
    public static ArrayList<String> wordFetcher(String fileName) throws IOException {
        ArrayList<String> words = new ArrayList<>();
        FileReader fileReader = new FileReader(fileName);
        try (BufferedReader reader = new BufferedReader(fileReader)) {
            String line;
            while((line = reader.readLine()) != null){
                words.add(line.trim());
            }
        }
        return words;
    }
}
