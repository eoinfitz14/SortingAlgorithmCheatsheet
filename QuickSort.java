/**
* Java Program sort numbers using QuickSort Algorithm. QuickSort is a divide
* and conquer algorithm, which divides the original list, sort it and then
* merge it to create sorted output.
*
* @author Javin Paul
*/
class QuickSort {

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


  public static void main(String[] args){
    int[] array = {4,5,2,7,0,1,3,7,5,2,35,233,1,2,2,4,3,2,5,6,6,8,6,9,3,2,5,6,7,8,9,84,2,6,7};

    System.out.println("Printing initial array: "); 

    for (int element: array) {
      System.out.print(element + " "); 
    }

    QuickSort algorithm = new QuickSort();

    System.out.println();

    // Can create a makefile to run these individually
    // algorithm.insertionSort(array);
    algorithm.quickSort(array);

    System.out.println("Printing sorted array: "); 

    for (int element: array) {
      System.out.print(element + " "); 
    }

    System.out.println();
  }

}