// Name: 
// Date:

public class Widget implements Comparable<Widget>
{
   //fields
   private int cubits;
   private int hands;
   
   //constructors
   public Widget(){
       cubits = 0;
       hands = 0;
   }
   public Widget(int c, int h){
       cubits = c;
       hands = h;
   }
   public Widget(Widget w){
       cubits = w.getCubits();
       hands = w.getHands();
   }
   
   //accessors and modifiers
   public int getCubits(){
       return cubits;
   }
   public int getHands(){
       return hands;
   }
   public void setCubits(int c){
       cubits = c;
   }
   public void setHands(int h){
       hands = h;
   }
   
   //compareTo and equals
   public int compareTo(Widget w){
       if (cubits > w.cubits){
           return 1;
       }
       else if (cubits == w.cubits){
           if (hands > w.hands){
               return 1;
           }
           else if (hands == w.hands){
               return 0;
           }
           else {
               return -1;
           }
       }
       else {
           return -1;
       }
   }
   
   public boolean equals(Widget w){
       if (cubits == w.cubits && hands == w.hands){
           return true;
       }
       return false;
   }
   
   //toString
   public String toString(){
       return String.format("%d cubits %d hands", cubits, hands);
   }
}
