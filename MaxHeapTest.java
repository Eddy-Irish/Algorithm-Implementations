// Testing Implementation of Max-Heap Class

public class MaxHeapTest {

    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(6);

        for(int i = 1; i <= 6; i++){
            heap.add(i);
            heap.printHeap();
        }

        int root = heap.peekNode();
        System.out.println(root);
        int heapSize = heap.getSize();
        System.out.println("Heap Size : " + heapSize);
        heap.removeMaxElement();
        heap.printHeap();
        int newRoot = heap.peekNode();
        System.out.println("Value of new root node after removing previous root node " + newRoot);

    }
    
}
