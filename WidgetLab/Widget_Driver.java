// Name:
// Date:

import java.io.*;      
import java.util.*;    
   
public class Widgets_Driver
{
   public static final int numberOfWidgets = 57;
   
   public static void main(String[] args) throws Exception
   {
      // test the methods
      Widget a = new Widget();
      System.out.println("Default widget A:  " + a.toString());
      Widget b = new Widget(23, 10);
      System.out.println("2-arg constructor B:  " + b.toString());
      Widget c = new Widget(b);
      System.out.println("Copy constructor C:  " + c.toString());
      System.out.print("C's cubits = " + c.getCubits());
      System.out.println( " and hands = " + c.getHands());
      System.out.println("Test the equals methods: ");
      System.out.println("   A equals B " + a.equals(b));
      System.out.println("   B equals C " + b.equals(c));
      
      c.setCubits(3);
      c.setHands(4);
      System.out.print("C is reset to " + c.toString());
      
      System.out.println("\nTest each sort on 57 Widgets");
      Comparable[] apple = input("widgets.txt");
      Scanner sc = new Scanner(System.in);
      System.out.println("  1 Selection Sort");
      System.out.println("  2 Insertion Sort");
      System.out.println("  3 Merge Sort");
      System.out.println("  4 Quick Sort");
      System.out.print("Choose your sort:  ");
      int choice = Integer.parseInt(sc.next());
      System.out.println();
      switch( choice )
      {
         case 1:   // call your sort 
            Selection.sort(apple);
         case 2:   // call your sort   
            Insertion.sort(apple);
         case 3:   // call your sort  
            MergeSort.sort(apple);
         case 4:   // call your sort 
            QuickSort.quickSort(apple, 0, apple.length-1);
            //QuickSort.sort(apple);
         default:  System.out.println("Wrong choice");
      }
      print(apple);   
   }
          	
   public static Comparable[] input(String filename) throws 
   Exception
   {
    ArrayList<Comparable> ex_array = new ArrayList<Comparable>();
    File file = new File(filename);
    Scanner sc = new Scanner(file);
    do {
        try {
            int cubits = sc.nextInt();
            int hands = sc.nextInt();
            ex_array.add(new Widget(cubits, hands));        
        }
        catch (InputMismatchException e){
            System.out.println("Invalid");
        }
    } while (sc.hasNextLine());
    Comparable[] array = new Comparable[ex_array.size()];
    for (int i = 0; i < ex_array.size(); i++){
        array[i] = ex_array.get(i);
    }
    return array;
   }
   	  
   public static void print(Object[] mango)
   {
      for (Object i : mango){
          System.out.println(i);
      }
   }
}
// SELECTION SORT METHODS
class Selection {
   @SuppressWarnings("unchecked")
   public static void sort(Comparable[] array)
   {
    for (int i = array.length-1; i > 0; i--){
        swap(array, i, findMax(array, i));
    }
   }
   @SuppressWarnings("unchecked")
   public static int findMax(Comparable[] array, int upper)
   {
      int index = 0;
      for (int i = 1; i <= upper; i++){
          if (array[i].compareTo(array[index]) > 0){
              index = i;
          }
      }
      return index;
   }
   @SuppressWarnings("unchecked")
   public static void swap(Object[] array, int a, int b)
   {
       Object temp = array[a];
       array[a] = array[b];
       array[b] = temp;
   }
}
class Insertion{
   @SuppressWarnings("unchecked")
   public static void sort(Comparable[] array)
   { 
    for (int i = 0; i < array.length; i++){
        int new_index = shift(array, i, array[i]);
        Comparable temp = array[i];
        array[i] = array[new_index];
        array[new_index] = temp;
    } 
   }
   @SuppressWarnings("unchecked")
   private static int shift(Comparable[] array, int index, Comparable value)
   {
    for (int i = index; i >= 0; i--){
        if (value.compareTo(array[i]) < 0){
            index--;
        }
    }
    return index;
   }
}
class MergeSort{   
   @SuppressWarnings("unchecked")//this removes the warning for Comparable
   public static void sort(Comparable[] array)
   { 
      Comparable[] copyBuffer = new Comparable[array.length];
      mergeSortHelper(array, copyBuffer, 0, array.length - 1);
   }
   @SuppressWarnings("unchecked")
   private static void mergeSortHelper(Comparable[] array, Comparable[] copyBuffer, int low, int high)
   {
      if (low < high)
      {
         int middle = (low + high) / 2;
         mergeSortHelper(array, copyBuffer, low, middle);
         mergeSortHelper(array, copyBuffer, middle + 1, high);
         merge(array, copyBuffer, low, middle, high);
      }
   }
   @SuppressWarnings("unchecked")
   public static void merge(Comparable[] array, Comparable[] copyBuffer,
                                   int low, int middle, int high)
   {
      int i1 = low;
      int i2 = middle + 1;
      int currentIndex = 0;
      while (i1 <= middle && i2 <= high){
          if (array[i1].compareTo(array[i2]) <= 0){
              copyBuffer[currentIndex] = array[i1];
              i1++;
          }
          else {
              copyBuffer[currentIndex] = array[i2];
              i2++;
          }
          currentIndex++;
      }
      
      while (i1 <= middle) {
        copyBuffer[currentIndex] = array[i1];
        currentIndex++; i1++;
      }
      while (i2 <= high) {
        copyBuffer[currentIndex] = array[i2];
        currentIndex++; i2++;
      }
   	  for (int i = low; i <= high; i++){
   	      array[i] = copyBuffer[i - low];
   	  }
   } 
}
class QuickSort{
    @SuppressWarnings("unchecked")
    static int partition(Comparable[] arr, int low, int high)
        {
            // Choosing the pivot
            Comparable pivot = arr[high];
     
            // Index of smaller element and indicates
            // the right position of pivot found so far
            int i = (low - 1);
     
            for (int j = low; j <= high - 1; j++) {
     
                // If current element is smaller than the pivot
                if (arr[j].compareTo(pivot)<0) {
     
                    // Increment index of smaller element
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            return (i + 1);
        }
     
    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    @SuppressWarnings("unchecked")
    static void quickSort(Comparable[] arr, int low, int high)
    {
        if (low < high) {
    
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
    
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
   @SuppressWarnings("unchecked")
   public static void swap(Object[] array, int a, int b)
   {
       Object temp = array[a];
       array[a] = array[b];
       array[b] = temp;
   }
}
   
 /***************************************
      
 Default widget A:  0 cubits 0 hands
 2-arg constructor B:  23 cubits 10 hands
 Copy constructor C:  23 cubits 10 hands
 C's cubits = 23 and hands = 10
 Test the equals methods: 
    A equals B false
    B equals C true
 C is reset to 3 cubits 4 hands
 
 Test each sort on 57 Widgets
   1 Selection Sort
   2 Insertion Sort
   3 Merge Sort
   4 Quick Sort
 Choose your sort:  2
 
 0 cubits 14 hands
 1 cubits 3 hands
 2 cubits 14 hands
 5 cubits 14 hands
 10 cubits 14 hands
 11 cubits 11 hands
 12 cubits 0 hands
 12 cubits 7 hands
 13 cubits 9 hands
 15 cubits 12 hands
 17 cubits 5 hands
 18 cubits 13 hands
 19 cubits 13 hands
 19 cubits 13 hands
 22 cubits 6 hands
 23 cubits 7 hands
 24 cubits 15 hands
 24 cubits 15 hands
 26 cubits 2 hands
 28 cubits 5 hands
 28 cubits 12 hands
 29 cubits 15 hands
 31 cubits 0 hands
 32 cubits 1 hands
 32 cubits 11 hands
 32 cubits 11 hands
 32 cubits 12 hands
 35 cubits 3 hands
 39 cubits 2 hands
 39 cubits 5 hands
 41 cubits 10 hands
 43 cubits 2 hands
 43 cubits 5 hands
 43 cubits 6 hands
 51 cubits 2 hands
 54 cubits 14 hands
 55 cubits 8 hands
 56 cubits 3 hands
 57 cubits 12 hands
 62 cubits 15 hands
 63 cubits 0 hands
 64 cubits 13 hands
 67 cubits 3 hands
 70 cubits 0 hands
 73 cubits 5 hands
 74 cubits 7 hands
 75 cubits 9 hands
 81 cubits 5 hands
 85 cubits 14 hands
 86 cubits 3 hands
 90 cubits 13 hands
 91 cubits 3 hands
 92 cubits 1 hands
 92 cubits 8 hands
 96 cubits 1 hands
 98 cubits 8 hands
 99 cubits 5 hands
 
  ----jGRASP: operation complete.    
  ************************************/
