package edu.hdsb.gwss.ics4u.u1;

import java.util.Scanner;

/*
Name: Sarim Zia
Date: September 14th, 2020
Description: Finds accurate distance betwee two given locations.
 */

/**
 *
 * @author sarimzia
 */
public class DistanceCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //INPUT
        Scanner input = new Scanner (System.in);
        System.out.print("Place 1: ");
        String placeOne = input.nextLine();
        System.out.print("Latitude of " + placeOne + ": ");
        Double lat1 = Math.toRadians(input.nextDouble());      
        System.out.print("Longtitude of " + placeOne + ": ");
        Double lon1 = Math.toRadians(input.nextDouble());     
        System.out.println("---------------------------------------");
        input.nextLine();
        System.out.print("Place 2: ");
        String placeTwo = input.nextLine();               
        System.out.print("Latitude of " + placeTwo + ": ");
        Double lat2 = Math.toRadians(input.nextDouble());      
        System.out.print("Longtitude of " + placeTwo + ":");
        Double lon2= Math.toRadians(input.nextDouble());   
        System.out.println("---------------------------------------");
        
        
        //LOGIC 
       double answer;
       
       answer = 6378.8 * Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1));
       
       
       //OUTPUT
        System.out.println("The distance: " + answer + "km");
         
    }
    
}
