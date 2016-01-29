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

    public Set<String> pruneDictByPattern(String pattern){
        //prune dictionary by length in a list
        List<String> prunedDict = pruneDictByLength(pattern.trim().length());

        //have a map that maps words to their patterns

        Map<String, String> patternMap= new HashMap<String, String>();
        //have a list of all the patterns corresponding to those
        List<String> prunePattern = new ArrayList<String>();

        //for every string in the prunedDictionary (by length),
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

        //add the patterns and the words to a map
        for(int i = 0; i < prunedDict.size(); i++){
            patternMap.put(prunedDict.get(i), prunePattern.get(i));
        }

        //remove words that don't match the pattern
        List<String> removedWords = new ArrayList<String>();

        //if the pattern isn't the desired one, add word to a list
        for(String s: patternMap.keySet()){
            if(!patternMap.get(s).equals(pattern)){
                removedWords.add(s);
            }
        }

        //remove all words from map which are featured in list
        for(String s: removedWords){
            patternMap.remove(s);
        }

        //return the keyset of the map
        return patternMap.keySet();
    }

    private List<String> pruneDictByLength(int wordLength){
        List<String> prunedDict = new ArrayList<String>();
        for(String s : this.dictionary){
            if(s.length() == wordLength){
                prunedDict.add(s);
            }
        }
        return prunedDict;
    }
}
