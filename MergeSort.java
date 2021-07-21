public class MergeSort {

    void merge(int input[], int l, int m, int r){

        // Determe the size of the two sub-arrays
        int n1 = (m - l) + 1;
        int n2 = r - m;

        // New Sub-Arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Put data from original array into the sub-arrays
        for(int i = 0; i < n1; ++i){
            L[i] = input[l + i];
        }
        for(int j = 0; j < n2; ++j){
            R[j] = input[m + 1 + j];
        }

        // Indexes of the two sub-arrays
        int left = 0, right = 0;

        // Take the smallest value from either sub-array and add it to the original array
        // one at a time, resulting in the sorting of the values.
        int k = l;
        while((left < n1) && (right < n2)){
            if(L[left] <= R[right]) {
                input[k] = L[left];
                left++;
            }
            else {
                input[k] = R[right];
                right++;
            }
            k++;
        }

        // If necessary, add any leftover values from the sub-arrays to the sorted array
        while(left < n1){
            input[k] = L[left];
            left++;
            k++;
        }
        while(right < n2){
            input[k] = R[right];
            right++;
            k++;
        }


    }

    void sort(int input[], int l, int r){
        if (l < r) {
            int m =(l + r) / 2;
            
            sort(input, l, m);
            sort(input, m + 1, r);

            merge(input, l, m, r);
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
        int arr[] = { 12, 11, 13, 5, 6, 7};

        System.out.println("Original unsorted Array...");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, (arr.length - 1));

        System.out.println("\nVoila! Sorted Array...");
        printArray(arr);

    }
    
}
