import java.io.*;
import java.util.*;
public class Dictionary {

    private Set<String> dictionary;
    private Map<Integer,Set<String>> lengthToWords;

    //hashmap of past entries

    public Dictionary(List<String> dictionaryTokens){
        dictionary = new HashSet<String>();
        lengthToWords = new HashMap<Integer, Set<String>>();
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

    public Set<String> pruneDictByPattern(String pattern){
        Map<String, String> patternMap= new HashMap<String, String>();
        List<String> prunedDict = new ArrayList<String>();
        prunedDict.addAll(lengthToWords.get(pattern.length()));
        List<String> prunePattern = convertWordToPattern(pattern, prunedDict);

        for(int i = 0; i < prunedDict.size(); i++){
            patternMap.put(prunedDict.get(i), prunePattern.get(i));
        }

        List<String> removedWords = new ArrayList<String>();
        for(String s: patternMap.keySet()){
            if(!patternMap.get(s).equals(pattern)){
                removedWords.add(s);
            }
        }
        for(String s: removedWords){
            patternMap.remove(s);
        }

        return patternMap.keySet();
    }

    private List<String> convertWordToPattern(String pattern, List<String> prunedDict){
        List<String> prunePattern = new ArrayList<String>();
        for(String word : prunedDict){
            String modifiedWord = "";
            for(int i = 0; i < pattern.length(); i++){
                char wordChar = word.charAt(i);
                char patternChar = pattern.charAt(i);
                if(patternChar == '-'){
                    wordChar = '-';
                }
                modifiedWord += wordChar;
            }
            prunePattern.add(modifiedWord);
        }
        return prunePattern;
    }
}
