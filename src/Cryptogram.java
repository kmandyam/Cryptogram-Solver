import java.io.*;
import java.util.*;

public class Cryptogram extends ReaderClass{
    
    public List<String> cryptogram;
    public HashMap<Character, Integer> frequencyCount;

    public Cryptogram(String cryptogramFile) throws FileNotFoundException{
        //read in the cryptogram file
        String cryptogramString = readFile(cryptogramFile);
        Scanner scn = new Scanner(cryptogramString);
        cryptogram = new ArrayList<String>();
        while(scn.hasNext()){
            cryptogram.add(scn.next());
        }

        frequencyCount = new HashMap<Character, Integer>();
        for(int i = 0; i < cryptogramString.length(); i++){
            char curr = cryptogramString.charAt(i);
            if(!frequencyCount.containsKey(curr)){
                frequencyCount.put(curr, 1);
            }else{
                int currFreq = frequencyCount.get(curr);
                frequencyCount.remove(curr);
                frequencyCount.put(curr, currFreq + 1);
            }
        }
    }

    public int frequencies(char letter){
        return frequencyCount.get(letter);
    }



}
