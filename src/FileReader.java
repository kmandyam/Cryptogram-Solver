import java.io.*;
import java.util.*;

public class FileReader {

    public static String readFile(String file) throws FileNotFoundException {
        Scanner scn = new Scanner(new File(file));
        String output = "";
        while(scn.hasNextLine()){
            Scanner lineScan = new Scanner(scn.nextLine());
            while(lineScan.hasNext()){
                output += (lineScan.next() + " ");
            }
        }
        return output.trim();
    }

    public static Set<String> assembleDictionary(String dictionaryFile) throws FileNotFoundException{
        Scanner scn = new Scanner(new File(dictionaryFile));
        Set<String> dictionary = new HashSet<String>();
        while(scn.hasNextLine()) {
            dictionary.add(scn.nextLine());
        }
        return dictionary;
    }


}

