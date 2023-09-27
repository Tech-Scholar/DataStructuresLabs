// Name: George Filippov (Student)
// Date: 9/26/23
  
import java.util.*;
public class Permutations
{
   public static int count = 0;
    
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      System.out.print("\nHow many digits? ");
      int n = sc.nextInt();
      leftRight("", n);  
              
      oddDigits("", n);
      
      superprime(n);
      //if(count==0)
         //System.out.println("no superprimes");
      //else
         // System.out.println("Count is "+count);
   }
   
    /**
     * Builds all the permutations of a string of length n containing Ls and Rs
     * @param s A string 
     * @param n An postive int representing the length of the string
     */
   public static void leftRight(String s, int n)
   {
     if (n > 1){
        leftRight(s+"L", n-1);
        leftRight(s+"R", n-1);
     }
     else {
         System.out.println(s+'L');
         System.out.println(s+'R');
     }
     
   }
   
    /**
     * Builds all the permutations of a string of length n containing odd digits
     * @param s A string 
     * @param n A postive int representing the length of the string
     */
   public static void oddDigits(String s, int n)
   {
     if (n > 1){
        for (int j = 1; j <= 9; j += 2){
            oddDigits(s + String.valueOf(j), n-1);
        }    
     }
     else {
        for (int j = 1; j <= 9; j += 2){
            System.out.println(s + String.valueOf(j));
        }    
     }
   }
      
    /**
     * Builds all combinations of a n-digit number whose value is a superprime
     * @param n A positive int representing the desired length of superprimes  
     */
   public static void superprime(int n)
   {
      recur(2, n); //try leading 2, 3, 5, 7, i.e. all the single-digit primes
      recur(3, n); 
      recur(5, n);
      recur(7, n);
   }

    /**
     * Recursive helper method for superprime
     * @param k The possible superprime
     * @param n A positive int representing the desired length of superprimes
     */
   private static void recur(int k, int n)
   {
      if (n > 2){
        for (int i : new int[]{2, 3, 5, 7}){
            if (isPrime(k * 10 + i)){
                recur(k * 10 + i, n-1); 
            }
        }   
      }
      else {
        for (int i = 1; i < 10; i++){
            if (isPrime(k * 10 + i)){
                System.out.println(k * 10 + i);
            }
        }
      }
   }

    /**
     * Determines if the parameter is a prime number.
     * @param n An int.
     * @return true if prime, false otherwise.
     */
   public static boolean isPrime(int n)
   {
    for (int i = 2; i < n; i++){
        if (n % i == 0){
            return false;
        }
    }
    return true;
   }
}
