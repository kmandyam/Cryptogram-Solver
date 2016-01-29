import main.Dictionary;
import org.junit.Test;
import main.FileReader;

import java.io.FileNotFoundException;
import java.util.List;

public class DictionaryTest {
    @Test
    public void testSimpleTwoLetterWord() throws FileNotFoundException {
        List<String> dictionaryTokens = FileReader.tokenizeOnSpace(FileReader.readFile("/Users/Aishwarya/IdeaProjects/Cryptogram-Solver/resources/dictionaries/dictionary"));
        Dictionary dictionary = new Dictionary(dictionaryTokens);
        dictionary.pruneDictByPattern("-e");
        //write assert statement
    }
}
