package cryptogram.model;

import main.cryptogram.model.Word;
import org.junit.Test;

public class WordTest {

    // TODO: null test
    @Test
    public void testReplacement(){
        Word word = new Word("hello");
        word.replaceSingleLetter('h', 'b');
        assert(word.currentState().equals("bello"));

        word.replaceSingleLetter('b', 'h');
        assert(word.currentState().equals("bello"));
    }
}
