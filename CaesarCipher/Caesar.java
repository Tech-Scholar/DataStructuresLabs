//name: George Filippov
//date: 8/31/23

import java.util.*;

public class Caesar
{
   public static void main (String []args)
   {
      Scanner scan = new Scanner (System.in);
      System.out.print("Choose 1 to encrypt or 2 to decrypt --> ");
      int action = scan.nextInt();
      System.out.print("Enter an integer for the Caesar Cipher --> ");
      if (action == 1)
      {
         int shift = scan.nextInt() % 26;
         System.out.print("Enter a phrase to be encrypted --> ");
         scan.nextLine(); 
         String text = scan.nextLine();
         scan.close();
         System.out.println("The secret phrase is -->           "+encrypt(text,shift));
      }
      else
      {
         int shift = -scan.nextInt() % 26;   
         System.out.print("Enter a phrase to be decrypted --> ");
         scan.nextLine(); 
         String text = scan.nextLine();
         scan.close();
         System.out.println("The message is -->                 "+decrypt(text,shift));
      } 
   }
   
   /** 
    * Method encrypts a message using the right Caesar shift 
    * with the designated offset.
    * Precondition:  offset is a positive integer.
    * @param phrase The message to be encrypted.
    * @param offset The integer value designated how many spaces to shift.
    * @return String containing the encrypted message.
    */
   public static String encrypt (String phrase, int offset)
   {  
      String alphabet = "abcdefghijklmnopqrstuvwxyz";
      String final_result = "";
      for (int i=0; i<phrase.length();i++){
        int index = alphabet.indexOf(Character.toLowerCase(phrase.charAt(i)));
        if (index < 0){
          final_result += phrase.substring(i, i+1);
          continue;
        }
        index += offset;
        if (index > 25){
          index -= 26;
        }
        if (Character.isUpperCase(phrase.charAt(i))){
          final_result += alphabet.substring(index, index+1).toUpperCase();
          continue;
        }
        final_result += alphabet.substring(index, index+1);
      }
      return final_result;                   
   }    
   
/** 
    * Method deccrypts a message using the right Caesar shift 
    * with the designated offset.
    * Precondition:  offset is a positive integer.
    * @param phrase The message to be decrypted.
    * @param offset The integer value designated how many spaces to shift.
    * @return String containing the decrypted message.
    */
   public static String decrypt (String phrase, int offset)
   {  
      String alphabet = "abcdefghijklmnopqrstuvwxyz";
      String final_result = "";
      for (int i=0; i<phrase.length();i++){
        int index = alphabet.indexOf(Character.toLowerCase(phrase.charAt(i)));
        if (index < 0){
          final_result += phrase.substring(i, i+1);
          continue;
        }
        index += offset;
        if (index < 0){
          index += 26;
        }
        if (Character.isUpperCase(phrase.charAt(i))){
          final_result += alphabet.substring(index, index+1).toUpperCase();
          continue;
        }
        final_result += alphabet.substring(index, index+1);
      }
      return final_result;
    }
}


/*********************************
  ----jGRASP exec: java Caesar
 Choose 1 to encrypt or 2 to decrypt --> 1
 Enter an integer for the Caesar Cipher --> 13
 Enter a phrase to be encrypted --> Computer science rocks!
 The secret phrase is -->           Pbzchgre fpvrapr ebpxf!
 
  ----jGRASP: operation complete.
 
 
  ----jGRASP exec: java Caesar
 Choose 1 to encrypt or 2 to decrypt --> 2
 Enter an integer for the Caesar Cipher --> 13
 Enter a phrase to be decrypted --> Pbzchgre fpvrapr ebpxf!
 The message is -->                 Computer science rocks!
 
  ----jGRASP: operation complete.
 *******************************/

