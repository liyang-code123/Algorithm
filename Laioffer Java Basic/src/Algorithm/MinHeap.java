import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {

    int[] array;
    int size;

    public MinHeap(int[] array, int size) {
        this.array = array;
        this.size = size;
        heapify();
    }

    public void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (array[parentIndex] > array[index]) {
                swap(array, parentIndex, index);
            } else {
                break;
            }
            index = parentIndex;
        }
    }

    public void percolateDown(int index) {
        while (index <= size/ 2 - 1) {
            int leftChild = index * 2 + 1;
            int rightChild = index * 2 + 2;
            int swapCandidate = leftChild;
            if (rightChild <= size - 1 && array[leftChild] > array[rightChild]) {
                swapCandidate = rightChild;
            }
            if (array[index] > array[swapCandidate]) {
                swap(array, index, swapCandidate);
            } else {
                break;
            }
            // this is to move the index to the next level.
            index = swapCandidate;
        }
    }

    public void offer(int value) {
        if (size == array.length) {
            array = Arrays.copyOf(array, (int)(array.length * 1.5));
        }
        array[size] = value; // this size is original size.
        size++;
        percolateUp(size - 1); // this is updated size.
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        int result = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return result;
    }

    public int update(int index, int value) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("Invalid index range.");
        }
        int result = array[index];
        array[index] = value;
        if (result > value) {
            percolateUp(index);
        } else {
            percolateDown(index);
        }
        return result;
    }

    public void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }
    public void swap (int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }


    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 2, 1, 4, 9, 8};
        int size = array.length;
        int value = 100;
        int index = 6;
        MinHeap test = new MinHeap(array, size);
        System.out.println(test.update(index, value));
        while (!test.isEmpty()) {
            System.out.println(test.poll());
        }
    }
}
