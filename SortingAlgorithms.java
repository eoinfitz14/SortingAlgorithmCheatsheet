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
  /**
   * Function to call quicksort using simple array
   * Could leave out but for sake of usability we'll use this
   * @param array
   */
  void quickSort(int[] array) {
    quickSort(array, 0, array.length - 1);
  }

  /**
   * Actual QuickSort (recursive) function 
   * From Gayle Laakmann McDowell on Hackerrank
   * @param array
   * @param left
   * @param right
   */
  void quickSort(int[] array, int left, int right){
    if(left >= right){ // we don't need to do anything in this case so return
      return;
    }
    int index = partition(array, left, right); // get dividing point between left and right
    quickSort(array, left, index-1); // sort left side
    quickSort(array, index, right);  // sort right side
  }

  int partition(int[] array, int left, int right){
    int pivot = array[(left+right)/2]; // median as pivot method
    while(left <= right){ // while the left index and right index have not crossed paths
      while(array[left] < pivot) { // while the element is in the right place compared to the pivot 
        left++;
      }

      while(array[right] > pivot){
        right--;
      }

      // if left is less than right they need to be swapped. We check if it's <= 
      // as if they are equal the left and right pointers still need to be incremented so that the correct partition is returned
      if(left <= right){ 
        swap(array, left, right);
        left++;
        right--;
      }
    }
    return left;
  }

  int[] swap(int[] array, int left, int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;

    return array;
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
    algorithm.quickSort(array);

    System.out.println("Printing sorted array: "); 

    for (int element: array) {
      System.out.print(element + " "); 
    }

    System.out.println();
  }

}