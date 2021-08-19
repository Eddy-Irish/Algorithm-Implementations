public class MergeSort {
/*  Implementation of MergeSort Algorithm.
    TIME COMPLEIXTY: O(n log n) (Best, Average, & Worst-Case)
    SPACE COMPLEXITY: O(n)
      - MergeSort is an efficient, general-purpose comparison-sorting based algorithm
      - MergeSort is a Divide-and-Conquer Algorithm, with most implementations resulting
        in a stable sort.
      - The main drawback of MergeSort is its Space Complexity, which requires that memory for
        an auxilary array(s) to be created.

*/
    void merge(int input[], int L, int M, int R){

        // Determe the size of the two sub-arrays
        int n1 = (M - L) + 1;
        int n2 = R - M;

        // New Sub-Arrays
        int Left[] = new int[n1];
        int Right[] = new int[n2];

        // Put data from original array into the sub-arrays
        for(int i = 0; i < n1; ++i){
            Left[i] = input[L + i];
        }
        for(int j = 0; j < n2; ++j){
            Right[j] = input[M + 1 + j];
        }

        // Indexes of the two sub-arrays
        int left = 0, right = 0;

        // Take the smallest value from either sub-array and add it to the original array
        // one at a time, resulting in the sorting of the values.
        int k = L;
        while((left < n1) && (right < n2)){
            if(Left[left] <= Right[right]) {
                input[k] = Left[left];
                left++;
            }
            else {
                input[k] = Right[right];
                right++;
            }
            k++;
        }

        // If necessary, add any leftover values from the sub-arrays to the sorted array
        while(left < n1){
            input[k] = Left[left];
            left++;
            k++;
        }
        while(right < n2){
            input[k] = Right[right];
            right++;
            k++;
        }


    }

    void sort(int input[], int L, int R){
        if (L < R) {
            int m =(L + R) / 2;
            
            sort(input, L, m);
            sort(input, m + 1, R);

            merge(input, L, m, R);
        }

    }


    static void printArray(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String args[]){
        int arr[] = { 12, 11, 13, 5};

        System.out.println("Original unsorted Array...");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, (arr.length - 1));

        System.out.println("\nVoila! Sorted Array...");
        printArray(arr);

    }
    
}
