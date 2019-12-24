package com.shpp.p2p.cs.ykohuch.assignment5;

import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Assignment5Part4 extends TextProgram {
    
    public void run(){

        extractColumn();
    }

    private ArrayList<String> extractColumn(){
        ArrayList<String> result = new ArrayList<String>();

        //parameter for split the row
        String splitBy = ",";


        try {
            //read a file
            BufferedReader br = new BufferedReader(new FileReader("src\\com\\shpp\\p2p\\cs\\ykohuch\\assignment5\\filename.csv"));
            String line;

            while ((line = br.readLine()) !=null) {
                String[] a = line.split(splitBy);

                //output of result
                println("|" + a[0] + "|" + a[1]);
            }
            br.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }
}

