// INSERTION SORT
//
// O(n^2) running time (average and worst case)

class InsertionSort {

    void sort(int input[]) {
        int key, i;

        for(int j = 1; j < input.length; j++) {
            key = input[j];
            i = (j - 1);
            while((i >= 0) && (input[i] > key)){
                input[i + 1] = input[i];
                i = i - 1;
            }
            input[i + 1] = key;
        }

    }

    static void printArray(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }



    public static void main(String a[]){

        int[] input = {6, 3, 1, 8, 4};
        printArray(input);
        InsertionSort ob = new InsertionSort();
        ob.sort(input);
        printArray(input);
        
    }
}