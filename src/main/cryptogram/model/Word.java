package main.cryptogram.model;

import java.util.Stack;

public class Word {
    String encrypted;
    Stack<String> solvedStates;

    public Word(String encrypted){
        this.encrypted = encrypted;
        this.solvedStates = new Stack<String>();
        this.solvedStates.push(encrypted);
    }

    public void replaceSingleLetter(char old, char update){
        StringBuilder oldState = new StringBuilder(solvedStates.peek());

        for(int i = 0; i < oldState.length(); i++){
            if(encrypted.charAt(i) == old){
                oldState.setCharAt(i, update);
            }
        }

        solvedStates.push(oldState.toString());
    }

    public void undoReplace(){
        solvedStates.pop();
    }

    public String currentState(){
        return solvedStates.peek();
    }


}
