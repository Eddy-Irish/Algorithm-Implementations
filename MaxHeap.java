/** 
*  <h1> Binary Max-Heap </h1>
*  Implementation of a binary heap that satisfies the MAX-HEAP Property and has
*  peekNode(), removeMaxElement(), add(), heapifyUp(), & heapifyDown() operations available.
*
*  @author Keegan O'Hara
*/

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MaxHeap {
    private int capacity;
    private int size = 0;
    private int[] heap;

    /**
     * <p> Max-Heap Constructor </p>
     * 
     * @param capacity The desired capacity of the max-heap tree
     */
    public MaxHeap(int capacity){
        this.capacity = capacity;
        this.heap = new int[capacity];
    }

    /**
     * <p> GetIndex Methods that return index integer value
     * 
     * @param parentIndex/childIndex  Index of element in heap
     * @return int                    Index of desired element
     */
    private int getLeftChildIndex(int parentIndex) { return (2 * parentIndex + 1); }

    private int getRightChildIndex(int parentIndex) { return (2 * parentIndex + 2); }

    private int getParentIndex(int childIndex) { return ((childIndex - 1) / 2); }

    /**
     * <p> Boolean methods to check if a node has certain properties
     * 
     * @param index  Index of element in heap
     * @return boolean  True if condition is true, false if it is not
     */
    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }

    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }

    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

    /**
     * <p> Getter methods for left/right child node, parent node of a given node,
     *     & current size of heap </p>
     * 
     * @param parentIndex/childIndex  Index of element whose value is to be returned
     * @return int                    Value of element at desired index, or current size of heap
     */
    private int leftChild(int parentIndex) { return heap[getLeftChildIndex(parentIndex)]; }

    private int rightChild(int parentIndex) { return heap[getRightChildIndex(parentIndex)]; }

    private int parent(int childIndex) { return heap[getParentIndex(childIndex)]; }

    public int getSize() { return size; }

    /**
     * <p> Method to swap two nodes in max-heap </p>
     * 
     * @param index1  Index of first element to be swapped
     * @param index2  Index of second element to be swapped
     */
    private void swap(int index1, int index2) {
        int element = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = element;
    }

    public void add(int item) {
        ensureCapacity();
        heap[size] = item;
        size++;
        heapifyUp();
    }

    /**
     * <p> Method that ensures the heap will have enough capacity to add a new element </p>
     */
    private void ensureCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, (capacity * 2));
            capacity *= 2;
        }
    }

    /**
     * <p> peekNode() method returns the value of the root node in the max-heap </p>
     * TIME COMPLEXITY --> O(1).
     * 
     * @return int  Value of the root node
     */
    public int peekNode() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    /**
     * <p> removeMaxElement() method removes the max (root) element of the heap, adjusts the size
     *     of the heap, and calls heapifyDown() to maintain heap property after removal of the root. </p>
     * TIME COMPLEXITY --> O(Log n)
     */
    public void removeMaxElement(){
        if (size == 0) {
            throw new NoSuchElementException();
        }
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
    }

    /**
     * <p> Method that starts at the root of the heap and works down through the tree to ensure
     *     that the max-heap property is maintained, swapping elements as needed. </p>
     */
    private void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int greatestChildIndex = getLeftChildIndex(index);

            if (hasRightChild(index) && (rightChild(index) > leftChild(index))) {
                greatestChildIndex = getRightChildIndex(index);
            }

            if (heap[index] < heap[greatestChildIndex]) {
                swap(index, greatestChildIndex);
            }
            else { break; }
            index = greatestChildIndex;
        }
    }

    /**
     * <p> Method that starts at the last node in the tree and works up the tree to ensure
     *     that the max-heap property is maintained, swapping elements as needed </p>
     */
    private void heapifyUp() {
        int index = size - 1;

        while (hasParent(index) && (parent(index) < heap[index])) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    /**
     * <p> Method to print values in the max-heap
     */
    public void printHeap() {
        System.out.print("HEAP VALUES : ");
        for (int i = 0; i < size; i++) { System.out.print(heap[i] + " "); }
        System.out.print("\n");
    }
}