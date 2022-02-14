package com.lspoke.gallows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordGenerator {
    FileReader fileReader = null;
    BufferedReader br = null;
    List<String> worlds = new ArrayList<>();

    int startIndex = 0;
    int endIndex;
    // Generating words
    public String generator(){
        //Reading words from a file
        readFile();
        endIndex = worlds.size();
        int randomNum = startIndex + (int) (Math.random() * endIndex);
        return worlds.get(randomNum);
    }
    // Reading words from a file
    public void readFile(){
        try{
            fileReader = new FileReader("WordsStockRus.txt");
            br = new BufferedReader(fileReader);

            String line;
            while ((line = br.readLine()) != null){
                worlds.add(line);
            }
        }catch (
                IOException ex){
            System.out.println("Error: " + ex);
        }finally {
            try {
                br.close();
                fileReader.close();
            }catch (IOException ex){
                System.out.println("Error: " + ex);
            }
        }
    }

}
