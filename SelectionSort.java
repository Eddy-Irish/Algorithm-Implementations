/*  Implementation of SelectionSort
    TIME COMPLEXITY: O(n^2) (Best, Average, & Worst Case) 
                    [With best, avg, & worst case of O(1), O(n), O(n) swaps, respectively]
    SPACE COMPLEXITY: O(1) Auxiliary space required
    - SelectionSort is an in-place comparison sorting algorithm that does not work well on large
      lists, but can be effective in cases where auxiliary memory is limited due to it being an
      in-place sorting algorithm.
*/

public class SelectionSort {

    public static void Sort(int[] input){
        int len = input.length;
        int smallestValue = (input[len - 1]);
        int smallestIndex = (len - 1);
        int startIndex = 0; int temp = 0;

        /* Iterate through array, finding the smallest element and storing its value and index.
           When every element has been compared, swap the smallest element to the front and 
           repeat the process for the subarray of all elements except the one(s) moved to the front. 
        */
        while(startIndex < (len - 1)){
            for(int i = startIndex; i < len; i++){
                if(input[i] < smallestValue){
                    smallestValue = input[i];
                    smallestIndex = i;
                }
            }

            // Swap smallest element to front of array, unless the smallest element is already at the front
            if(input[startIndex] != smallestValue){
                temp = input[startIndex];
                input[startIndex] = input[smallestIndex];
                input[smallestIndex] = temp;
            }
            startIndex++;
            smallestValue = (input[len - 1]);
            smallestIndex = (len - 1);
        }

    }

    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(" [" + arr[i] + "] ");
        }
    }

    public static void main(String[] args){

        int[] array = new int[]{7, 113, 89, 23, 56, 71};
        System.out.print("Array Before Sorting: ");
        printArray(array);

        Sort(array);
        System.out.print("\nArray After Sorting: ");
        printArray(array);

    }
    
}
