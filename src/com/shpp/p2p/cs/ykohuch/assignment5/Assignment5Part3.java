package com.shpp.p2p.cs.ykohuch.assignment5;
import com.shpp.cs.a.console.TextProgram;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**The idea of the game is to find words that contain three letters,
        typed by the user in the same order in which they are placed on it.*/
public class Assignment5Part3 extends TextProgram {
    public void run(){
        while (true){
            //accept the word
            String entry = readLine("Enter three letters: ").toLowerCase();
            /*here uses a regular expression to check whether a user entered a word without numbers*/
            if (entry.length() == 3) {
                if (entry.matches("(?i).*[a-z].*")) {
                    readWords(entry, dictionary());
                }
            }
            /*if user will not write three letters cycle will break*/
            if(entry.equals("")|| entry.length() > 3 || entry.length() < 3){
                println("Try again");
                break;
            }
        }
    }

    /*the method matches the entered letters and the words that are in the list and displays them*/
    private void readWords(String entry, ArrayList<String> dictionary) {
        //break three letters into a chars
        char one = entry.charAt(0);
        char two = entry.charAt(1);
        char three = entry.charAt(2);

        /*go through the foreach cycle and check for coincidence
        * than we go through each word in search of matching each letter and its location in the word
        * if the three letters are the same we leave the cycle*/
        for (String word : dictionary) {
            if (one == two && two == three) {
                break;
            }
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == one) {
                    for (int j = i; j < word.length(); j++) {
                        if (word.charAt(j) == two) {
                            for (int k = j; k < word.length(); k++) {
                                if (word.charAt(k) == three) {
                                    println(word);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

  /*  here  the contents of our file are placed in an array list*/
    private static ArrayList<String> dictionary() {
        ArrayList<String> dictionary = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader("src\\com\\shpp\\p2p\\cs\\ykohuch\\assignment5\\en-dictionary.txt"))) {
            while (scanner.hasNextLine()) {
                dictionary.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dictionary;
    }
}
