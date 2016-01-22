import java.io.*;
import java.util.*;

public class Loader{
    public static void main(String[] args) throws FileNotFoundException{

        System.out.println("start of main");
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

        if(verifyFiles(dictionaryPath, cryptogramPath)) {
            String dictionary = FileReader.readFile(dictionaryPath);
            String cryptogram = FileReader.readFile(cryptogramPath);
            System.out.println(dictionary);
            System.out.println(cryptogram);
        }

    }

    private static boolean verifyFiles(String path1, String path2){
        File file1 = new File(path1);
        File file2 = new File(path2);

        if(file1.exists() && file2.exists()){
            return true;
        }
        return false;
    }

}
