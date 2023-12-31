// Name:    Date:

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NQueens extends JPanel
{
   // Instance Variables: Encapsulated data for EACH NQueens problem
   private JButton[][] board;
   private int N;
   JSlider speedSlider;
   private int timerDelay;

   public NQueens(int n)
   {
      N = n;
      this.setLayout(new BorderLayout());
   
      JPanel north = new JPanel();
      north.setLayout(new FlowLayout());
      add(north, BorderLayout.NORTH);
      JLabel label = new JLabel( N + "Queens solution");
      north.add(label);
      
      JPanel center = new JPanel();
      center.setLayout(new GridLayout(N,N));
      add(center, BorderLayout.CENTER);
      board = new JButton[N][N];
      for(int r = 0; r < N; r++)
         for(int c = 0; c < N; c++)
         {
            board[r][c] = new JButton();
            board[r][c].setBackground(Color.blue);
            center.add(board[r][c]);
         }
   
      speedSlider = new JSlider();   
      speedSlider.setInverted(true);   
      add(speedSlider, BorderLayout.SOUTH);   
   }

   /** Returns the number of queens to be placed on the board. **/
   public int numQueens()
   {
      return N;   
   }

    /** Solves (or attempts to solve) the N Queens Problem. **/
   public boolean solve()
   {
      return isPlaced(0);
   }

 /**
  * Iteratively try to place the queen in each column.
  * Recursively try the next row.
  **/       
   private boolean isPlaced(int row)
   {
      if(row == N)            //all queens have been placed
         return true;
      for (int c = 0; c < N; c++){
          if (locationIsOK(row, c)){
            addQueen(row, c);
            if (isPlaced(row+1)) {
                return true;
            }
            else {
                removeQueen(row, c); 
            }
         }
      }
      return false;
    } 
   
  /** Verify that another queen can't attack this location.
    * You only need to check the locations above this row.
    * Iteration is fine here.
    **/
   private boolean locationIsOK(int r, int c)
   {
      /*  enter code here  */
      int count = 0;
      for (int i = r; i >= 0; i--){
          if (board[i][c].getBackground() == Color.RED){
              return false;
          }
          if (c - count >= 0 && 
          board[i][c - count].getBackground() == Color.RED){
              return false;
          }
          if (c + count <= N - 1 && 
          board[i][c + count].getBackground() == Color.RED){
              return false;
          }
          count++;
      }
      return true;
   }

    /** Adds a queen to the specified location.
       **/
   private void addQueen(int r, int c)
   {
      board[r][c].setBackground(Color.RED);
      pause();
   }

    /** Removes a queen from the specified location.
     **/
   private void removeQueen(int r, int c)
   {
      board[r][c].setBackground(Color.BLUE);
      pause();
   }
   private void pause()
   {
      int timerDelay = speedSlider.getValue(); 
      for(int i=1; i<=timerDelay*1E7; i++)  {}
   }
}
