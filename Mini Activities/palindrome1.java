
 /*
Name: Sarim Zia
Date: September 15th, 2020
Description: Determines whether a word is a palindrome or not.
 */
package edu.hdsb.gwss.ics4u.u1;

import java.util.Scanner;

/**
 *
 * @author sarimzia
 */
public class palindrome1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //INPUT
        Scanner input = new Scanner (System.in);
        System.out.print("Word: ");
        String word = input.nextLine();
        
        String newWord = "";
       //LOGIC
       for(int i = word.length() - 1; i >= 0 ; i--){
          String char1 = Character.toString(word.charAt(i));
          newWord = newWord.concat(char1);
           
           
       }
       
       if(word.toLowerCase().equals(newWord.toLowerCase()))
       {
         System.out.println(word + " is a palindrome!");
       }
       else
       {
           
           System.out.println(word + " is not a palindrome!");
       }
    }
    
}
