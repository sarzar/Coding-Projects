/*
Name: Sarim Zia
Date: September 15h, 2020
Description: Determines whether a sentence is a palindrome.
 */
package edu.hdsb.gwss.ics4u.u1;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author sarimzia
 */
public class palindrome3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //VARIABLES
        String newSentence = "", newWord = "";
        //INPUT
        Scanner input = new Scanner (System.in);
        System.out.print("Sentence: ");
        String sentence = input.nextLine();
        
        //LOGIC
         StringTokenizer str = new StringTokenizer(sentence);
         while (str.hasMoreTokens()){
             newSentence = newSentence + str.nextToken();
         }
          //LOGIC
       for(int i = newSentence.length() - 1; i >= 0 ; i--){
          String char1 = Character.toString(newSentence.charAt(i));
          newWord = newWord.concat(char1);
           
           
       }
       
       if(newSentence.toLowerCase().equals(newWord.toLowerCase()))
       {
         System.out.println(sentence + " is a palindrome!");
       }
       else
       {
           
           
           System.out.println(sentence + " is not a palindrome!");
       }
    }
    
}
