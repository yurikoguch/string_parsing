package com.shpp.p2p.cs.ykohuch.assignment5;
import com.shpp.cs.a.console.TextProgram;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Assignment5Part4 extends TextProgram {
    //File Path of the file with columns
    private final static String FILE = "src\\com\\shpp\\p2p\\cs\\ykohuch\\assignment5\\filename.csv";
    //Inde of column you want to get
    private final static Integer COLUMN = 0;

    public void run(){
        extractColumn(FILE, COLUMN);
    }

    //Reads the file
    private List<String> fieldsIn(String filepath) {
        List<String> strings = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileReader(filepath))) {
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    //Extrats the column by index from file
    private ArrayList<String> extractColumn(String filename, int columnIndex) {
        List<List<String>> fileData = getColumns(fieldsIn(filename));
        ArrayList<String> result = new ArrayList<>();
        for (List<String> list : fileData) {
            result.add(list.get(columnIndex));
        }
        return result;
    }

      /* Splits the list values.*/
    private List<List<String>> getColumns(List<String> listToClean) {
        List<List<String>> strings = new ArrayList<>();
        for (String line : listToClean) {
            if (!line.contains("\"")) {
                String a = line.replace(",", "\n");
                println(a);
            }
            else if(line.contains("\"")){
                String  b = line.replace("\"", " ");
                b.split(",");
                println(b);
            }
        }
        return strings;
    }

}

