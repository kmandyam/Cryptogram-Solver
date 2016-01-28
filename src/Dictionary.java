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

    //write method to do the pattern matching for words in this dictionary
    //then change each word to match the pattern
    //then match the pattern with each word and add the words to a hashset and return
    //the new dictionary

    public Set<String> pruneDictByPattern(String pattern){
        Set<String> prunedDict = new HashSet<String>();
        //prune the dictionary by length
        prunedDict = pruneDictByLength(pattern.trim().length());

        //prune dictionary by length
        //have a map that maps words to their patterns

        Set<String> prunePattern = new HashSet<String>();

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

        prunedDict.clear();
        prunedDict.addAll(prunePattern);

        List<String> removedWords = new ArrayList<String>();

        for(String patterns: prunedDict){
            if(!patterns.equals(pattern)){
                removedWords.add(patterns);
            }
        }

        prunedDict.removeAll(removedWords);

        return prunedDict;
    }

    private Set<String> pruneDictByLength(int wordLength){
        Set<String> prunedDict = new HashSet<String>();
        for(String s : this.dictionary){
            if(s.length() == wordLength){
                prunedDict.add(s);
            }
        }
        return prunedDict;
    }
}
