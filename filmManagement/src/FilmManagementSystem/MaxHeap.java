package FilmManagementSystem;


public class MaxHeap {
    public final int maxSize;
    public final int[] heap;
    public int currentSize;
    
    public MaxHeap(int maxSize) {
        this.heap = new int[maxSize];
        this.currentSize = -1;
        this.maxSize = maxSize;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public int leftChild(int i) {
        return 2 * i + 1;
    }

    public int rightChild(int i) {
        return 2 * i + 2;
    }

    public void insert(int data) {
        if (currentSize == maxSize - 1) {
            System.out.println("The heap is full. Cannot insert");
            return;
        }

        currentSize++;
        this.heap[currentSize] = data;
        int currentIndex = currentSize;
        int temp;
         
        while (this.heap[this.parent(currentIndex)] < this.heap[currentIndex]) {
            temp = heap[currentIndex]; 
            heap[currentIndex] = heap[parent(currentIndex)];
            heap[parent(currentIndex)] = temp;
            currentIndex = this.parent(currentIndex);
        }
    }

    public void maxHeapify(int i) {
        int left = this.leftChild(i);
        int right = this.rightChild(i);
        int largest = i;

        if (left <= currentSize && heap[left] > heap[largest]) {
            largest = left;
        }
        
        if (right <= currentSize && heap[right] > heap[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largest);
        }
    }

    public int getMax() {
        return heap[0];
    }

    public int extractMax() {
        int maxItem = this.heap[0];
        this.heap[0] = this.heap[currentSize];
        currentSize = currentSize - 1;
        maxHeapify(0);
        return maxItem;
    }

    public void printHeap() {
        for (int i = 0; i <= currentSize; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}