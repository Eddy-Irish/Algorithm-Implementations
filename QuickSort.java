/* Implementation of QuickSort Algorithm.
    TIME COMPLEXITY: O(n log n) [On Average, and in most cases]; O(n^2) [Worst-case in rare situations]
    SPACE COMPLEXITY: O(log n) [Best & Avg. Cases]; O(n) [worst-case] in this version, which is a naive 
                      implementation that does not use tail recursion or iteration for the larger subarray,
                      but recursively sorts each subarray.
                      O(log n) [worst, best, & avg cases] in versions that use tail recursion or iteration.

    - When implemented well, QuickSort is slightly faster than MergeSort, & 2-3x faster than HeapSort.
    - Usually, QuickSort implementations are NOT a stable sort algorithm.
    - The java.util.Arrays class utilizes a dual-pivot Quicksort for sorting primitive type Arrays
    */

public class QuickSort {

    /**
     * <p>QuickSort Method that calls Partition Method, and then uses recursive RunQuickSort
     *    calls to sort the subarrays until they are only one element long </p>
     * 
     * @param arr
     * @param low
     * @param high
     */
    public static void RunQuickSort(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = Partition(arr, low, high);

            RunQuickSort(arr, low, (pivotIndex - 1));
            RunQuickSort(arr, (pivotIndex + 1), high);
        }
    }

    /**
     * <p>Partition method that uses the LAST ELEMENT as the pivot, places the pivot
     *    at the correct position in sorted array, and places values smaller than the pivot
     *    into a subarray to the left of the pivot, and the values larger than the pivot
     *    into a subarray to the right of the pivot. </p>
     * 
     * @param arr
     * @param low
     * @param high
     * @return Index of pivot element
     */
    public static int Partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = (low - 1);
        int temp, pivotIndex;

        for(int j = low; j <= (high - 1); j++){
            if(arr[j] < pivot){
                i++;
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;  
            }
        }
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        pivotIndex = (i + 1);

        return pivotIndex;
    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(" [" + arr[i] + "] ");
        }
    }

    public static void main(String[] args){

        int[] input = new int[] {17, 56, 12, 81, 3, 15, 22};
        System.out.print("Array before sorting: ");
        printArray(input);

        RunQuickSort(input, 0, (input.length - 1));

        System.out.print("\nArray after sorting: ");
        printArray(input);

    }
    
}
