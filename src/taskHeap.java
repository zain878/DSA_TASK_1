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
        return (i-1) / 2;
    }

    int leftChild(int i){
        return 2 * i + 1;
    }

    int rightChild(int i){
        return 2 * i + 2;
    }

    public void insert(int value){
        if(size == maxSize){
            System.out.println("No More Space ");
        }

        heap[size] = value;
        int current = size;
        size++;
    }

    void heapify(int i , int maxSize , int arr[]){
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if(left < maxSize && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < maxSize && arr[right] > arr[largest]){
            largest = right;
        }

        if(largest != i){
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
        }
        heapify(i , maxSize , arr);
    }

    void display(){
        for (int i = 0; i < heap.length; i++){
            System.out.print(heap[i] + " ");
        }
    }
    public static void main(String[] args) {
        taskHeap heap = new taskHeap(5);

        Scanner Scan = new Scanner(System.in);

        for (int i = 0; i < 5; i++){
            System.out.println("Enter The Element " + (i + 1));
            int element = Scan.nextInt();
            heap.insert(element);
        }
        heap.display();
        heap.heapify(0,5, );

    }
}
