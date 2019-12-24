package com.shpp.p2p.cs.ykohuch.assignment5;

import com.shpp.cs.a.console.TextProgram;


public class Assignment5Part2 extends TextProgram {


    public void run() {
		/* Sit in a loop, reading numbers and adding them. */
        while (true) {
            String n1 = readLine("Enter first number:  ");
            String n2 = readLine("Enter second number: ");
            println(n1 + " + " + n2 + " = " + addNumericStrings(n1, n2));
            println();
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

        /* before continuing need to check that the length of n2 is greater*/
        if (n1.length() > n2.length()){
            String t = n1;
            n1 = n2;
            n2 = t;
        }

        // Take an empty String for storing result
        String result = "";

        // Calculate length of both String
        int value1 = n1.length(), value2 = n2.length();
        int diff = value2 - value1;

        // Initially take zero
        int remainder = 0;

        // Traverse from end of both Strings
        for (int i = value1 - 1; i>=0; i--)
        {
            // Compute sum of current digits
            int sum = ((n1.charAt(i)-'0') +
                    (n2.charAt(i+diff)-'0') + remainder);
            result += (char)(sum % 10 + '0');
            remainder = sum / 10;
        }

        // Add remaining digits of n2[]
        for (int i = value2 - value1 - 1; i >= 0; i--)
        {
            int sum = ((n2.charAt(i) - '0') + remainder);
            result += (char)(sum % 10 + '0');
            remainder = sum / 10;
        }

        // Add remaining
        if (remainder > 0)
            result += (char)(remainder + '0');

        // reverse resultant String
        return new StringBuilder(result).reverse().toString();
    }
}