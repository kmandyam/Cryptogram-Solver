import java.io.*;
import java.util.*;

public class Cryptogram{
    
    public List<String> cryptogram;
    public HashMap<Character, Integer> frequencyCount;

    public Cryptogram(List<String> words) throws FileNotFoundException{

        this.cryptogram = words;

        frequencyCount = new HashMap<Character, Integer>();
        for(String word: words){
            for(char curr: word.toCharArray()){
                if(!frequencyCount.containsKey(curr)){
                    frequencyCount.put(curr, 1);
                }else{
                    int currFreq = frequencyCount.get(curr);
                    frequencyCount.put(curr, currFreq + 1);
                }
            }

        }
    }

    public int frequency(char letter){
        return frequencyCount.get(letter);
    }



}
