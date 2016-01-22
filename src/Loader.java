import java.io.*;
import java.util.*;

public class Loader{
    public static void main(String[] args) throws FileNotFoundException{

        String dictionaryPath;
        String cryptogramPath;
        if(args.length == 2){
            dictionaryPath = args[0];
            cryptogramPath = args[1];
        }else{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the path to the dictionary");
            dictionaryPath = input.nextLine();
            System.out.println("Enter the path to the cryptogram");
            cryptogramPath = input.nextLine();
        }

        if(pathExists(dictionaryPath) && pathExists(cryptogramPath)){
            String dictionary = FileReader.readFile(dictionaryPath);
            String cryptogram = FileReader.readFile(cryptogramPath);
            //assemble dictionary here, just printing out for right now
            System.out.println(dictionary);
            System.out.println(cryptogram);
        }

    }

    private static boolean pathExists(String path1){
        File file1 = new File(path1);
        return file1.exists();
    }

}
