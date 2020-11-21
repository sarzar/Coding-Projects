/*
 * Name : Sarim Zia
 * Date : September 17th, 2020
 * Version : 1.0
 * Description: This program takes in a word and outputs the longest palindrome(s) in the word, and how many letters are in it/them.
 */
package edu.hdsb.gwss.ics4u.u1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author sarimzia
 */
public class SubPalindrome {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        //SPLASHPAGE
        System.out.println(" --------------- ");
        System.out.println("| SUBPALINDROME |");
        System.out.println(" --------------- ");
        System.out.println("Welcome to Sub Palindrome!\nThis program takes in a file with words as input,\nand prints the biggest palindrome in it! ");
        System.out.println("------------------------------------------------");

        //INPUT FROM FILE
        Scanner input = new Scanner(new File("DATA20.txt"));

        palindromeChecker(input);

    }

    public static void palindromeChecker(Scanner input) {
        //VARIABLES
        ArrayList<String> biggestPalindromes = new ArrayList<String>();
        int counter = 0, c, y, x, d, n = 0;
        String originalWord, wordReversed, words, word;
        
        //LOGIC
        while (input.hasNextLine()) {
            
            //VARIABLE ASSIGNING             
            word = input.nextLine().replace(" ", "");
           
            
            //CONDITION FOR EMPTY LINE
            if (word.length() < 1){
                
                System.out.println("0");
            }
             
            //FOR LOOP GOING FROM LAST POSSIBLE K VALUE TO 0
            for (int k = word.length(); k >= 0; k--) {
                
                //FOR LOOP GOING THROUGH ALL LETTER OF THE WORD AND THEIR POSSIBLE COMBINATION BASED ON K VALUE
                for (int i = 0; i < word.length() + 2; i++) {

                    c = i + k;
                    y = i + k;

                   //CONDITION TO MAKE SURE SUBSTRINGS ARE WITHIN INDEX
                    if (c <= word.length()) {
                        
                        //VARIABLE ASSIGNING
                        originalWord = word.substring(i, y).toLowerCase();
                        wordReversed = wordReversed(word.substring(i, y).toLowerCase());
                        
                        //CHECKS IF WORD SUBSTRING, AND REVERSED WORD USBSTRING ARE EQUAL
                        if(originalWord.equals(wordReversed)){
                            
                            biggestPalindromes.add(originalWord);
                            counter = k;
                        }
                        
                    } 
                        //CONDITION THAT BREAKS LOOP AND GOES TO NEXT K VALUE IF SUBSTRING IS OUT OF INDEX
                        else {
                            break;
                    }

                }
                
                //OUTPUT (MADE SURE OUTPUT IS RIGHT BASED ON AMOUNT OF BIGGEST PALINDROMES FOUND)
                if(biggestPalindromes.size() > 0){
                    
                    if(biggestPalindromes.size() == 1){
                    System.out.println("( "+ biggestPalindromes.get(0)+ " is the longest. )");
                    
                    }
                    
                    else{
                        
                        System.out.print("(");
                        for(int i = 0; i < biggestPalindromes.size(); i++){
                            
                            if(!(i == biggestPalindromes.size()-1)){
                            System.out.print(biggestPalindromes.get(i) + " and ");
                            
                            }
                            else{
                                
                                System.out.println(biggestPalindromes.get(i)+" have " + counter + " letters. )");
                                
                            }
                            
                           
                        }
                        
                    }
                    //CLEARS ARRAY LIST FOR NEXT WORD, AND STOPS THE ITTERATION OF K VALUES
                    biggestPalindromes.clear();
                    break;
                }
                
            }

        }
       

    }
    //REVERSES SUBSTRING TO CHECK IF ITS A PALINDROME 
    public static String wordReversed(String word) {
        
        //VARIABLES
        StringTokenizer str = new StringTokenizer(word);
        String newWord = null, words, char1;
        
        while (str.hasMoreTokens()) {
            
            words = str.nextToken();
            newWord = "";

            for (int i = words.length() - 1; i >= 0; i--) {
                
                char1 = Character.toString(words.charAt(i));
                newWord = newWord.concat(char1);
            }

        }
        return newWord;
    }

    
    
}
