#include <cs50.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>
#include <math.h>



//main function
int main(void)
{
    
    string text = get_string("Text: ");
    
    //Evaluates different parts of paragraph
    int lettercounter = 0, wordcounter = 1, sentencecounter = 0;
    for(int i = 0; i < strlen(text); i++)
    {
        if(isalpha(text[i]))
        {
             lettercounter++;
        }
        if(text[i] == ' ')
        {
            wordcounter++;
        }
        if(text[i] == '.' || text[i] == '!' || text[i] == '?')
        {
            sentencecounter++;
        }
    }
     
     //Readability calculation
     float index = 0;
     
     float l = ((float)(lettercounter)/(float)(wordcounter))*100;
     float s = ( (float)(sentencecounter)/(float)(wordcounter))*100;
     
  index = 0.0588 * l - 0.296 * s - 15.8;
    
     
     if(index < 1)
     {
         printf("Before Grade 1\n");
     }
     else if(index >= 16)
     {
         printf("Grade 16+\n");
     }
     else
     {
         printf("Grade %.0f\n", round(index));
     }
     
    
    

}