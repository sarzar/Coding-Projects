#include <cs50.h>
#include <stdio.h>
#include <string.h>

int main(int argc, string argv[])
{
    //Error Checking
    
    if(argc == 0){
        printf("Usage: ./substitution key\n");
       
       return 1;
    }
   
   
     if(strlen(argv[1]) < 26 ){
        printf("Key must contain 26 characters.\n");
        return 1;
    } 
    
    for(int i=0; i < strlen(argv[1]); i++){
     if(argv[1][i] < 65 && argv[1][i] > 122){
          printf("Usage: ./substitution key\n");
         return 1;
     }
     }
     {
         if(true){
         //Encoding Message
         string input = get_string("Plain text: \n");
         
         
         }
     }
    

    
}