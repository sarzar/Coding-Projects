#include <cs50.h>
#include <stdio.h>


//main function
int main(void)
{
    
    int h = 0;
    
    
     //ask for input within parameters
     do
     {
     h = get_int("Height: ");
     }
     while (h < 1 || h > 8);
    
     for (int i = 0; i < h; i++)
     {
      
     //spaces
     
     for(int b = 1; b < h-i; b++ )
     {
           printf(" ");
      }
       
     //hashes (L)
     for(int d = 0; d <= i; d++)
      {
           printf("#");
      }
       
      //space between hashes
      printf("  ");
       
      //hashes (R)
      for(int d = 0; d <= i; d++)
      {
           printf("#");
      }
     
      //next line
        printf("\n");
      }
}