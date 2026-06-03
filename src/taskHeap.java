import java.util.Scanner;

public class taskHeap {
    int[] heap;
    int size;
    int maxSize;

    taskHeap(int maxSize){
        this.maxSize = maxSize;
        heap = new int[maxSize];
        size = 0;
    }

    int parent(int i){
        return (i - 1) / 2;
    }

    int leftChild(int i){
        return 2 * i + 1;
    }

    int rightChild(int i){
        return 2 * i + 2;
    }

    public void insert(int value){
        if(size == maxSize){
            System.out.println("No More Space");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        while(current > 0 && heap[current] > heap[parent(current)]){
            int temp = heap[current];
            heap[current] = heap[parent(current)];
            heap[parent(current)] = temp;
            current = parent(current);
        }
    }

    void heapify(int i, int n, int arr[]){
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if(left < n && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < n && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(largest, n, arr);
        }
    }

    void display(){
        for (int i = 0; i < size; i++){
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        taskHeap heap = new taskHeap(5);
        Scanner Scan = new Scanner(System.in);

        for (int i = 0; i < 5; i++){
            System.out.println("Enter The Element " + (i + 1));
            int element = Scan.nextInt();
            heap.insert(element);
        }

        System.out.println("Heap after insertion:");
        heap.display();

        for(int i = (heap.size / 2) - 1; i >= 0; i--){
            heap.heapify(i, heap.size, heap.heap);
        }

        System.out.println("Heap after heapify:");
        heap.display();
    }
}
