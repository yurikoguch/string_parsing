package com.shpp.p2p.cs.ykohuch.assignment5;
import com.shpp.cs.a.console.TextProgram;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**this program structures the csv file by splitting its contents into columns that were previously
        separated by commas and outputs these columns according to the index entered by the user*/
public class Assignment5Part4 extends TextProgram {
    //File Path of the file with columns
    private final static String FILE = "src\\com\\shpp\\p2p\\cs\\ykohuch\\assignment5\\filename.csv";
    /*column index to be output*/
    private final  static int columnIndex = 0;

    public void run() {
        extractColumn(FILE, columnIndex);
    }

    /* method that takes a string from the file and returns
     an ArrayList <String> containing all the fields in the string*/
    private ArrayList<String> fieldsIn(String filename) {
        List<String> strings = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
              strings.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (ArrayList<String>)strings;
    }

    /*Method which opens a CSV file named filename, finds the column and assigns it an index (0 for the first column,
     *1 for the second, and so on), then returns an ArrayList containing the information from that column*/
    private ArrayList<String> extractColumn(String filename, int columnIndex) {
        List<List<String>> fileData = getOutput(fieldsIn(filename));
        ArrayList<String> result = new ArrayList<>();
        for (List<String> list : fileData) {
            result.add(list.get(columnIndex));
        }
        if(filename==null) return null;
        return result;
    }

      /* Method which splits the list values
       delete commas and print result*/
    private List<List<String>> getOutput(List<String> output) {
        List<List<String>> strings = new ArrayList<>();
        if(columnIndex<2) {
        for (String line : output) {
            String[] country = line.split(",");
            if(line.contains("\"")){
                country = line.split("\"");
            }
                System.out.println(country[columnIndex].replace(",", ""));
            }
        }else {
            System.out.println("no column available");
        }
        return strings;
    }
}

