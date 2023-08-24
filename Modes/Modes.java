public class Modes
{
   public static void main(String[] args)
   {
      int[] tally = {0,0,10,5,10,0,7,1,0,6,0,10,3,0,0,1};
      //test with other values in the tally
      System.out.println(toString(tally));
      int[] modes = calculateModes(tally);
      System.out.println(toString(modes));
      int sum = 0;
      for(int k = 0; k < tally.length; k++)
         sum += tally[k];
      System.out.println("kth \tindex"); 
      for(int k = 1; k <= sum; k++)
         System.out.println(k + "\t\t" + kthDataValue(tally, k));
   }
     
  /**
   * precondition: tally.length > 0
   * postcondition: returns an int array that contains the modes(s);
   *                the array's length equals the number of modes.
   */
   public static int[] calculateModes(int[] tally)
   {
      // Finds highest tally so that all number with the same tally amount
      // will be found. 
      int counter = findMax(tally);
      // Checker that check if there is a mode
      boolean hasMode = false;
      // Find the number of modes by comparing the tally number to the
      // highest tally amount, which is later used to intialize an array
      int numberOfModes = 0;
      for (int j : tally){
        if (j == counter){
          numberOfModes++;
        }
        // Checks if there is a mode. Doesn't count 0 since numbers with          // a frequenncy of 0 isn't counter
        else if (j != 0){
          hasMode = true;
        }
      }
      // Return empty array if there is no mode
      if (!hasMode){
        return new int[0];
      }
      // InitializesIntializes the array to return as the answer by using number of         //       // modes found before
      int result[] = new int[numberOfModes];
      int currentIndex = 0;
      // Assigns all modes to an index of the array
      for (int j = 0; j < tally.length; j++){
        if (tally[j] == counter){
          result[currentIndex] = j;
          currentIndex++;
        }
      }
     // Returns the array with all the modes
      return result;
   }
     
  /**  
   * precondition:  tally.length > 0
   * 	             0 < k <= total number of values in data collection
   * postcondition: returns the kth value in the data collectio
   *                represented by tally
   */
   public static int kthDataValue(int[] tally, int k)
   {
      // Initializes a variable to keep track of the added values
      int sum = 0;
      // A loop that adds up values until it is equal or greater than k.
      for (int i = 0; i < tally.length; i++){
        sum += tally[i];
        if (sum > k || sum == k){
          // Returns the kth data value 
          return i;
        }
      }
      // Allows for error handling and compiling
      return -1;
   }
     
  /**
   * precondition:  nums.length > 0
   * postcondition: returns the maximal value in nums
   */
   public static int findMax(int[] nums)
   {
      int pos = 0;
      for(int k = 1; k < nums.length; k++)
         if(nums[k] > nums[pos])
            pos = k;
      return nums[pos];
   }
   
   public static String toString(int[] arg)
   {
      if(arg.length == 0)
         return("[]");
      String s = "[";
      for(int k = 0; k < arg.length - 1; k++)
         s += arg[k] + ",";
      s += arg[arg.length - 1] + "]";
      return s;
   }  
}

