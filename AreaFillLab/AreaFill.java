// Name:
// Date:

import java.util.*;
import java.io.*;

public class AreaFill
{
   public static void main(String[] args) 
   {
      char[][] grid = null;
      String filename = null;
      Scanner sc = new Scanner(System.in);
      while(true)  // what does this do?
      {
         System.out.print("Fill the Area of (-1 to exit): ");
         filename = sc.next();
         if(filename.equals("-1"))
         {
            sc.close();
            System.out.println("Good-bye");
            //System.exit(0); 
            return;  
         }
         grid = read(filename);
         String theGrid = display(grid);
         System.out.println( theGrid );
         System.out.print( "1-Fill or 2-Fill-and-Count: ");
         int choice = sc.nextInt();
         switch(choice)
         {
            case 1:
            {
               System.out.print("\nEnter ROW COL to fill from: ");
               int row = sc.nextInt();
               int col = sc.nextInt(); 
               fill(grid, row, col, grid[row][col]);
               System.out.println( display(grid) );
               break;
            }
            case 2:
            {
               System.out.print("\nEnter ROW COL to fill from: ");
               int row = sc.nextInt();
               int col = sc.nextInt();
               int count = fillAndCount(grid, row, col, grid[row][col]);
               System.out.println( display(grid) );
               System.out.println("count = " + count);
               System.out.println();
               break;
            }
            default:
               System.out.print("\nTry again! ");
         }
      }
   }
   
   /**
    * Reads the contents of the file into a matrix.
    * Uses try-catch.
    * @param filename The string representing the filename.
    * @returns A 2D array of chars.
    */
   public static char[][] read(String filename)
   {
      Scanner infile = null;
      try
      {
         infile = new Scanner(new File(filename));
      }
      catch (Exception e)
      {
         System.out.println("File not found");
         return null;
      }
      /* enter your code here */
      int row=infile.nextInt();
      int col=infile.nextInt();
      String nextLine = infile.nextLine();
      char[][] result = new char[row][col];
      int start = 0;
      while (infile.hasNextLine()){
        nextLine = infile.nextLine();
        result[start] = nextLine.toCharArray();
        start++;
      }
      return result;
   }
   
   /**
    * @param g A 2-D array of chars.
    * @returns A string representing the 2D array.
    */
   public static String display(char[][] g)
   {
        String finalResult = "";
        for (char[] i : g){
            for (char j : i){
                finalResult+=j;
            }
            finalResult+='\n';
        }
        return finalResult;
   }
   
   /**
    * Fills part of the matrix with a different character.
    * @param g A 2D char array.
    * @param r An int representing the row of the cell to be filled.
    * @param c An int representing the column of the cell to be filled.
    * @param ch The char which is being replaced.
    */
   public static void fill(char[][] g, int r, int c, char ch)
   {
    if (0 > r || r >= g.length || 0 > c || c >= g[r].length){
        return;
    }
    if (g[r][c] == ch){
        g[r][c] = '*';
        fill(g, r - 1, c, ch);
        fill(g, r + 1, c, ch);
        fill(g, r, c - 1, ch);
        fill(g, r, c + 1, ch);
    }
   }
   
   /**
    * Fills part of the matrix with a different character.
    * Counts as you go.  Does not use a static variable.
    * @param g A 2D char array.
    * @param r An int representing the row of the cell to be filled.
    * @param c An int representing the column of the cell to be filled.
    * @param ch The char which is being replaced.
    * @return An int representing the number of characters that were replaced.
    */
   public static int fillAndCount(char[][] g, int r, int c, char ch)
   {
    if (0 > r || r >= g.length || 0 > c || c >= g[r].length){
        return 0;
    }
    if (g[r][c] == ch){
        g[r][c] = '*';
        int w = fillAndCount(g, r - 1, c, ch);
        int x = fillAndCount(g, r + 1, c, ch);
        int y = fillAndCount(g, r, c - 1, ch);
        int z = fillAndCount(g, r, c + 1, ch);
        return w + x + y + z + 1;
    }
    return 0;
   }
}
