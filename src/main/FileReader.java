package main;

import java.io.*;
import java.util.*;

public class FileReader{

    public static String readFile(String file) throws FileNotFoundException{
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

    public static List<String> tokenizeOnSpace(String readFileOutput){
        List<String> wordList = new ArrayList<String>();
        Scanner scanner = new Scanner(readFileOutput);
        while(scanner.hasNext()){
            wordList.add(scanner.next());
        }
        return wordList;
    }


}

