import java.io.*;
import java.util.*;
public class Dictionary {

    private Set<String> dictionary;
    private Map<Integer,Set<String>> lengthToWords;
    private Map<String, List<String>> patternToWords;

    //hashmap of past entries

    public Dictionary(List<String> dictionaryTokens){
        dictionary = new HashSet<String>();
        lengthToWords = new HashMap<Integer, Set<String>>();
        patternToWords = new HashMap<String, List<String>>();
        for(String word: dictionaryTokens){
            dictionary.add(word);
            if(!(lengthToWords.keySet().contains(word.length()))){
                Set<String> words = new HashSet<String>();
                words.add(word);
                lengthToWords.put(word.length(), words);
            }else{
                lengthToWords.get(word.length()).add(word);
            }
        }

    }

    public List<String> pruneDictByPattern(String pattern){

        if(patternToWords.containsKey(pattern)){
            return patternToWords.get(pattern);
        }else {
            Set<String> prunedDict = lengthToWords.get(pattern.length());
            List<String> result = new ArrayList<String>();
            for (String w : prunedDict) {
                String wp = convertWordToPattern(pattern, w);
                if (wp.equals(pattern)) {
                    result.add(w);
                }
            }
            patternToWords.put(pattern, result);
            return result;
        }
    }

    private String convertWordToPattern(String pattern, String word){
        StringBuilder modifiedWord = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            char wordChar = word.charAt(i);
            char patternChar = pattern.charAt(i);
            if (patternChar == '-') {
                wordChar = '-';
            }
            modifiedWord.append(wordChar);
        }
        return modifiedWord.toString();
    }
}
