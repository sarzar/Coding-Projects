/*
Name: Sarim Zia
Date: September 15th, 2020
Description: Determines which ones and how many words in a sentence are palindromes
 */
package edu.hdsb.gwss.ics4u.u1;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author sarimzia
 */
public class palindrome2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VARIABLES
        int counter = 0;
        String newSentence = "";
        //INPUT
        Scanner input = new Scanner (System.in);
        System.out.print("Sentence: ");
        String sentence = input.nextLine();
        
        //LOGIC
        StringTokenizer str = new StringTokenizer(sentence);
        
        while (str.hasMoreTokens()){
            String word = str.nextToken();
            String newWord = "";
      
            for(int i = word.length() - 1; i >= 0 ; i--){
            String char1 = Character.toString(word.charAt(i));
            newWord = newWord.concat(char1);
        }
            if(word.toLowerCase().equals(newWord.toLowerCase()))
       {
            counter++;
            newSentence = newSentence + ", " + word;
       }
    }
        System.out.println("There are " + counter + " palindrome(s) in the sentence.");
        System.out.println("The palindromes are: " + newSentence);
        
    
    }
}
