package com.shpp.p2p.cs.ykohuch.assignment5;


import com.shpp.cs.a.console.TextProgram;

public class Assignment5Part1 extends TextProgram {
    public void run() {
		/* Repeatedly prompt the user for a word and print out the estimated
		 * number of syllables in that word.
		 */
        while (true) {
            String word = readLine("Enter a single word: ").toLowerCase();
            println("  Syllable count: " + syllablesIn(word));
        }
    }

    /**
     * Given a word, estimates the number of syllables in that word according to the
     * heuristic specified in the handout.
     *
     * @param word A string containing a single word.
     * @return An estimate of the number of syllables in that word.
     */
    private int syllablesIn(String word) {
        //array of vowel letters
        char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'y' };

        //convert word from string to char array
        char[] entryWord = word.toCharArray();
        //vowels counter
        int vowelsCounter = 0;
        //boolean to check if the previous letter was vowel
        boolean lastWasVowel = false;

        //cycle for sorting letters
        for (char i : entryWord) {
            boolean foundVowel = false;
            for (char v : vowels)
            {
                //don't count vowel if previous was vowel
                if ((v == i) && lastWasVowel)
                {
                    foundVowel = true;
                    lastWasVowel = true;
                    break;
                }
                else if (v == i)
                {
                    vowelsCounter++;
                    foundVowel = true;
                    lastWasVowel = true;
                    break;
                }
            }
            // If full cycle and no vowel found, set lastWasVowel to false;
            if (!foundVowel)
                lastWasVowel = false;
        }
       /* reject the letter e if the word contains more than two letters and ends with e*/
        if (word.length() > 2 &&
                word.endsWith("e"))
            vowelsCounter--;
        /*if a word has no vowels, and word length is bigger than 0 program will return 1*/
        if(vowelsCounter == 0 && word.length()>0)
            return 1;
        return vowelsCounter;
    }
}

