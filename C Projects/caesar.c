#include <cs50.h>
#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdlib.h>

int main(int argc, string argv[])
{
    
    //Error Checking
    
    if(argc == 1)
    {
        printf("Usage: %s key\n", argv[0]);
        return 1;
    }
    for(int counter = 0; counter < strlen(argv[1]); counter++){
    if(isdigit(argv[1][counter]) == 0 )
    {
        printf("Key must be a number!\n");
        return 1;
    }
    }
    if(argc > 2){
        printf("Key must be a number!\n");
        return 1;
    }
   
    
     //Convert command line info to integer
     int number = atoi (argv[1]);
     
     //Input
     string input = get_string("plaintext: ");
     
     //Output
     printf("ciphertext: ");
     
     for(int i = 0; i < strlen(input); i++)
     {
        if(isalpha(input[i]) > 0){
            
        if(input[i] >= 65 && input[i] <= 90){
            
        char p = ((input[i] - 'A' + number) % 26) + 'A';
         printf("%c",p );
        }
        else{
            char p = ((input[i] - 'a' + number) % 26) + 'a';
            printf("%c",p );
        
        }
     }
        else{
            printf("%c", input[i]);
        }
     }
         printf("\n");
}