public class SortingAlgorithms {

  //---------------------------------          INSERTION SORT           ---------------------------------//
  /**
   * INSERTION SORT
   * @param array
   */
  void insertionSort(int array[]){
    int n = array.length;

    // starting at 2nd number in the array (or first number in the unsorted/right part of the array)
    for (int i = 1; i < n; i++) {  
        int curr = array[i]; // first number in unsorted part
        int j = i - 1; // last number in sorter part
        while (j >= 0 && array[j] > curr) { // while the number still hasn't been sorted
          array[j + 1] = array[j]; // first part of swap
            j = j - 1; 
        }
        array[j + 1] = curr; // second part of swap
    }
  }
  

  //---------------------------------             QUICK SORT              ---------------------------------//
  //--------------------------------- NEED TO GET WORKING WITH DIFF PIVOT ---------------------------------//
  
  private int input[]; // used as a temp to hold the array that was passed to quickSort
  private int length;

  /**
   * Function to call quicksort using simple array
   * Could leave out but for sake of usability we'll use this
   * @param array
   */
  public void quickSort(int[] numbers) {

      if (numbers == null || numbers.length == 0) {
          return;
      }
      this.input = numbers;
      length = numbers.length;
      quickSort(0, length - 1);
  }

  /**
   * Recursive QuickSort function
   * From https://javarevisited.blogspot.com/2014/08/quicksort-sorting-algorithm-in-java-in-place-example.html 
   * Includes partition (can clean up to have in separate function)
   * @param low
   * @param high
   */
  private void quickSort(int low, int high) {
      int i = low;
      int j = high;

      // best way to get pivot as middle index
      // mathematically equivalent to (low + high) / 2 
      // but immune to overflow as "right > left"
      int pivot = input[low + (high - low) / 2]; 

      // Divide into two arrays i.e PARTITION takes place in this while loop
      while (i <= j) { // while left and right have not yet crossed paths
          /**
           * In each iteration, 
           * identify a number from left (lower) side which is greater than the pivot value
           * identify a number from right (higher) side which is less than the pivot value.
           * When search is complete, we can swap both numbers.
           */
          while (input[i] < pivot) { // while the element is in the correct place compared to the pivot
              i++;
          }
          while (input[j] > pivot) { // while the element is in the correct place compared to the pivot
              j--; 
          }

          // if left is less than right they need to be swapped. 
          // i.e check the low pointer has not gone past the right pointer
          if (i <= j) { 
              swap(i, j);
              // move index to next position on both sides
              i++;
              j--;
          }
      }

      // calls quickSort() method recursively
      if (low < j) {
          quickSort(low, j);
      }
      if (i < high) {
          quickSort(i, high);
      }
  }

  private void swap(int i, int j) {
      int temp = input[i];
      input[i] = input[j];
      input[j] = temp;
  }

  //---------------------------------        SELECTION SORT         ---------------------------------//

  /**
   * Example from https://www.geeksforgeeks.org/selection-sort/
   * @param array
   */
  void selectionSort(int array[]) 
    { 
        int n = array.length; 
        // One by one move the boundary of between the sorted (left) and unsorted (right) subarrays
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int minimumUnsortedElement = i; 
            for (int j = i+1; j < n; j++) {
              if (array[j] < array[minimumUnsortedElement]) {
                minimumUnsortedElement = j; 
              }
            }
            // Swap the first element in the unsorted array with the lowest number found in it
            swap(array, minimumUnsortedElement, i); 
        } 
    }

    private void swap(int[] array, int i, int j) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
  }

  //---------------------------------             MAIN              ---------------------------------//
  /**
   * MAIN
   * @param args
   */
  public static void main(String[] args){
    int[] array = {4,5,2,7,0,1,3,7,5,2,35,233,1,2,2,4,3,2,5,6,6,8,6,9,3,2,5,6,7,8,9,84,2,6,7};

    System.out.println("Printing initial array: "); 
    for (int element: array) {
      System.out.print(element + " "); 
    }
    SortingAlgorithms algorithm = new SortingAlgorithms();
    System.out.println();
    // Can create a makefile to run these individually
    // algorithm.insertionSort(array);
    //algorithm.quickSort(array);
    algorithm.selectionSort(array);
    System.out.println("Printing sorted array: "); 
    for (int element: array) {
      System.out.print(element + " "); 
    }
    System.out.println();
  }

}