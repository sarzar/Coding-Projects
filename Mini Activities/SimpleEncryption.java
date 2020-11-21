package edu.hdsb.gwss.ics4u.u1;


import java.util.Scanner;

/*
Name: Sarim Zia
Date: September 161h, 2020
Description: Encrypts and decrypts string based on your given rotation.
package edu.hdsb.gwss.ics4u1;

/**
 *
 * @author sarimzia
 */
public class SimpleEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Scanner input = new Scanner (System.in);
        System.out.print("Please enter a phrase: ");
        String sentence = input.nextLine();
        System.out.print("Enter a rotation amount(1-25): ");
        int rotation = input.nextInt();
        input.nextLine();
        System.out.println("1 - Encryption \n2 - Decryption ");
        int mode = input.nextInt();
        
        if (mode == 1){
            encryption(sentence,rotation);
        } 
        else{
            decryption(sentence,rotation);
        }
        
        
        
        
    }
    public static void encryption(String s,int rotation){
        String encryptedSentence = ""; char n,c;
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
          if(Character.isAlphabetic(c)) {
              if(c >= 65 & c<=90){
                
                n =(char) ((char)((c - 'A' + rotation) % 26) + 'A');
              }
              else{
                
                n =(char)((char)((c - 'a' + rotation) % 26) + 'a');
              
              }
              encryptedSentence = encryptedSentence + n;
          }
          else{
              encryptedSentence = encryptedSentence + c;
          }
        }
        System.out.println("The encrypted sentence is: " + encryptedSentence);
    }
    public static void decryption(String s, int rotation){
        String encryptedSentence = ""; char n,c;
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
          if(Character.isAlphabetic(c)) {
              if(c >= 65 & c<=90){
                
                n =(char) ((char)((c - 'A' - rotation) % 26) + 'A');
              }
              else{
                
                n =(char)((char)((c - 'a' - rotation) % 26) + 'a');
              
              }
              encryptedSentence = encryptedSentence + n;
          }
          else{
              encryptedSentence = encryptedSentence + c;
          }
        }
        System.out.println("The decrypted sentence is: " + encryptedSentence);
    }
    
}
