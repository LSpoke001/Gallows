package com.lspoke.gallows;

import java.util.*;

public class GallowsGame {
    WordGenerator wordGenerator = new WordGenerator();

    int lengthOfWord;
    int stepForGuess = 6;
    String answer;

    List<String> answerArray = new ArrayList<>();
    List<String> guessArray = new ArrayList<>();
    //Get the generated word
    private void getWord(){
        answer = wordGenerator.generator();
        String[] word = (answer).split("");
        lengthOfWord = word.length;
        for(int i = 0; i < lengthOfWord; i++){
            guessArray.add("_");
        }
        answerArray = Arrays.asList(word);
    }
    public void game(){
        getWord();
        System.out.println("You have 6 step. Try to guess");
        Scanner scanner = new Scanner(System.in);
        String letter;
        int count = stepForGuess;
        while (count > 0){
            for(String st : guessArray){
                System.out.print(st + " ");
            }
            System.out.println("Enter the letter: ");
            letter = scanner.nextLine();
            if(!tryFind(letter)) count--;
            if(answerArray.equals(guessArray)){
                System.out.println("WIN");
                break;
            }
            System.out.println(count + " steps left");
        }
        if(count <= 0){
            System.out.println("WRONG! Answer is " + answer);
        }
    }
    private boolean tryFind(String letter){
        int count = 0;
        boolean str = true;
        for (int i = 0; i < lengthOfWord; i++){
            if(letter.equals(answerArray.get(i))){
                guessArray.set(i, letter);
            }else count++;
        }
        if(count >= lengthOfWord) str = false;
        return str;
    }
}
