/*
 * Name : Sarim Zia
 * Date : September 17th, 2020
 * Version : 1.0
 * Description: This program takes in the weight of: Tests, Assignments, Projects, & Quizes,
 * and it takes in the amount of students in a class along with their grades. It returns
 * the amount of people that passed(Above a 50.0%) and displays the highest, and lowest marks.
 */
package edu.hdsb.gwss.ics4u.u1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author sarimzia
 */
public class PassFail {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {

        //SPLASHPAGE
        System.out.println(" -------------- ");
        System.out.println("| PASS or FAIL |");
        System.out.println(" -------------- ");
        System.out.println("Welcome to Pass or Fail!\nThis program takes in the weight of: Tests, Assignments, Projects, & Quizes,\n"
                + "and it takes in the amount of students in a class along with their grades. It returns\n"
                + "the amount of people that passed(Above a 50.0%) and displays the highest, and lowest marks. ");
        System.out.println("--------------------------------------------------------------------------------------------");
        

        //INPUT FROM FILE
        Scanner input = new Scanner(new File("DATA10.txt"));
        
        //PASSING INPUT TO CHECKER FUNCTION
        checker(input);

    }

    public static void checker(Scanner input) {
          
         //VARIABLES
         float t, a, p, q, min, max, average;
         int counter, n;
         
         
         //LOGIC
         while (input.hasNextInt()) {
        
             
            //VARIABLES INITIALIZATION
             min = 100; max = 0;
             counter = 0;

            //VARIABLE ASSIGNING
            t = (float) input.nextInt() / 100;
            a = (float) input.nextInt() / 100;
            p = (float) input.nextInt() / 100;
            q = (float) input.nextInt() / 100;
            n = input.nextInt();

            //FINDS AVERAGE AND MAX & MIN
            for (int i = 0; i < n; i++) {
                
                average = ((float) input.nextInt() * t) + ((float) input.nextInt() * a) + ((float) input.nextInt() * p) + ((float) input.nextInt() * q);
                if (average >= 50.0) {
                    counter++;

                }
                if (average < min) {
                    min = average;
                }
                if (average > max) {
                    max = average;
                }

            }
            //OUTPUT ROUNDED TO ONE DECIMAL SPOT
            System.out.printf(counter + " %.1f %.1f\n", min, max);
        }

    }

}
