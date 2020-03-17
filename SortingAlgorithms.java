public class SortingAlgorithms {

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

  /**
   * PARTITION part of QUICKSORT
   * @param arr => initial array
   * @param low => low index
   * @param high => highest index
   * @return
   */
  int partition(int arr[], int low, int high) { 
    int pivot = arr[high]; // taking the high value to be pivot but there are better ways to choose the pivot!!!!
    int i = (low-1); // index of smaller element 
    for (int j=low; j<high; j++) 
    { 
        // If current element is smaller than the pivot 
        if (arr[j] < pivot) 
        { 
            i++; 

            // swap arr[i] and arr[j] 
            int temp = arr[i]; 
            arr[i] = arr[j]; 
            arr[j] = temp; 
        } 
    } 

    // swap arr[i+1] and arr[high] (or pivot) 
    int temp = arr[i+1]; 
    arr[i+1] = arr[high]; 
    arr[high] = temp; 

    return i+1; 
  } 
  
  /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
  void quickSort(int arr[], int low, int high) { 
    if (low < high) 
    { 
        /* pi is partitioning index, arr[pi] is  
          now at right place */
        int pi = partition(arr, low, high); 

        // Recursively sort elements before 
        // partition and after partition 
        quickSort(arr, low, pi-1); 
        quickSort(arr, pi+1, high); 
    } 
  } 

  /**
   * MAIN
   * @param args
   */
  public static void main(String[] args){
    int[] array = {4, 5, 2, 7, 0, 1, 3, 7};
    System.out.println("Printing initial array: "); 
    for (int element: array) {
      System.out.print(element + " "); 
    }
    SortingAlgorithms algorithm = new SortingAlgorithms();

    System.out.println("");

    algorithm.insertionSort(array);
    System.out.println("Printing sorted array: "); 
    for (int element: array) {
      System.out.print(element + " "); 
    }
    System.out.println("");
  }

}