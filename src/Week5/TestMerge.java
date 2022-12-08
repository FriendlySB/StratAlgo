package Week5;

public class TestMerge {

    static void merge(int array[], int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
 
        int leftArr[] = new int[n1];
        int rightArr[] = new int[n2];
 
        for (int i = 0; i < n1; ++i){
            leftArr[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j){
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
 
    static void sort(int arr[], int l, int r)
    {
        if (l < r) {
            int m = l + (r - l) / 2;
 
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            merge(arr, l, m, r);
        }
    }
 
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
 
        System.out.println("Given Array");
        printArray(arr);
 
        sort(arr, 0, arr.length - 1);
 
        System.out.println("\nSorted array");
        printArray(arr);
    }
}
