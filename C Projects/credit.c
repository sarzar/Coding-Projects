#include <cs50.h>
 #include <stdio.h>
 #include <math.h>
 
 //main
 int main(void)
 {
   
    //Input for credit card number
    long card = get_long("Number: ");
     
    //digit counter
    long n = card,counter = ' ';
    for( counter = 0; n > 0; counter++){
      n = n/10;
      
 }
    printf("Amount of numbers: %lu\n", counter);
 
     //Checksum
    long s = 0, p = 0;
    for(int x=100;x<=pow(10,counter/2); x=x*100)
 {

    p = card % x ;
    p = p - (card%(x/10));
    p = p * 2;
    s = s + p;
    
      
 }
    printf("%lu\n", s);
     
   
   
   

 }