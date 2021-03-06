/* Implementing HeapSort using my MaxHeap class 
   TIME COMPLEXITY: O(n log n) [Best, avg., & worst-case]
   SPACE COMPLECITY: O(1)
   - HeapSort is an in-place comparison based sorting algorithm that does not result in a stable sort.
   - Similar to SelectionSort, but does not waste time doing a linear scan of the array, instead keeps 
     the unsorted portion in a heap structure, making finding the minimum element very easy.

*/

public class HeapSort {

    public static void main(String[] args){
        // Assorted values to be added to maxheap
        int[] heapValues = new int[] {1, 5, 9, 53, 23, 67, 19, 22, 35, 41};
        MaxHeap heap = new MaxHeap(10);


        //  HEAPSORT IMPLEMENTATION
        //   1) Inserting values into, and building the maxheap : O(n)
        for(int i = 0; i < 10; i++){
            heap.add(heapValues[i]);
        }

        // See array before sorting
        heap.printHeap();

        //   2) Exchanging heap[0] with heap[n], decreasing heap size and running heapifyDown()
        //      to restore maxheap property : O(lg n)
        for(int j = heap.getSize() - 1; j > 0; j--){
            heap.swap(0, j);
            heap.setHeapSize((heap.getSize() - 1));
            heap.heapifyDown();
        }

        // Combining the two steps results in a TIME COMPLEXITY of O(n lg n).
        // SPACE COMPLEXITY of O(1) because all operations happen in-place in input Array.

        // Array after sorting with HeapSort
        heap.printHeapArray();
    }
    
}
