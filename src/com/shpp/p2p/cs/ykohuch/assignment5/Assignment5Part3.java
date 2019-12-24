package com.shpp.p2p.cs.ykohuch.assignment5;
import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Assignment5Part3 extends TextProgram {


    public void run(){
        while (true){
            ArrayList <String> words = readWords();
        }
    }

    private ArrayList<String> readWords() {
        //accept the word
        String entry = readLine("Enter three letters:").toLowerCase();

        //break three letters into a chars
        char one = entry.charAt(0);
        char two = entry.charAt(1);
        char three = entry.charAt(2);

        ArrayList<String> result = new ArrayList<String>();
         //Open the word file for reading.
        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\com\\shpp\\p2p\\cs\\ykohuch\\assignment5\\en-dictionary.txt"));
            String line;
            while ((line = br.readLine()) != null){

                //find a match and print
                if(line.indexOf(one) != -1 && line.indexOf(two) > line.indexOf(one)  && line.indexOf(three) > line.indexOf(two)){
                    println(line);
                }
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }
}
