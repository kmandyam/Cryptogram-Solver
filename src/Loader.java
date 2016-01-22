import java.io.*;
import java.util.*;

public class Loader extends ReaderClass {
    public static void main(String[] args) throws FileNotFoundException{

        String dictionaryPath;
        String cryptogramPath;
        if(args.length != 0){
            dictionaryPath = args[0];
            cryptogramPath = args[1];
        }else {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the path to the dictionary");
            dictionaryPath = input.nextLine();
            System.out.println("Enter the path to the cryptogram");
            cryptogramPath = input.nextLine();
        }

        /*if(Files.exists(dictionaryPath) && Files.exists(cryptogramPath)){

        }*/
        //how to verify that the path is legit???

        String dictionary = readFile(dictionaryPath);
        String cryptogram = readFile(cryptogramPath);
        System.out.println(dictionary);
        System.out.println(cryptogram);

    }

}
