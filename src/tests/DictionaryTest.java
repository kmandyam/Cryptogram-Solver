import main.Dictionary;
import org.junit.Test;
import main.FileReader;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class DictionaryTest {
    @Test
    public void testSimpleTwoLetterWord() throws FileNotFoundException {
        List<String> dictionaryTokens = FileReader.tokenizeOnSpace(FileReader.readFile("/Users/Aishwarya/IdeaProjects/Cryptogram-Solver/resources/dictionaries/dictionary"));
        Dictionary dictionary = new Dictionary(dictionaryTokens);
        List<String> result = dictionary.getWordsByPattern("-e");

        assert(result.size() == 6);
        assert(result.contains("ye"));
        assert(result.contains("he"));
        assert(result.contains("me"));
        assert(result.contains("we"));
        assert(result.contains("se"));
        assert(result.contains("te"));
    }

    @Test
    public void testNoPatternMatches() {
        List<String> dictionaryTokens = Arrays.asList("foo", "bar");
        Dictionary dictionary = new Dictionary(dictionaryTokens);
        List<String> result = dictionary.getWordsByPattern("-e");
        assert(result.size() == 0);

    }

    @Test
    public void testNullPattern() {
        List<String> dictionaryTokens = Arrays.asList("foo", "bar");
        Dictionary dictionary = new Dictionary(dictionaryTokens);

        try {
            List<String> result = dictionary.getWordsByPattern(null);
        }catch (NullPointerException e){
            assert(true);
            return;
        }
        assert(false);
    }

    @Test
    public void testPatternIsEmptyString() {
        List<String> dictionaryTokens = Arrays.asList("foo", "bar");
        Dictionary dictionary = new Dictionary(dictionaryTokens);
        List<String> result = dictionary.getWordsByPattern("");
        assert(result.size() == 0);

    }

    @Test
    public void testEmptyDictionary() {
        List<String> dictionaryTokens = Arrays.asList("");
        Dictionary dictionary = new Dictionary(dictionaryTokens);
        List<String> result = dictionary.getWordsByPattern("-e");
        assert(result.size() == 0);

    }

}
