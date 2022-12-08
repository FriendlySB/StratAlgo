package Week5;

public class MergeSort {
    
    static void merge(int[] array, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];
        
        for (int i = 0; i < n1; i++){
            leftArr[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++){
            rightArr[j] = array[mid + 1 + j];
        }
        
        int i = 0;
        int j = 0;
        int k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                array[k] = leftArr[i];
                i++;
            }
            else {
                array[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            array[k] = leftArr[i];
            i++;
            k++;
        }
 
        while (j < n2) {
            array[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    static void sort(int[] array, int left, int right){
        if(left < right){
            int mid = left + (right - left)/2;
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
        
    }
    
    static void start(){
        int array[] = {2,6,7,1,5,4,8,3};
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        sort(array, 0, array.length - 1);
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }    
    public static void main(String args[]) {
        start();
    }
}
