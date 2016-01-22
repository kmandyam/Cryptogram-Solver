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

        if(!pathExists(dictionaryPath) || !pathExists(cryptogramPath)){
            System.exit(1);
        }
        List<String> dictionaryTokens = FileReader.tokenizeOnSpace(FileReader.readFile(dictionaryPath));
        List<String> cryptogramTokens = FileReader.tokenizeOnSpace(FileReader.readFile(cryptogramPath));

        Cryptogram cryptogram = new Cryptogram(cryptogramTokens);
        Dictionary dictionary = new Dictionary(dictionaryTokens);



    }

    private static boolean pathExists(String path1){
        File file1 = new File(path1);
        return file1.exists();
    }

}
