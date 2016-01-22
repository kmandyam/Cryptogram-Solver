import java.io.*;
import java.util.*;
public class Dictionary {

    private Set<String> dictionary;
    public Dictionary(List<String> dictionaryTokens){
        dictionary = new HashSet<String>();
        for(String word: dictionaryTokens){
            dictionary.add(word);
        }
    }
}
