// Testing Implementation of Max-Heap Class

public class MaxHeapTest {

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);

        for(int i = 1; i <= 10; i++){
            heap.add(i);
            heap.printHeap();
        }

    }
    
}
