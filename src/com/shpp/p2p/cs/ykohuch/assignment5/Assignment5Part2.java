package com.shpp.p2p.cs.ykohuch.assignment5;
import com.shpp.cs.a.console.TextProgram;

//this program does a mathematical function of adding in to a column
public class Assignment5Part2 extends TextProgram {
    public void run() {
		/* Sit in a loop, reading numbers and adding them. */
        while (true) {
            String n1 = readLine("Enter first number: ");
            String n2 = readLine("Enter second number: ");
             /*here uses a regular expression to check whether a user entered a numbers*/
            if(n1.matches("[\\d]+") && n2.matches("[\\d]+")) {
                //print the result
                println(n1 + " + " + n2 + " = " + addNumericStrings(n1, n2));
            }else {
                println("Enter the numbers ");
            }
        }
    }

    /**
     * Given two string representations of nonnegative integers, adds the
     * numbers represented by those strings and returns the result.
     *
     * @param n1 The first number.
     * @param n2 The second number.
     * @return A String representation of n1 + n2
     */
    private String addNumericStrings(String n1, String n2) {
        /* before continuing need to check that the length of n2 is greater
        * if first string is longer we make it basic */
        if (n1.length() > n2.length()){
            String basic = n1;
            n1 = n2;
            n2 = basic;
        }

        // Take an empty String for storing result
        StringBuilder result = new StringBuilder();
        //  initialize variables that store the length of strings
        int value1 = n1.length();
        int value2 = n2.length();
        //subtract the length of the longer string from the length of the shorter one
        int diff = value2 - value1;
        // Initially zero for the rest
        int remainder = 0;

        // Traverse from end of both Strings
        for (int i = value1 -1 ; i>=0; i--)
        {
            // Compute sum of current digits
            int sum = ((n1.charAt(i)-'0') + (n2.charAt(i+diff)-'0') + remainder);
            result.append((char) (sum % 10 + '0'));
            remainder = sum / 10;
        }
        // add the remainder to the string n2
        for (int i = value2 - value1 - 1; i >= 0; i--)
        {
            int sum = ((n2.charAt(i) - '0') + remainder);
            result.append((char) (sum % 10 + '0'));
            remainder = sum / 10;
        }
        // reverse resultant String
        return new StringBuilder(result.toString()).reverse().toString();
    }
}