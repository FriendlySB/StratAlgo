package Week7;

public class HeapSort {
    
    static void heapify(int array[], int n, int i){
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if(left < n && array[left] > array[largest]){
            largest = left;
        }
        if(right < n && array[right] > array[largest]){
            largest = right;
        }
        if(largest != i){
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            heapify(array, n, largest);
        }
    }
    
    static void heapSort(int array[], int n){
        for(int i = n/2 - 1; i >= 0; i--){
            heapify(array, n, i);
        }
        for(int i = n - 1; i >= 0; i--){
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
        }
        
    }
    
    static void start(){
        int array[] = {5,10,2,6,9,1,3,4,8,7};
        heapSort(array, array.length);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
    
    public static void main(String args[]) {
        start();
    }
}
