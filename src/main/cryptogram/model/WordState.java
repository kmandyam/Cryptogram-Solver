package main.cryptogram.model;

public class WordState {

    String encryptedText;
    String currentSolution;

    public WordState(String encryptedText, String currentSolution){
        this.encryptedText = encryptedText;
        this.currentSolution = currentSolution;
    }
}
