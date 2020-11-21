/*
Name: Sarim Zia
Date: September 14th, 2020
Description: Determines when Easter Sunday will come given a year.
 */
package edu.hdsb.gwss.ics4u.u1;

import java.util.Scanner;

/**
 *
 * @author sarimzia
 */
public class Eastercomes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //INPUT
        Scanner input = new Scanner (System.in);
        System.out.print("Year: ");
        int year = input.nextInt();
        
        //VARIABLES
        int a,c,e,h,k,j,month,day,p,b,d,f,g,i,m;
        String months = null;
        
        //LOGIC
        a =  year % 19;
        b =  year / 100;
        c =  year % 100;
        d =  b / 4;
        e =  b % 4;
        f = (b + 8)/ 25;
        g = (b - f + 1) / 3;
        h = ((19 * a) + b - d - g + 15)% 30;
        i =  c / 4;
        k =  c % 4;
        j = (32 + (2 * e) + (2 * i) - h - k) % 7;
        m = (a + (11 * h) + (22 * j)) / 451;
        month = (h + j - (7 * m) + 114) / 31;
        p = (h + j - (7 * m) + 114) % 31;
        day = p + 1;
      
        switch(month) {
          case 1:
              months = "January";
              break;
           case 2:
              months = "February"; 
              break;
           case 3:
              months = "March";
              break;
           case 4:
              months = "April";
              break;
           case 5:
              months = "May";
              break;
           case 6:
              months = "June"; 
              break;
           case 7:
              months = "July"; 
              break;
           case 8:
              months = "August"; 
              break;
           case 9:
              months = "September"; 
              break;
           case 10:
              months = "October"; 
              break;
           case 11:
              months = "November"; 
              break;
           case 12:
              months = "December";
              
      }
      
        //OUTPUT
        System.out.println("Easter sunday will be on " + months + " " + day);
        
    }
    
}
